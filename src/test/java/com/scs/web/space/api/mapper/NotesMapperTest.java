package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.domain.vo.NotesVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = SpaceApiApplication.class)
class NotesMapperTest {
    @Resource
    private NotesMapper notesMapper;
    @Test
    void getByUserId() throws SQLException {

    }

    @Test
    void getById() throws SQLException {
    }

    @Test
    void testGetNotesById3() throws SQLException {
        Notes notes = notesMapper.getNotesById(2);
        System.out.println(notes);
    }
}