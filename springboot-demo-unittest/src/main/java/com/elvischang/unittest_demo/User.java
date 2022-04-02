package com.elvischang.unittest_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author elvischang
 * @create 2022-04-02-下午 05:27
 **/
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
}
