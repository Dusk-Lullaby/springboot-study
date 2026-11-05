package com.sonnet.config;

import com.sonnet.filter.MyFilter;
import com.sonnet.listener.MyListener;
import com.sonnet.servlet.ServletDemo1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyConfig {

    // 注册Servlet到springboot中
    @Bean
    public ServletRegistrationBean<ServletDemo1> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new ServletDemo1(), "/demo1");
    }

    // 注册filter到springboot中
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/demo1"));
        return filterRegistrationBean;
    }

    // 注册listener到springboot中
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return servletListenerRegistrationBean;
    }
}
