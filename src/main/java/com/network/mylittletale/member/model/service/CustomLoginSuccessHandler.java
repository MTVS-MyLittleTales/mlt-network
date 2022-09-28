package com.network.mylittletale.member.model.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component("customLoginSuccess")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        List<String> roleNames = new ArrayList<>();
        System.out.println("CustomLoginSuccessHandler.onAuthenticationSuccess");
        authentication.getAuthorities().forEach(authority -> {
            System.out.println("authority = " + authority);
            roleNames.add(authority.getAuthority());
        });
        if(roleNames.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin");
            return;
        } else if(roleNames.contains("ROLE_MEMBER")) {
            response.sendRedirect("/");
            return;
        }


    }
}
