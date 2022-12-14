package com.network.mylittletale.common.exception.view;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private String VIEW_PATH = "/errors/";

    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);


        if(status != null){
            int statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.FORBIDDEN.value()){
                return VIEW_PATH + "403";
            }
        }
        return "error";
    }

}
