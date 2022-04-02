package com.example.redis_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author elvischang
 * @create 2022-03-05-下午 06:35
 **/

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/")
    public String testRedis() {

        // set值
        redisTemplate.opsForValue().set("name", "lucy");

        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }

    // 分布式鎖簡單案例
    @GetMapping("testLock")
    public void testLock() {

        // 0. 生成uuid
        String uuid = UUID.randomUUID().toString();
//        1. 獲取鎖, setne
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 3, TimeUnit.SECONDS);

        // 獲取鎖成功, 查詢num的值
        if (lock) {
            String value = (String) redisTemplate.opsForValue().get("num");

            if (!StringUtils.hasLength(value)) {
                return;
            }
            // 2.2 有值就轉成int
            int num = Integer.parseInt(value + "");
            // 2.3 把redis num+1
            redisTemplate.opsForValue().set("num", ++num);

            //加入uuid判斷防止誤刪
            String lockUuid = (String) redisTemplate.opsForValue().get("lock");
            if (lockUuid.equals(uuid)) {
                redisTemplate.delete("lock");
            }
        } else {
            try {
                Thread.sleep(100);
                testLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
