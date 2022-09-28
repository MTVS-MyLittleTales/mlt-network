package com.network.mylittletale.tale.controller;


import com.network.mylittletale.tale.model.dto.ChildDTO;
import com.network.mylittletale.tale.model.service.TaleService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;

@Controller
@RequestMapping("tale")
public class TaleController {
    int sequence = 0;
    int taleSequence = 0;
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

//    @GetMapping("getchildinfo")
//    public ModelAndView askingPage(ModelAndView mv){
//        mv.setViewName("member/tale/getchildinfo");
//        return mv;
//    }

//    @PostMapping("getchildinfo")
//    public ModelAndView getChildInfo(ModelAndView mv, @ModelAttribute ChildDTO childInfo){
//        System.out.println(childInfo);
//        mv.setViewName("member/tale/getimage");
//        return mv;
//    }

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
    public synchronized ModelAndView getdInputImage(ModelAndView mv, @RequestParam MultipartFile singFile, RedirectAttributes rttr, HttpSession httpSession) throws IOException {
        String imageData = Base64.getEncoder().encodeToString(singFile.getBytes());
        String path = httpSession.getServletContext().getRealPath("/");


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://192.168.0.23:5001/getimage";

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", imageData);
        HttpEntity<?> requestMessage = new HttpEntity<>(body, headers);
        HttpEntity<String> aiResponse = restTemplate.postForEntity(url, requestMessage, String.class);
        JSONParser parser = new JSONParser();
        
        String filePath = path + "src\\main\\resources\\upload";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }

        try{
            JSONObject data = (JSONObject) parser.parse(aiResponse.getBody());
            String resultImage = (String) data.get("image");
            String resultByte = resultImage.replace("\n", "");

            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(resultByte));
            BufferedImage bufferedImage = ImageIO.read(inputStream);
        sequence++;
            ImageIO.write(bufferedImage, "png", new File(filePath+"\\result"+ sequence +".png"));

        }catch (Exception e){
            e.printStackTrace();
        }

        if(taleSequence>3){
            taleSequence = 0;
        }
        rttr.addFlashAttribute("resultPath", "/upload/result"+sequence+".png");
        mv.setViewName("redirect:/tale/result2");

        return mv;
    }

    @PostMapping("gettext")
    public ModelAndView getInputText(ModelAndView mv, @RequestParam String content, HttpSession httpSession, RedirectAttributes rttr) {
        String url = "http://192.168.0.23:5001/gettext";
        String path = httpSession.getServletContext().getRealPath("/");
        System.out.println("path = " + path);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> text = new LinkedMultiValueMap<>();
        text.add("text", content);


        HttpEntity<?> requestMessage = new HttpEntity<>(text, headers);
        RestTemplate restTemplate = new RestTemplate();
        
        HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);
        JSONParser parser = new JSONParser();

        String filePath = path+"networkRepo\\src\\main\\resources\\upload";
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
//        sequence++;
        ImageIO.write(bufferedImage, "png", new File(filePath+"\\result"+ sequence +".png"));

        }catch (Exception e){
            e.printStackTrace();
        }

        if(taleSequence>3){
            taleSequence = 0;
        }

        rttr.addFlashAttribute("imagePath", "/upload/result"+sequence+".png");
        mv.setViewName("redirect:/tale/result");

        return mv;
    }
    @GetMapping("result")
    public ModelAndView responseURL(ModelAndView mv){
        mv.setViewName("member/tale/result");
        return mv;
    }
}
