//package com.network.mylittletale.tale.controller;
//
//
//import com.network.mylittletale.tale.model.dto.TaleDTO;
//import com.network.mylittletale.tale.model.service.TaleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("tale")
//public class TaleController {
//
//    private TaleService taleService;
//
//    @Autowired
//    public TaleController(TaleService taleService) {
//        this.taleService = taleService;
//    }
//
//    @GetMapping("/list")
//    public ModelAndView findTaleList(ModelAndView mv){
//        System.out.println("TaleController.findTaleList");
//        List<TaleDTO> taleList = taleService.findTaleList();
//        System.out.println("taleList = " + taleList);
//        mv.addObject("taleList", taleList);
//
//        mv.setViewName("tale/list");
//        return mv;
//    }
//
//}
//
package com.network.mylittletale.tale.controller;


import com.network.mylittletale.tale.model.dto.CutDataDTO;
import com.network.mylittletale.tale.model.dto.TaleDTO;
import com.network.mylittletale.tale.model.service.TaleService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.*;


@Controller
@RequestMapping("/tale")
@CrossOrigin("*")
public class TaleController {

    private int sequence;
    private int cutSequence = 0;

    private final String pythonRootPath = "http://119.194.163.123:7777";
    private int taleSequence;
    private TaleService taleService;
    @Autowired
    public TaleController(TaleService taleService) {
        this.taleService = taleService;
    }

    @GetMapping
    public ModelAndView indexView(ModelAndView mv){
        mv.setViewName("member/tale/index");
        return mv;
    }


    @GetMapping("image")
    public ModelAndView inputImagePage(ModelAndView mv){
        mv.setViewName("member/tale/getimage");
        return mv;
    }

    @GetMapping("result2")
    public ModelAndView imageInputPage(ModelAndView mv){
        mv.setViewName("member/tale/result2");
        return mv;
    }

    @GetMapping("gettext")
    public ModelAndView testPage(ModelAndView mv){
        mv.setViewName("member/tale/gettext");
        return mv;
    }
    @PostMapping("getimage")
    @Transactional
    public synchronized ModelAndView getdInputImage(ModelAndView mv, @RequestParam MultipartFile singleFile, RedirectAttributes rttr, HttpServletRequest request, @AuthenticationPrincipal UserDetails user) throws IOException {
        System.out.println(singleFile);
        String imageData = Base64.getEncoder().encodeToString(singleFile.getBytes());
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = pythonRootPath + "/getimage";

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", imageData);
        HttpEntity<?> requestMessage = new HttpEntity<>(body, headers);
        HttpEntity<String> aiResponse = restTemplate.postForEntity(url, requestMessage, String.class);
        JSONParser parser = new JSONParser();
        
        String filePath = "\\public";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }

        try {
            JSONObject data = (JSONObject) parser.parse(aiResponse.getBody());
            String resultText = (String) data.get("text");
            String resultImage = (String) data.get("image");
            String resultByte = resultImage.replace("\n", "");

            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(resultByte));
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ImageIO.write(bufferedImage, "png", new File(filePath + "\\result" + sequence + ".png"));

            //동화 생성에 필요한 아이번호, 동화번호 값으로 동화 만들기\

            if(cutSequence==0) {
                taleSequence = taleService.getTaleSequence();
                Map<String, Integer> tale = new HashMap<>();
                tale.put("taleNo", taleSequence);
                tale.put("childNo", 1);
                taleService.insertTale(tale);
                cutSequence = 1;
            }
            System.out.println("cutSequence1 = " + cutSequence);

            CutDataDTO cutDataDTO = new CutDataDTO();
            cutDataDTO.setCutNo(sequence);
            cutDataDTO.setInputSentence(resultText);
            cutDataDTO.setCutSequence(cutSequence);
            cutDataDTO.setTaleNo(taleSequence);
            cutDataDTO.setImgName("result" + sequence + ".png");
            cutDataDTO.setMemberYN("Y");
            System.out.println("cutDataDTO = " + cutDataDTO);
            taleService.insertCutData(cutDataDTO);
            cutSequence = taleService.getCutSequence(taleSequence);
            cutSequence += 1;
            if(cutSequence==5){
                cutSequence = 0;
                mv.setViewName("redirect:/tale/detail/"+taleSequence);
            }else{
                mv.setViewName("redirect:/tale/final-img");
            }

