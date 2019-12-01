package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Album;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName AlbumMapper
 * @Description 相册Mapper
 * @Author wf
 * @Date 2019/12/1
 **/
public interface AlbumMapper {
    /**
     * 新增相册
     * @param album
     * @return int
     * @throws SQLException
     */
    @Insert("INSERT INTO t_album VALUES (null,#{userId},#{name},#{cover},#{createTime})" )
    int insertAlbum(Album album) throws SQLException;

    /**
     * 按创建时间升序查询所有相册
     * @return List<album>
     * @throws SQLException
     */
    @Select("SELECT * FROM t_album ORDER BY create_time ASC")
    List<Album> getAlbum() throws SQLException;

    /**
     * 根据相册id删除相册记录
     * @param id
     * @return int
     * @throws SQLException
     */
    @Delete("DELETE FROM t_album WHERE id = #{id}")
    int deleteByName(int id) throws SQLException;

    /**
     * 根据用户id得到该用户所有相册记录
     * @param userId
     * @return List<Album>
     * @throws SQLException
     */
    @Select("SELECT * FROM t_album WHERE user_id = #{userId}")
    List<Album> getByUserId(long userId) throws SQLException;
}
