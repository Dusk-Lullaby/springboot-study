package com.sonnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // 标识当前类是一个启动类
public class App {

    public static void main(String[] args) {
        // 帮助我们初始化一个IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        // 获取ioc容器里面的组件名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}

// localhost:8080/hello
