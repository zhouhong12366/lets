package com.lets.work.service;

import com.lets.work.mongo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void findUserInfo() throws Exception {
        System.out.println(testService.findUserInfo());
    }

    @Test
    public void insertUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo("测试用户1","123456");
        testService.insertUserInfo(userInfo);
    }

}