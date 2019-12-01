package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @ClassName UserMapper
 * @Description 用户Mapper
 * @Author mq_xu
 * @Date 2019/12/1
 **/
public interface UserMapper {

    /**
     * 新增用户
     *
     * @param user
     * @throws SQLException
     * @author mq_xu
     * @date 2019.12.1
     */
    @Insert("INSERT INTO t_user VALUES (null,#{mobile},#{password},#{nickname},#{avatar},#{createTime}) ")
    void insertUser(User user) throws SQLException;

    /**
     * 根据手机号查找用户
     *
     * @param mobile
     * @return User
     * @throws SQLException
     * @author mq_xu
     * @date 2019.12.1
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile}")
    User findUserByMobile(String mobile) throws SQLException;

}
