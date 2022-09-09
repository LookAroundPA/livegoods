package com.livegoods.banner.service.impl;

import com.livegoods.banner.service.BannerService;
import com.livegoods.cache.dao.LiveGoodsCacheDao;
import com.livegoods.commons.pojo.LiveGoodsResult;
import com.livegoods.pojo.Banner;
import com.livegoos.banner.api.BannerServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerServiceAPI bannerServiceAPI;
    @Value("${livegoods.nginx.server}")//在nacos配置中心里配置的属性值
    private String nginxServer;
    @Autowired
    LiveGoodsCacheDao cacheDao;


    @Override
    public LiveGoodsResult getBanners() {
        /**
         * 使用mongodb做缓存处理
         * 1.访问MongoDB,查询数据缓存
         * 有缓存直接返回，无缓存查询数据库
         */
        try{
            Query query = new Query();
            List<Banner> cacheList = cacheDao.find(query, Banner.class);
            if (cacheList != null && cacheList.size()>0){
                List<String> result = banner2Results(cacheList);
                return LiveGoodsResult.okWithResults(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //无缓存查询数据库
        List<Banner> banners = bannerServiceAPI.getBanners();
        //查询到的结果放入mongodb中缓存起来
        try {
            cacheDao.insertBatch(banners,Banner.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<String> result = banner2Results(banners);
        return LiveGoodsResult.okWithResults(result);
    }

    private List<String> banner2Results(List<Banner> banners){
        List<String> result = new ArrayList<>();
        for (Banner banner:banners){
            result.add(nginxServer + banner.getUrl());
        }

        //随机排序
        Collections.shuffle(result);

        //只有六个轮播图槽位
        if (result.size()>6){
            for (int i = result.size()-1;i>=6;i--){
                result.remove(i);
            }
        }
        return result;
    }
}
