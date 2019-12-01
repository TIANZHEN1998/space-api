package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

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
     */
    @Insert("INSERT INTO t_user VALUES (null,#{mobile},#{password},#{nickname},#{avatar},#{createTime}) ")
    void insertUser(User user) throws SQLException;

    /**
     * 根据手机号查找用户
     *
     * @param mobile
     * @return User
     * @throws SQLException
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile}")
    User findUserByMobile(String mobile) throws SQLException;

    /**
     * 查询用户表所有用户
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_user ")
    List<User> selectAll() throws SQLException;
}