            System.out.println("cutSequence2 = " + cutSequence);
            rttr.addFlashAttribute("imageName", "result" + sequence + ".png");

        }catch (Exception e){
            e.printStackTrace();
        }

        return mv;
    }

    @PostMapping("gettext")
    public ModelAndView getInputText(ModelAndView mv, @RequestParam String content, HttpSession httpSession, RedirectAttributes rttr) {
        sequence = taleService.getCutNo();
        String url = pythonRootPath + "/gettext";
        System.out.println("url = " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> text = new LinkedMultiValueMap<>();
        text.add("text", content);

        HttpEntity<?> requestMessage = new HttpEntity<>(text, headers);
        RestTemplate restTemplate = new RestTemplate();
        
        HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);
        JSONParser parser = new JSONParser();

        String filePath = "\\public";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }

        try{
        JSONObject data = (JSONObject) parser.parse(response.getBody());
        String resultImage = (String) data.get("image");
        String resultByte = resultImage.replace("\n", "");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(resultByte));
        BufferedImage bufferedImage = ImageIO.read(inputStream);

        ImageIO.write(bufferedImage, "png", new File(filePath+"\\result"+ sequence +".png"));

        }catch (Exception e){
            e.printStackTrace();
        }

        rttr.addFlashAttribute("imageName", "result"+sequence+".png");
        mv.setViewName("redirect:/tale/select-img");

        return mv;
    }

    @GetMapping(value = "img/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable("fileName") String fileName) throws IOException {
        System.out.println("getImage");
        System.out.println("fileName = " + fileName);
        byte[] resultImage = Files.readAllBytes(new File("\\public\\"+fileName).toPath());
        System.out.println("resultImage = " + resultImage);
        return resultImage;
    }
    @GetMapping("result")
    public ModelAndView responseURL(ModelAndView mv){
        mv.setViewName("member/tale/result");
        return mv;
    }

    @GetMapping("/create")
    public String createTale() {

        System.out.println("동화 만들러 가기!");
        return("tale/create");
    }

    @GetMapping("/get-story")
    public String getStory() {

        System.out.println("문장을 받아라!");
        return("tale/get-story");
    }

    @GetMapping("/select-img")
    public String selectImg() {

        System.out.println("사진이 마음에 드나!");
        return("tale/select-img");
    }

    @GetMapping("/upload-img")
    public String uploadImg() {

        System.out.println("사진을 업로드 하겠나!");
        return("tale/upload-img");
    }


    @GetMapping("/list")
    public ModelAndView goTaleList(ModelAndView mv) {
        int childNo = 0;
        List<TaleDTO> list = taleService.getTaleList(1);
        Object[] taleList = list.stream().filter(i -> i.getCutDataDTOList().size()>3).toArray();
        System.out.println("taleList = " + taleList);
        System.out.println("동화 목록으로 가기!");
        mv.addObject("taleList", taleList);
        mv.setViewName("tale/list");
        return mv;
    }

    @GetMapping("/final-img")
    public String showFinalImg() {

        System.out.println("최종 이미지 확인!");
        return("tale/final-img");
    }

    @GetMapping("temp")
    public ModelAndView tempPage(ModelAndView mv){

        mv.setViewName("/tale/detail");

        return mv;
    }

    @GetMapping("result3")
    public ModelAndView resultPage(ModelAndView mv) {
        mv.setViewName("member/tale/result3");
        return mv;
    }

    @GetMapping("/detail/{taleNo}")
    public ModelAndView goTaleDetail(ModelAndView mv, @PathVariable("taleNo")int taleNo) {
        List<CutDataDTO> cutList = taleService.getTales(taleNo);

        System.out.println("cutList.get(0) = " + cutList.get(0));

        mv.addObject("firstCutImgName", cutList.get(0).getImgName());
        mv.addObject("secondCutImgName", cutList.get(1).getImgName());
        mv.addObject("thirdCutImgName", cutList.get(2).getImgName());
        mv.addObject("fourthCutImgName", cutList.get(3).getImgName());
        mv.addObject("firstCutContent", cutList.get(0).getInputSentence());
        mv.addObject("secondCutContent", cutList.get(1).getInputSentence());
        mv.addObject("thirdCutContent", cutList.get(2).getInputSentence());
        mv.addObject("fourthCutContent", cutList.get(3).getInputSentence());
        System.out.println("4컷 동화 보러 가기");
        mv.setViewName("tale/detail");
        return mv;
    }

    @GetMapping("/get-child")
    public ModelAndView getChildInfo(ModelAndView mv){
        mv.setViewName("tale/get-child");
        return mv;
    }



//    @GetMapping(value = "thumnail/{taleNo}", produces = MediaType.IMAGE_PNG_VALUE)
//    @ResponseBody
//    public byte[] getThumnail (@PathVariable("taleNo") int taleNo) throws IOException {
//        List<CutDataDTO> cutDataDTOList = taleService.getTales(1);
//        String fileName = cutDataDTOList.get(0).getImgName();
//        File file = new File("\\public\\"+fileName);
//
//        byte[] byteImage = Files.readAllBytes(file.toPath());
//        return byteImage;
//    }


}

