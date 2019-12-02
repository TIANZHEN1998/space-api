package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;
<<<<<<< HEAD

/**
 * @ClassName Album
 * @Description 相册实体类
 * @Author wf
 * @Date 2019/12/1
 **/
=======
>>>>>>> origin/master
@Data
public class Album {
    private Integer id;
    private Integer userId;
<<<<<<< HEAD
    private String albumName;
=======
    private String name;
>>>>>>> origin/master
    private String cover;
    private LocalDateTime createTime;
}
