package com.elvischang.unittest_demo.mockito;

import com.elvischang.unittest_demo.User;
import com.elvischang.unittest_demo.UserDao;
import com.elvischang.unittest_demo.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author elvischang
 * @create 2022-04-02-下午 05:30
 **/
@SpringBootTest
public class UserServiceTest {
    //先普通的注入一個userService bean
    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;


    @Test
    public void getUserById() throws Exception {
        // 定義當調用mock userDao的getUserById()方法，並且參數為3時，就返回id為200、name為I'm mock3的user對象
        Mockito.when(userDao.getUserById(3)).thenReturn(new User(200, "I'm mock 3"));

        // 當調用 userService 的 insertUser() 方法時，不管傳進來的 user 是什麼，都回傳 100
        Mockito.when(userService.insertUser(Mockito.any(User.class))).thenReturn(100);

        // 當調用 userService 的 getUserById() 時的參數是 9 時，拋出一個 RuntimeException
        Mockito.when(userService.getUserById(9)).thenThrow(new RuntimeException("mock throw exception"));
//        User user1 = userService.getUserById(9); //會拋出一個RuntimeException

        // 返回的會是名字為I'm mock 3的user對象
        User user = userService.getUserById(3);



        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getId(), 200);
        Assertions.assertEquals(user.getName(), "I'm mock 3");
    }

}
