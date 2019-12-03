package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Notes;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NotesMapper
 * @Description 日志Mapper
 * @Author wf
 * @Date 2019/12/2
 **/
public interface NotesMapper {

    @Results(id = "notes",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "comments",column = "comments"),
            @Result(property = "likes",column = "likes"),
            @Result(property = "editStatus",column = "edit_status"),
            @Result(property = "accessStatus",column = "access_status"),
            @Result(property = "forwardStatus",column = "forward_status"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "avatar",column = "avatar")
    })
    /**查询个人日志列表
     * @param id
     * @return List<map>
     * @throws SQLException
     */
    @Select("SELECT t1.*,t2.nickname,t2.avatar FROM t_notes t1 " +
            " LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.id " +
            "WHERE user_id = #{id}")
    List<Map> getByUserId(int id) throws SQLException;

    /**
     * 查询日志详情
     * @param id
     * @return Map
     * @throws SQLException
     */
    @ResultMap("notes")
    @Select("SELECT t1.*,t2.nickname,t2.avatar FROM t_notes t1 " +
            " LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.id " +
            "WHERE t1.id = #{id} ")
    Map getNotesById(int id) throws SQLException;

    /**
     * 新增日志信息
     * @param notes
     * @return int
     * @throws SQLException
     */
    @Insert("INSERT INTO t_notes(id,user_id,title,content,edit_status,access_status,forward_status,create_time)" +
            "VALUES (null,#{userId},#{title},#{content},#{editStatus},#{accessStatus},#{forwardStatus},#{createTime})")
    int insertLog(Notes notes) throws SQLException;

    /**
     * 批量新增日志信息
     * @param logs
     * @return
     */
    @InsertProvider(type = Provider.class, method = "batchInsert")
    int batchInsert(List<Notes> logs);

    /**
     * 根据日志id跟新日志信息
     * @param log
     * @return int
     * @throws SQLException
     */
    @Update("UPDATE t_notes SET title=#{title}, content=#{content},edit_status=#{editStatus}," +
            "access_status=#{accessStatus},forward_status=#{forwardStatus},create_time=#{createTime}" +
            "WHERE id=#{id}")
    int updateLog(Notes log) throws SQLException;

    /**
     * 批量删除日志
     * @param logs
     * @return
     */
    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int batchDelete(List<Notes> logs);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM t_notes WHERE id = #{id}")
    int deleteById(int id);

    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<Notes> logs = (List<Notes>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO t_notes (user_id,title,content,edit_status,access_status,forward_status,create_time) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].userId}, #'{'list[{0}].title}, #'{'list[{0}].content},#'{'list[{0}].editStatus},#'{'list[{0}].accessStatus},#'{'list[{0}].forwardStatus},#'{'list[{0}].createTime})");

            for (int i = 0; i < logs.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < logs.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

        /* 批量删除 */
        public String batchDelete(Map map) {
            List<Notes> logs = (List<Notes>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM t_notes WHERE id IN (");
            for (int i = 0; i < logs.size(); i++) {
                sb.append(logs.get(i).getId());
                if (i < logs.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /**
     * 根据用户id查询所有日志
     * @param userId
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_notes  WHERE user_id = #{userId} ")
    List<Notes> selectNotesByUserId(@Param("userId") int userId)throws SQLException;
}
