package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/5
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    Result login(@RequestBody UserDto user){
        return userService.login(user.getMobile(),user.getPassword());
    }

    @PostMapping(value = "/sign-up")
    Result signUp(@RequestBody User userDto) {
        //客户端发送JSON参数，后端使用@RequstBody接收,注意要用Post方法
        return userService.signUp(userDto);
    }

    /**
     * 查找所有用户
     * @param id
     * @return
     */
    @GetMapping(value = "/list")
    Result getAll(@PathVariable int id) {
        return userService.selectAll(id);
    }

    /**
     *根据Id查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    /**
     * 模糊查询
     * @param
     * @return
     */

    @PostMapping(value = "/findUserByNickName")
    List<User> findUserByNickName(@RequestBody User user){
        return  userService.findUserByNickName(user.getNickname());
    }

    /**
     * 修改用户信息
     * @param user
     */
    @GetMapping(value = "/updateUser")
    public  void  updateUser(User user){
        userService.updateUser(user);
    }


}