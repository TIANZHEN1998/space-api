package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Album;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

public interface AlbumMapper {
    /**
     * 新增相册
     * @param album
     * @return
     * @throws SQLException
     */
    @Insert("INSERT INTO t_album VALUES (null,#{userId},#{name},#{cover},#{createTime})" )
    int insertAlbum(Album album) throws SQLException;

    @Select("SELECT * FROM t_album ORDER BY create_time ASC")
    List<Album> getAlbum() throws SQLException;

    @Delete("DELETE FROM t_album WHERE id = #{id}")
    int deleteByName(int id) throws SQLException;

    @Select("SELECT * FROM t_album WHERE user_id = #{userId}")
    List<Album> getByUserId(long userId) throws SQLException;
}
