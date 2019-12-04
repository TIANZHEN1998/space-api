package com.scs.web.space.api.mapper;

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


    /**
     * 根据id查询用户信息，通过一对多查询，级联查出该用户所有日志
     * @param id
     * @return
     * @throws SQLException
     */

    @Select("SELECT * FROM t_user WHERE id = #{id} ")
    @Results({
            @Result(property = "notesList", column = "id",
                    many = @Many(select = "com.scs.web.space.api.mapper.NotesMapper.selectNotesByUserId")),
            @Result(property = "comment", column = "id",
                    many = @Many(select = "com.scs.web.space.api.mapper.CommentMapper.getByUserId"))
    })
    User getUserById(@Param("id")int id)throws SQLException;

    /**
     * 查询用户表所有用户
     *
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_user ")
    List<User> selectAll() throws SQLException;

    @Select("SELECT * FROM t_user WHERE id = #{userId}")
    List<User> getById(@Param("userId") int id) throws SQLException;

}
