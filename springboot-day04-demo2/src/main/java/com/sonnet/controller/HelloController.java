package com.sonnet.controller;

import com.sonnet.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name:李四}") // 如果没有获取到指定的值，就用默认值
    public String name;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello " + name;
    }

/*
    @Autowired
    Person person;

    @RequestMapping("person")
    public String getPerson() {
        return person.getClass().toString();
    }
*/
 
    @Autowired
    Emp emp;

    @RequestMapping("/emp")
    public Emp getEmp() {
        return emp;
    }
}
// localhost:8080/hello