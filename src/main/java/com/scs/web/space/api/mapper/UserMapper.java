package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.*;
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
     *
     * @author 田震
     * 登录接口
     * @date 2019.12.2
     */
    @Select("SELECT mobile,password FROM t_user WHERE mobile=#{mobile} and password=#{password})")
      User login(UserDto user) throws  SQLException;


    /**
     * 新增用户
     * @param user
     * @throws SQLException
     * @author
     * @date 2019.12.1
     */
    @Insert("insert into t_user values (null,#{mobile},#{password},#{email},#{birthday},#{createTime}) ")
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

    /**
     * 根据id查询用户信息，通过一对多查询，级联查出该用户所有日志
     * @param id
     * @return
     * @throws SQLException
     */

    @Select("SELECT * FROM t_user WHERE id = #{id} ")
    User getUserById(@Param("id")int id)throws SQLException;

    /**
     * 查询用户表所有用户
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_user ")
    List<User> selectAll() throws SQLException;

    /**
     * 根据昵称模糊查询
     * @return
     * @throws SQLException
     * @param
     */
    @Select("SELECT * FROM t_user WHERE nickname  LIKE  CONCAT ('%',#{nickname},'%') ")
    List<User> findUserByNickName(@Param("nickname") String nickname) throws  SQLException;


    /***
     * 修改用户信息（头像、昵称、简介、地址）
     * @param user
     * @return
     * @throws SQLException
     */
    @Update("update t_user set nickname=#{nickname} ,avatar=#{avatar},introduction=#{introduction},address=#{address}" +
            " where " +
            "id=#{id}")
        int updateUser(User user) throws  SQLException;
}
