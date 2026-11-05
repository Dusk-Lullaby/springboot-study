package com.sonnet.config;

import com.sonnet.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // addInterceptor 注册拦截器的方法
        // addPathPatterns 拦截器需要拦截哪些请求
        // excludePathPatterns 设置哪些资源不能拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/login", "/", "/css/**", "/js/**", "/images/**", "/fonts/**", "/fonts/**", "/images/**", "/js/**");
    }
}
