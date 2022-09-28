package com.network.mylittletale.interceptor;

import com.network.mylittletale.children.model.service.ChildrenService;
import com.network.mylittletale.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


public class ChildrenInterceptor implements HandlerInterceptor {

    private final ChildrenService childrenService;

    public ChildrenInterceptor(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        MemberDTO LoginedMember = (MemberDTO) authentication.getPrincipal();
        System.out.println("LoginedMember = " + LoginedMember);
        boolean hasChildren =  childrenService.hasChildren(LoginedMember.getMemberId());
        System.out.println("hasChildren = " + hasChildren);
        if(hasChildren){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/children/regist");
        return false;
    }
}
