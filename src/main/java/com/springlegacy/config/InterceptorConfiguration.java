package com.springlegacy.config;

import aj.org.objectweb.asm.Handle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class InterceptorConfiguration implements WebMvcConfigurer {

    private HandlerInterceptor customInterceptor;

    @Autowired
    public InterceptorConfiguration(HandlerInterceptor customInterceptor){
        this.customInterceptor = customInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.customInterceptor).addPathPatterns("/**").excludePathPatterns();
    }

    @Bean
    public HandlerInterceptor handlerInterceptor(){
        return new CustomInterceptor();
    }
}
