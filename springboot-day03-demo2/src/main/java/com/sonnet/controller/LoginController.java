package com.sonnet.controller;

import com.sonnet.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // 跳转到登录页面
    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login";
    }

    // 登录，用户登录成功后，要跳转到主页（重定向， 避免表单的重复提交）
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        // 只要用户名为admin 密码为123456 就可以认证成功
        if (user.getUserName().equals("admin") && user.getPassword().equals("123456")) {
            // 登录成功
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        } else {
            // 登录不成功 转发到登录页面
            model.addAttribute("msg", "用户名输入错误");
            return "login";
        }
    }

    // 跳转到主页的控制器方法
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
/*
        // 避免用户直接访问主页
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            // 转发到我们的登录页面
            model.addAttribute("msg", "请先登录");
            return "login";
        }
*/
        return "main";
    }
}
