package com.livegoods.banner.service;

import com.livegoods.commons.pojo.LiveGoodsResult;

/**
 * 具体的服务，本地轮播图微服务中的服务接口
 * 完成完整的服务提供，如：随机排序；如：缓存访问；如：数量截取
 */
public interface BannerService {

    LiveGoodsResult getBanners();

}
