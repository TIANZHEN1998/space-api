package com.scs.web.space.api.mapper;


import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface FriendMapper {

    @Select("SELECT * FROM t_friend WHERE from_id = #{fromId} AND to_id = #{toId}")
    Friend getFriend(int fromId, int toId) throws SQLException;
}
