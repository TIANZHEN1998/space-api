package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Tao
 * @ClassName Photo
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
@Data
public class Photo {
    private Integer id;
    private Integer albumId;
    private String photoUrl;
    private String photoName;
    private Timestamp createTime;
}
