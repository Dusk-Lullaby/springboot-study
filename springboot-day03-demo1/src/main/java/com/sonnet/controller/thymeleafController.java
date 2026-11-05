package com.sonnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/thymeleaf")
public class thymeleafController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        List<String> list = new ArrayList<>();
        list.add("Sunny");
        list.add("Kobe");
        list.add("Ketty");
        model.addAttribute("list",list);
        model.addAttribute("msg", "Hello World");
        return "success";
    }
}
