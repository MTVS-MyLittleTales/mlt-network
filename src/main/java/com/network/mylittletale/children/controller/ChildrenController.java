package com.network.mylittletale.children.controller;

import com.network.mylittletale.children.model.dto.ChildrenDTO;
import com.network.mylittletale.children.model.service.ChildrenService;
import com.network.mylittletale.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("children")
public class ChildrenController {

    private ChildrenService childrenService;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("regist")
    public ModelAndView goChildrenLocation(ModelAndView mv) {

        mv.setViewName("/children/regist");

        return mv;
    }

    @PostMapping("regist")
    public ModelAndView registChild(ModelAndView mv, ChildrenDTO children, Authentication authentication){
        MemberDTO loginedmember = (MemberDTO) authentication.getPrincipal();
        children.setMemberNo(loginedmember.getMemberNo());
//        System.out.println("children = " + children);

        System.out.println("children = " + children);
        childrenService.registChildren(children);

        mv.setViewName("redirect:/");
        return mv;
    }
}
