package com.network.mylittletale.tale.controller;


import com.network.mylittletale.tale.model.dto.TaleDTO;
import com.network.mylittletale.tale.model.service.TaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("tale")
public class TaleController {

    private TaleService taleService;

    @Autowired
    public TaleController(TaleService taleService) {
        this.taleService = taleService;
    }

    @GetMapping("/list")
    public ModelAndView findTaleList(ModelAndView mv){
        System.out.println("TaleController.findTaleList");
        List<TaleDTO> taleList = taleService.findTaleList();
        System.out.println("taleList = " + taleList);
        mv.addObject("taleList", taleList);

        mv.setViewName("tale/list");
        return mv;
    }

}
