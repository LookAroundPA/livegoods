package com.livegoods.cache.dao;



import org.springframework.data.mongodb.core.query.Query;

import java.util.Collection;
import java.util.List;


/**
 * MongoDB访问接口
 */
public interface LiveGoodsCacheDao {

    /**
     * 查询mongodb中的数据
     * @param query 查询条件
     * @param clazz 数据类型
     * @param <T>
     * @return
     */
    <T> List<T> find(Query query, Class<T> clazz);

    /**
     * 插入一条数据
     * @param data
     * @param <T>
     * @return
     */
    <T> T insert(T data);

    /**
     * 插入多条数据
     * @param datas
     * @param clazz
     * @param <T>
     * @return
     */
    <T> Collection<T> insertBatch(Collection<T> datas,Class<T> clazz);
}
