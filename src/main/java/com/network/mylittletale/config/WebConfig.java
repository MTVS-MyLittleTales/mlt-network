package com.network.mylittletale.config;

import com.network.mylittletale.children.model.service.ChildrenService;
import com.network.mylittletale.interceptor.ChildrenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ChildrenService childrenService;

    @Autowired
    public WebConfig(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/", "classpath:/database/",  "classpath:/upload/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ChildrenInterceptor(childrenService))
                    .addPathPatterns("/tale/**");
    }
}
