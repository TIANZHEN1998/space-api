package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceApiApplication.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insertUser() throws SQLException {
        User user = new User();
        user.setMobile("13977778888");
        user.setPassword("698d51a19d8a121ce581499d7b701668");
        userMapper.insertUser(user);
    }

    @Test
    void findUserByMobile() throws SQLException {
        User user = userMapper.findUserByMobile("13977778888");
        assertNotNull(user);
    }
}