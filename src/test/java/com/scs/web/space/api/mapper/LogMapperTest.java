package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.Notes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest(classes = SpaceApiApplication.class)
class LogMapperTest {
    @Resource
    private NotesMapper logMapper;
    @Test
    void batchDelete() {
        List<Notes> logList = new ArrayList<>();
        for(int i = 1; i<10; i++){
            Notes log = new Notes();
            log.setUserId(i);
            logList.add(log);
        }
        int n = logMapper.batchDelete(logList);
        System.out.println(n);
    }

    @Test
    void insertLog() throws SQLException {
        Notes log = new Notes();
        log.setUserId(1);
        log.setContent("哈哈");
        log.setTitle("哈");
        log.setAccessStatus(0);
        log.setEditStatus(1);
        log.setForwardStatus(1);
        log.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(log);
        int n = logMapper.insertLog(log);
        System.out.println(n);
    }

    @Test
    void batchInsert() {
        List<Notes> logList = new ArrayList<>();
        for(int i = 0; i<9; i++){
            Notes log = new Notes();
            log.setUserId(1);
            log.setContent("哈哈");
            log.setTitle("哈");
            log.setAccessStatus(0);
            log.setEditStatus(1);
            log.setForwardStatus(1);

            log.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            logList.add(log);
        }
        int n = logMapper.batchInsert(logList);
        System.out.println(n);
    }

    @Test
    void getLogById() throws SQLException {

    }

    @Test
    void getLog() throws SQLException {
      List<Map> maps = logMapper.getByUserId(1,1,1);
        System.out.println(maps.size());
    }

    @Test
    void updateLog() throws SQLException {
    Notes log = new Notes();
    log.setId(1);
    log.setTitle("h");
    log.setContent("h");
    log.setEditStatus(4);
    log.setAccessStatus(3);
    log.setForwardStatus(3);
    log.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(logMapper.updateLog(log));
    }

    @Test
    void deleteById() {
    }
}