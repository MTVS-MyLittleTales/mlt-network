package com.network.mylittletale.children.controller;

import com.network.mylittletale.children.model.dto.ChildrenDTO;
import com.network.mylittletale.children.model.service.ChildrenService;
import com.network.mylittletale.member.model.dto.MemberDTO;
import com.network.mylittletale.tale.model.dto.TaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("children")
public class ChildrenController {

    private ChildrenService childrenService;

    @Autowired
    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("regist")
    public ModelAndView goChildrenLocation(ModelAndView mv) {

        mv.setViewName("children/regist");

        return mv;
    }

    @PostMapping("regist")
    public ModelAndView registChild(ModelAndView mv, ChildrenDTO children, Authentication authentication, RedirectAttributes rttr) {
        MemberDTO loginedMember = (MemberDTO) authentication.getPrincipal();
        children.setMemberNo(loginedMember.getMemberNo());
//        System.out.println("children = " + children);

        System.out.println("children = " + children);
        childrenService.registChildren(children);

        rttr.addFlashAttribute("message", "자녀 등록이 완료되었습니다.");

        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("list")
    public ModelAndView findChildrenByMemberNo(ModelAndView mv, Authentication authentication) {

        MemberDTO loginedMember = (MemberDTO) authentication.getPrincipal();

        List<ChildrenDTO> childrenList = childrenService.findChildrenByMemberNo(loginedMember.getMemberNo());
        System.out.println("childrenList = " + childrenList);
        mv.addObject("childrenList", childrenList);

        mv.setViewName("children/children-list");

        return mv;
    }

    @PostMapping("delete")
    public ModelAndView deleteChildren(ModelAndView mv,@RequestParam int childrenNo, RedirectAttributes rttr) {
        System.out.println("childrenNo = " + childrenNo);
        childrenService.deleteChildren(childrenNo);

        rttr.addFlashAttribute("message", "삭제가 완료되었습니다.");
        
    @GetMapping("/get-child")
    public ModelAndView getChild(ModelAndView mv) {
//        int childNo = 0;
//        List<childrenDTO> list = childService.getTaleList(1);
//        Object[] taleList = list.stream().filter(i -> i.getCutDataDTOList().size()>3).toArray();
//        System.out.println("taleList = " + taleList);
//        System.out.println("동화 목록으로 가기!");
//        mv.addObject("list", list);
        mv.setViewName("children/get-child");
        return mv;
    }

        mv.setViewName("redirect:/children/list");
        return mv;
    }
}
