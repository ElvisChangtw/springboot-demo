package com.elvischang.unittest_demo;

import org.junit.jupiter.api.*;

/**
 * @author elvischang
 * @create 2022-04-02-下午 05:04
 **/
public class RepeatTestSample {

    @DisplayName("自定義名稱重複測試")
    @RepeatedTest(value = 3, name = "{displayName} 第 {currentRepetition} 次")
    public void i_am_a_repeated_test() {
        System.out.println("執行測試");
    }
}
