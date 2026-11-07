package com.sonnet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@DisplayName("测试断言的测试类")
@SpringBootTest(classes = App.class)
public class TestAssert {

    @DisplayName(("测试assertEquals"))
    @Test
    public void test01() {
        /**
         * assertEquals 判断两个值是否相等
         * 参数1：预期值
         * 参数2：实际值
         * 参数3：预期值和实际值不相等，输出的提示信息
         */
        Assertions.assertEquals(4, getNum(2, 3), "断言失败，预期值和实际值不相等");
        System.out.println("这是test01");
    }

    public int getNum(int num1, int num2) {
        return num1 + num2;
    }

    @DisplayName("测试assertNotEquals")
    @Test
    public void test02() {
        Object o1 = new Object();
        Object o2 = new Object();
        Assertions.assertNotEquals(o1, o2, "两个对象是同一个对象");
    }

    @DisplayName("测试assertSame")
    @Test
    public void test03() {
        Object o1 = new Object();
        Object o2 = new Object();
        Assertions.assertSame(o1, o2, "两个对象指向同一个内存地址");
        System.out.println("这是test02方法");
    }

    @DisplayName("测试AssertTrue")
    @Test
    public void test04() {
        Assertions.assertTrue(2 < 1, "表达式必须为true才会执行测试方法");
        System.out.println("这是test04方法");
    }

    @DisplayName("测试assertArrayEquals数组")
    @Test
    public void test05() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4};
        Assertions.assertArrayEquals(arr1, arr2, "数组内容不相等");
        System.out.println("这是test05");
    }

    @DisplayName("测试组合断言")
    @Test
    public void test06() {
        Assertions.assertAll("a",
                ()->Assertions.assertEquals(2, 2, "两个值不相等"),
                ()->Assertions.assertTrue(1 > 8, "预期结果必须为true"));
        System.out.println("test06");
    }

    @DisplayName("测试超时断言")
    @Test
    public void test07() {
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->{
            Thread.sleep(1500);
        }, "执行超时");
        System.out.println("test07");
    }

    @Test
    public void test08() {
        Assumptions.assumeTrue(false, "预期结果不为true");
        System.out.println("test08");
    }
}
