package com.sonnet;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@DisplayName("junit单元测试")
@SpringBootTest(classes = App.class)
public class TestJunit {

    @BeforeEach // 在每个单元测试方法之前执行
    public void before() {
        System.out.println("这是beforeEach方法");
    }

    @AfterEach // 在每个单元测试方法之后执行
    public void after() {
        System.out.println("这是afterEach方法");
    }

    @BeforeAll // 在所有测试方法之前执行
    public static void beforeAll() {
        System.out.println("这是BeforeAll方法");
    }

    @AfterAll // 在所有测试方法之后执行
    public static void afterAll() {
        System.out.println("这是afterAll方法");
    }

    @Test
    public void test01() {
        System.out.println("test01方法");
    }

    @Test
    @Disabled // 指定某一个测试方法不执行
    public void test02() {
        System.out.println("test02方法");
    }

    @Disabled("测试方法是否超时")
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // 指定这个方法在500毫秒之内执行，如果超过了指定的时间，就直接报错
    public void test03() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("这是test03");
    }
}
