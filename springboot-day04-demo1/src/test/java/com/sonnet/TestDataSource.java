package com.sonnet;

import com.sonnet.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest(classes = App.class)
public class TestDataSource {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testDataSource() {
        System.out.println(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println(jdbcTemplate.queryForObject("select count(*) from account", Integer.class));
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUserMapper() {
        System.out.println(userMapper.selectById(1));
    }

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    public void testRedisConnectionFactory() {
        Class<? extends RedisConnectionFactory> aClass = redisConnectionFactory.getClass();
        System.out.println(aClass);
    }

}
