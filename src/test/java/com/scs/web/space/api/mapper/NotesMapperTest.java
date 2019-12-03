package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.Notes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceApiApplication.class)
class NotesMapperTest {
    @Resource
    private NotesMapper notesMapper;

    @Test
    void getByUserId() {
    }

    @Test
    void getNotesById() {
    }

    @Test
    void insertLog() {
    }

    @Test
    void batchInsert() {
    }

    @Test
    void updateLog() {
    }

    @Test
    void batchDelete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void selectNotesByUserId() throws SQLException {
        List<Notes> notes = notesMapper.selectNotesByUserId(1);
        notes.forEach(System.out::println);
    }
}