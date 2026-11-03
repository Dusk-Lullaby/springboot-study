package com.sonnet.controller;

import com.sonnet.pojo.Car;
import com.sonnet.pojo.Emp;
import com.sonnet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("hello")
    public String hello() {
        log.info("hello方法执行了");
        return  "hello world";
    }

    @RequestMapping("/add")
    public String add() {
        userService.addUser();
        return "hello...";
    }

    @Autowired
    public Car car;

    @RequestMapping("/car")
    public Car car() {
/*
        Emp emp = new Emp();
        emp.setUsername("eric");
        emp.setAge(20);
        System.out.println(emp);
*/
        Emp emp = new Emp("eric", 18);
        return car;
    }
}
