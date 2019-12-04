package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Friend {
    private Integer id;
    private Integer fromId;
    private Integer toId;
    private Integer status;
    private Timestamp createTime;
    private List<Notes> notes;
}
