package com.scs.web.space.api.service;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.util.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceApiApplication.class)
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void signUp() {
        UserDto userDto = new UserDto();
        userDto.setMobile("1389999000");
        userDto.setPassword("698d51a19d8a121ce581499d7b701668");
        Result result = userService.signUp(userDto);
        assertEquals(1, result.getCode());
//        System.out.println(result);
    }

    @Test
    void selectAll() {
        Result result = userService.selectAll(1);
        System.out.println(result.getData());
    }

    @Test
    void getUserById() {
        Result result = userService.getUserById(10);
        System.out.println(result.getCode() + "  " + result.getMsg() + result.getData());
    }
}