package com.network.mylittletale.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/", "classpath:/database/");

//        // 이미지 불러올수 있도록 세팅
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("classpath:/upload/");
    }
}
