package com.scs.web.space.api.mapper;


import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

public interface FriendMapper {

    @Select("SELECT * FROM t_friend WHERE from_id = #{fromId} AND to_id = #{toId}")
    Friend getFriend(int fromId, int toId) throws SQLException;


    @Select("SELECT * FROM t_friend WHERE from_id = #{id}")


    @Results({
            @Result(property = "users", column = "to_id",
                    many = @Many(select = "com.scs.web.space.api.mapper.UserMapper.selectById")),
    })
    List<Friend> getAll(@Param("id") int id) throws SQLException;
}
