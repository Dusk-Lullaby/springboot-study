package com.sonnet.demos.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticController {
    @RequestMapping("a.html")
    public String a() {
        return "Hello Word";
    }
}
