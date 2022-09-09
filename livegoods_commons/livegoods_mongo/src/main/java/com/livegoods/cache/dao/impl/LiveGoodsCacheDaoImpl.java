package com.livegoods.cache.dao.impl;

import com.livegoods.cache.dao.LiveGoodsCacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

public class LiveGoodsCacheDaoImpl implements LiveGoodsCacheDao {

    private MongoTemplate mongoTemplate;

    @Override
    public <T> List<T> find(Query query, Class<T> clazz) {
        return mongoTemplate.find(query,clazz);
    }

    @Override
    public <T> T insert(T data) {
        return mongoTemplate.insert(data);
    }

    @Override
    public <T> Collection<T> insertBatch(Collection<T> datas, Class<T> clazz) {
        return mongoTemplate.insert(datas,clazz);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
