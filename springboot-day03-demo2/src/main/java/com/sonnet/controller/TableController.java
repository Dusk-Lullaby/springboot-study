package com.sonnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    // 跳转到basic_table.html
    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    // 跳转到dynamic_table.html
    @GetMapping("/dynamic_table")
    public String dynamic_table() {
        return "table/dynamic_table";
    }

    // 跳转到response_table.html
    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    // 跳转到editable_table.html
    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
