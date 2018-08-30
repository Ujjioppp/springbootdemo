package com.sb.sbdemo.service;

import com.sb.sbdemo.model.MongoEntity;

import java.util.List;

/**
 * Created by ye on 30/8/18.
 */
public interface MongoService {
    <T extends MongoEntity> void set(T entity);

    List<MongoEntity> get();
}
