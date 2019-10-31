package com.fh.shop.api.resolver;

import com.fh.shop.api.argumentReslover.MemberMethodArgumentReslover;
import com.fh.shop.api.interceptor.IdempotentInterceptor;
import com.fh.shop.api.interceptor.LoginInterceptor;
import com.fh.shop.api.member.vo.MemberVo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /*拦截器*/
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(idempotentInterceptor()).addPathPatterns("/**");
    }


    //参数解析器
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(memberMethodArgumentReslover());
    }

    //登陆拦截器
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    //幂等性拦截器
    @Bean
    public IdempotentInterceptor idempotentInterceptor(){
        return new IdempotentInterceptor();
    }

    //参数解析器
    @Bean
    public MemberMethodArgumentReslover memberMethodArgumentReslover(){
        return new MemberMethodArgumentReslover();
    }

}
