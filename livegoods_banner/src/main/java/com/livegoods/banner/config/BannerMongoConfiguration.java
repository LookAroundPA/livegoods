package com.livegoods.banner.config;


import com.livegoods.cache.dao.LiveGoodsCacheDao;
import com.livegoods.cache.dao.impl.LiveGoodsCacheDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * 配置类型，创建mongo数据访问对象
 */
@Configuration
public class BannerMongoConfiguration {
    @Bean
    public LiveGoodsCacheDao liveGoodsCacheDao(MongoTemplate mongoTemplate){
        LiveGoodsCacheDaoImpl dao = new LiveGoodsCacheDaoImpl();
        dao.setMongoTemplate(mongoTemplate);
        return dao;
    }


}
