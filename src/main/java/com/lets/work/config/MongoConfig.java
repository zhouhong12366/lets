package com.lets.work.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories("com.lets.work.mongo")
public class MongoConfig extends AbstractMongoConfiguration{

    @Value("${mongodb.username}")
    private String userName;

    @Value("${mongodb.password}")
    private String passWord;

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private String port;

    @Value("${mongodb.database}")
    private String dbName;
    @Override
    protected String getDatabaseName() {
        return this.dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        ServerAddress addr = new ServerAddress(this.host,Integer.valueOf(port));
        MongoCredential credential = MongoCredential.createCredential(this.userName,this.dbName,this.passWord.toCharArray());
        MongoClient mongoClient = new MongoClient(addr, Arrays.asList(credential));
        mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        return mongoClient;
    }
}
