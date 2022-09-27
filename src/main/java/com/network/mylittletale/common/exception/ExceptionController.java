package com.network.mylittletale.common.exception;


import com.network.mylittletale.common.exception.member.MemberModifyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    @ExceptionHandler(MemberModifyException.class)
    public ModelAndView handleMemberModifyException(ModelAndView mv){

        mv.setViewName("error/");

        return mv;
    }

}
