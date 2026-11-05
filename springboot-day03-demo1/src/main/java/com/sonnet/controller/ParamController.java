package com.sonnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * springboot中常用参数注解的使用
 * localhost:8080/aa/10010/mm/123
 */
//@RestController
@Controller
public class ParamController {

    @RequestMapping("aa/{userId}/mm/{num}")
    public String testPathVariable(@PathVariable("userId") String userId, @PathVariable("num") Integer num) {
        System.out.println(userId);
        System.out.println(num);
        return "hello";
    }

    /**
     * 测试@Request注解
     * http://localhost:8080/testRequestParam?username=eric&age=12&address=USA
     * @return
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("username") String name,
                                   @RequestParam("age") Integer age,
                                   @RequestParam("address") String address) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(address);
        return "hello";
    }

    /**
     * 在同步情况下或者表单的实体内容
     * @param data
     * @return
     */
    @RequestMapping("/getData")
    public String getData(@RequestBody String data) {
        return data;
    }

    /**
     * 获取指定的Cookie值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("Idea-10501acc") String cookieValue) {
        System.out.println(cookieValue);
        return "hello";
    }

    /**
     * 测试请求头
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Encoding") String header) {
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/test1")
    public String test1(HttpServletRequest request) {
        request.setAttribute("username", "eric");
        return "forward:/test2";
    }

    /**
     * @RequestAttribute注解，用来获取Request作用域里面的值。修饰控制器方法的参数
     * @param username
     * @return
     */
    @RequestMapping("/test2")
    public String test2(@RequestAttribute("username") String username) {
        System.out.println(username);
        return username;
    }

    //test/matrix/color=red,green,blue
    @RequestMapping("test/matrix/{param}")
    public @ResponseBody String testMatrix(@MatrixVariable(pathVar = "param", value = "color") String[] strs) {
        for (String str : strs) {
            System.out.println(str);
        }
        return "hello";
    }
}
