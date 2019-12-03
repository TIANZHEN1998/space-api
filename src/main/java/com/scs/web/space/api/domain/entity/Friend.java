package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wf
 * @ClassName Friend
 * @Description TODO
 * @Date 2019/12/2
 */
@Data
public class Friend {
    private Integer id;
    private Integer fromId;
    private Integer toId;
    private Integer status;
    private LocalDateTime createTime;
}
