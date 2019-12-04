package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author wf
 * @ClassName Comment
 * @Description TODO
 * @Date 2019/12/3
 */
@Data
public class Comment {
    private Integer id;
    private Integer userId;
    private Integer notesId;
    private String content;
    private Timestamp createTime;
    private User user;
}
