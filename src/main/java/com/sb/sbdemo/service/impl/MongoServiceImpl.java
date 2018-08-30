package com.sb.sbdemo.service.impl;

import com.sb.sbdemo.model.MongoEntity;
import com.sb.sbdemo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ye on 30/8/18.
 */
@Service
@PropertySource(value = "classpath:config/const.properties", ignoreResourceNotFound = false)
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Value("${mongo.collection.name}")
    private String mongoCollectionName;

    @Override
    public <T extends MongoEntity> void set(T entity) {
        this.mongoTemplate.insert(entity, this.mongoCollectionName);
    }

    @Override
    public List<MongoEntity> get() {
        return this.mongoTemplate.findAll(MongoEntity.class, this.mongoCollectionName);
    }
}
