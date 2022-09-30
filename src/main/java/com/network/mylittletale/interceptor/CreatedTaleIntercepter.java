package com.network.mylittletale.interceptor;

import com.network.mylittletale.tale.model.service.TaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreatedTaleIntercepter implements HandlerInterceptor {
    public CreatedTaleIntercepter() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        System.out.println("cookies = " + cookies);
        for(int i = 0; i < cookies.length; i++){
            if(cookies[i].getName().equals("childNo")){
                System.out.println("cookies = " + cookies[i]);
                return true;
            }
        }
        response.sendRedirect(request.getContextPath()+"/tale/get-child");
        return false;
    }
}
