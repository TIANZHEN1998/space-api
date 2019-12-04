package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = SpaceApiApplication.class)

class FriendMapperTest {
    @Resource
    private FriendMapper friendMapper;

    @Test
    void getFriend() throws SQLException {
    Friend friend = friendMapper.getFriend(1,2);
        System.out.println(friend);
    }
}