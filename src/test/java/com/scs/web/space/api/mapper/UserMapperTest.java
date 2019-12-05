package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.domain.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;

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

    @Test
    void getFriendDynamicById() throws SQLException {
        UserVo userVo = userMapper.getFriendDynamicById(3);
        System.out.println(userVo);
    }
}