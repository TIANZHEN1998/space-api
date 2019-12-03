package com.scs.web.space.api.mapper;


import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface FriendMapper {

    @Select("SELECT * FROM t_user WHERE mobile = #{mobile} AND #{id}")
    User getFriend(String mobile, Long id) throws SQLException;
}
