package com.elvischang.unittest_demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author elvischang
 * @create 2022-04-02-下午 04:50
 **/
public class NestedTestSample {

    @BeforeEach
    void init() {
        System.out.println("測試方法執行前準備");
    }

    @Nested
    @DisplayName("第一個內嵌測試類")
    class FirstNestTest {
        @Test
        void test() {
            System.out.println("第一個內嵌測試類執行測試");
        }
    }

    @Nested
    @DisplayName("第二個內嵌測試類")
    class SecondNestTest {
        @Test
        void test() {
            System.out.println("第二個內嵌測試類執行測試");
        }
    }
}
