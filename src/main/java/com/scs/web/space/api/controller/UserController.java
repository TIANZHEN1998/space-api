package com.scs.web.space.api.controller;
import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.domain.entity.CorrectCode;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.service.RedisService;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
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
    @Resource
    private RedisService redisService;

    /***
     * 登录
     * @param userDto
     * @param verifyCode
     * @param mobile
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/login")
    public Result signIn(@RequestBody UserDto userDto,@RequestParam("verifyCode") String verifyCode,
                         @RequestParam("mobile") String mobile) throws IOException {
        CorrectCode correctCode = redisService.getValue(mobile, CorrectCode.class);
        if (correctCode.getCorrectCode().equals(verifyCode)){
            System.out.println(correctCode.getCorrectCode());
            return Result.success();
        }
        return  Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);

    }



    /**
     * 注册
     * @param userDto
     * @return
     */
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
    Result getAll(@PathVariable  int id) {
        return userService.selectAll(id);
    }

    /**
     *根据Id查询用户
     * @param id（成功）
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getUserById(@PathVariable("id")  @Valid int id){
        return userService.getUserById(id);
    }

    /**
     * 根据手机号查询用户的所有信息
     * @param mobile(成功)
     * @return
     */
    @GetMapping(value = "/findUserByMobile/{mobile}")
    Result findUserByMobile(@PathVariable("mobile") @Valid  String mobile){
        return  userService.getUserByMobile(mobile);
    }
    /**
     * 根据昵称模糊查询
     * @param(成功)
     * @return
     */

    @PostMapping(value = "/findUserByNickName/{key_name}")
    List<User> findUserByNickName(@PathVariable("key_name") @Valid String key_name){
        return  userService.findUserByNickName(key_name);
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