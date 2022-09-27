package com.network.mylittletale.admin.controller;

import com.network.mylittletale.admin.model.dto.AdminMemberDTO;
import com.network.mylittletale.admin.model.dto.AdminTaleAndChildrenDTO;
import com.network.mylittletale.admin.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public String adminDefaultLocation() {
        return "admin/admin-index";
    }

    @GetMapping("member-list")
    public ModelAndView adminMemberList(ModelAndView mv) {

        List<AdminMemberDTO> memberList = adminService.findMemberList();

        for (AdminMemberDTO adminMemberDTO : memberList) {
            System.out.println("adminMemberDTO = " + adminMemberDTO);
        }
        mv.addObject("memberList", memberList);
        mv.setViewName("admin/contents/member-list");

        return mv;
    }

    @GetMapping("tale-list")
    public ModelAndView adminTaleList(ModelAndView mv){
        List<AdminTaleAndChildrenDTO> taleList = adminService.findTaleList();

        mv.addObject("taleList", taleList);
        mv.setViewName("admin/contents/tale-list");
        return mv;
    }

}
