package com.sonnet.mapper;

import com.sonnet.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    public Account findById(Integer id);

    @Select("select * from account")
    public List<Account> findAll();
}
