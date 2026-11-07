package com.sonnet.service.impl;

import com.sonnet.mapper.AccountMapper;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
