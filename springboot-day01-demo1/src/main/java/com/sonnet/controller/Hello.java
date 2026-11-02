package com.sonnet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// @Controller + @ResponseBody
public class Hello {

    @RequestMapping("/hello")
    public String hello() {
        return "hello, springboot";
    }
}
