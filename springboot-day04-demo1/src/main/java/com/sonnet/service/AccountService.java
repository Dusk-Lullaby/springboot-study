package com.sonnet.service;

import com.sonnet.pojo.Account;

import java.util.List;

public interface AccountService {

    public Account findById(Integer id);

    public List<Account> findAll();

}
