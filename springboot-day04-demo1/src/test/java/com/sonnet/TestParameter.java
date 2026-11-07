package com.sonnet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@DisplayName("参数化测试")
@SpringBootTest(classes = App.class)
public class TestParameter {

    @ParameterizedTest // 参数化测试的注解
    @ValueSource(strings = {"apple", "orange", "banana"})
    @DisplayName("基于string类型的参数进行参数化设置")
    public void testParameter1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
        System.out.println("testParameter1");
    }

    @ParameterizedTest
    @MethodSource("show")
    @DisplayName("基于方法的参数化测试")
    public void testParameter2(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
        System.out.println("testParameter2");
    }

    static Stream<String> show() {
        return Stream.of("apple", "orange", "banana");
    }
}
