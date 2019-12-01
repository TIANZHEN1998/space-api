package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Album {
    private Integer id;
    private Integer userId;
    private String name;
    private String cover;
    private LocalDateTime createTime;
}
