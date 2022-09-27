package com.network.mylittletale.common.exception.view;


import com.network.mylittletale.common.exception.member.MemberModifyException;
import com.network.mylittletale.common.exception.member.MemberRegistException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping("/*")
public class ExceptionController {


    @ExceptionHandler(MemberRegistException.class)
    public ModelAndView handleMemberRegistException(ModelAndView mv){

        System.out.println("일로 오나??");
        mv.setViewName("common/errors/error-regist");

        return mv;
    }
//    @ExceptionHandler(MemberRegistException.class)
//    public String handleMemberRegistException() {
//
//        System.out.println("일로 오나??");
//        return "common/errors/error-regist";
//    }

}