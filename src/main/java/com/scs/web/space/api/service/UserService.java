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
     * @param dto
     * @return Result
     */
    Result signUp(UserDto dto);
}
