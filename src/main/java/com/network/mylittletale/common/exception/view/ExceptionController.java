package com.network.mylittletale.common.exception.view;

import com.network.mylittletale.common.exception.member.MemberRegistException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MemberRegistException.class)
    public String handleMemberRegistException(Exception e, Model model){

        model.addAttribute("exception", e);

        return "common/errors/error-regist";
    }

}