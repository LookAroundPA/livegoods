package com.livegoos.banner.api;

import com.livegoods.pojo.Banner;

import java.util.List;

/**
 * 轮播图查询接口
 */
public interface BannerServiceAPI {
    /**
     * 基于服务提供的轮播图查询接口
     *
     */
    List<Banner> getBanners();
}
