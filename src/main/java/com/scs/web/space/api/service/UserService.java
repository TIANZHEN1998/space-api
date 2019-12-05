package com.scs.web.space.api.service;

import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.util.Result;

/**
 * @ClassName UserService
 * @Description 用户服务接口
 * @Author mq_xu
 * @Date 2019/12/1
 **/
public interface UserService {

    /**
     * 用户注册功能
     *
     * @param dto
     * @return Result
     */
    Result signUp(UserDto dto);


    /**
     * 查询所有用户
     *
     * @return Result
     * @author mq_xu
     * @date 2019.12.1
     */
    Result selectAll(int id);

    /**
     * 根据id查询用户
     * @param id
     * @author taoyongxin
     * @return Result
     */
    Result getUserById(int id);

    Result getDynamicById(int id);

}
