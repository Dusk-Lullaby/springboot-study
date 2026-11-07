package com.sonnet.controller;

import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("query")
    public String query() {
        return jdbcTemplate.queryForObject("select count(*) from account", Long.class).toString();
    }

    @Autowired
    AccountService accountService;

    @RequestMapping("/findById")
    public Account findById(@RequestParam("id") Integer id) {
        return accountService.findById(id);
    }

    @RequestMapping("/findAll")
    public List<Account> findAll() {
        return accountService.findAll();
    }
}
