package com.sonnet.demos.restController;

import com.sonnet.demos.pojo.Demo1;
import com.sonnet.demos.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    Demo1 demo1;

    @RequestMapping("/demo1")
    public Demo1 demo1() {
        return demo1;
    }

    @Autowired
    Person  person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }
}
