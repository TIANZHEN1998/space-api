package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description 用户控制层
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/sign-up")
    Result signUp(@RequestBody UserDto userDto) {
        //客户端发送JSON参数，后端使用@RequstBody接收,注意要用Post方法
        return userService.signUp(userDto);
    }

    @GetMapping(value = "/{id}")
    public Result getById(@PathVariable int id){
        return userService.selectAll(id);
    }

    @GetMapping(value = "/d/{id}")
    Result getDynamicById(@PathVariable int id){
        return userService.getDynamicById(id);
    }
}
