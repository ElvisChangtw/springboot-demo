package com.elvischang.unittest_demo;

import org.junit.jupiter.api.*;

/**
 * @author elvischang
 * @create 2022-04-02-下午 03:41
 **/
@DisplayName("測試Class")
public class BeforeAfterTestSample {

    @BeforeAll
    public static void init() {
        System.out.println("初始化資料");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理資料");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("Test開始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test結束");
    }

    @DisplayName("Test1")
    @Test
    @Disabled
    void testFirstTest() {
        System.out.println("Test1測試....");
    }

    @DisplayName("Test2")
    @Test
    void testSecondTest() {
        System.out.println("Test2測試....");
    }


}
