package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @ClassName Album
 * @Description 相册实体类
 * @Author wf
 * @Date 2019/12/1
 **/
@Data
public class Album {
    private Integer id;
    private Integer userId;
    private String albumName;
    private String name;
    private String cover;
    private Timestamp createTime;
}
