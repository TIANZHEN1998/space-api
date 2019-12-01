package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@Data
public class User {
    private Integer id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private LocalDateTime createTime;
}
