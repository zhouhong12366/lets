package com.lets.work.service;

import com.lets.work.mongo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserInfo> findUserInfo(){
        List<UserInfo> userInfos = null;
        userInfos = mongoTemplate.findAll(UserInfo.class);
        return userInfos;
    }

    public void insertUserInfo(UserInfo userInfo){
        mongoTemplate.insert(userInfo);
    }
}
