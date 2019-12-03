package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.dto.NotesDto;
import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.mapper.FriendMapper;
import com.scs.web.space.api.mapper.NotesMapper;
import com.scs.web.space.api.service.NotesService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wf
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Date 2019/12/2
 */
@Service
public class NotesServiceImpl implements NotesService {
    private Logger logger = LoggerFactory.getLogger(NotesServiceImpl.class);

    @Resource
    private NotesMapper notesMapper;
    private FriendMapper friendMapper;

    @Override
    public Result getByUserId(int userId, int currentPage, int pageSize) {
        List<Map> map = new ArrayList<>();
        try {
            map = notesMapper.getByUserId(userId,currentPage, pageSize);
        } catch (SQLException e) {
            logger.error("获取用户日志异常");
        }
        System.out.println(map.size());
        List<Map> mapList = new ArrayList<>();
        if(map != null){
            for(int i =0; i < map.size(); i++){
                String accessStatus = map.get(i).get("accessStatus").toString();
                System.out.println(accessStatus);
                switch (accessStatus){
                    case "0" :
                        break;
                    case "1" :
                        /*如果是好友*/
                        User friend = new User();
                        try {
                            friend = friendMapper.getFriend("fds",(long)123);
                        } catch (SQLException e) {
                            logger.error("好友验证出错");
                        }

                        if(friend !=null) {
                            mapList.add(map.get(i));
                            System.out.println(mapList);
                            break;
                        }
                       break;
                    default:
                       mapList.add(map.get(i));
                       break;
                }
            }
            return Result.success(mapList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getAllNotes() {
        List<Notes> notesList = new ArrayList<>();
        try {
            notesList = notesMapper.getAllNotes();
        } catch (SQLException e) {
            logger.error("查询所有日志异常");
        }
         if(notesList != null){
             return Result.success(notesList);
         }
         return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getNotesById(int id) {
        Map map = new HashMap();
        try {
            map = notesMapper.getNotesById(id);
        } catch (SQLException e) {
            logger.error("日志详情获取异常");
        }
        if(map != null){
            return Result.success(map);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result insertNotes(NotesDto notesDto) {
        int n = 0;
        try {
            Notes notes = new Notes();
            notes.setUserId(notesDto.getUserId());
            notes.setTitle(notesDto.getTitle());
            notes.setContent(notesDto.getContent());
            notes.setEditStatus(notesDto.getEditStatus());
            notes.setAccessStatus(notesDto.getAccessStatus());
            notes.setForwardStatus(notesDto.getForwardStatus());
            notes.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            n = notesMapper.insertLog(notes);
        } catch (SQLException e) {
            logger.error("新增日志异常");
        }
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result updateNotes(NotesDto notesDto) {
        int n = 0;
        try {
            Notes notes = new Notes();
            notes.setId(notesDto.getId());
            notes.setTitle(notesDto.getTitle());
            notes.setContent(notesDto.getContent());
            notes.setEditStatus(notesDto.getEditStatus());
            notes.setForwardStatus(notesDto.getForwardStatus());
            notes.setAccessStatus(notesDto.getAccessStatus());
            notes.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            n = notesMapper.updateLog(notes);
        } catch (SQLException e) {
            logger.error("更改日志异常");
        }
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result deleteById(int id) {
        int n = 0;
        n = notesMapper.deleteById(id);
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result batchDelete(List<Notes> list) {
        return null;
    }
}
