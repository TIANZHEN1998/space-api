package com.scs.web.space.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest(classes = SpaceApiApplication.class)
class SpaceApiApplicationTests {

    @Resource
    private DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(this.dataSource);
    }
}
