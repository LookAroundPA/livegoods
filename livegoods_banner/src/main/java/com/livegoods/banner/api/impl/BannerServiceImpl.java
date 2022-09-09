package com.livegoods.banner.api.impl;


import com.livegoods.banner.mapper.BannerMapper;
import com.livegoods.pojo.Banner;
import com.livegoos.banner.api.BannerServiceAPI;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基于dubbo提供的服务
 * 只考虑服务功能，不考虑业务逻辑
 *
 * 只要用dubbo开发服务接口，都加上分组和版本
 */
@DubboService(group = "banner",version = "1.0")
public class BannerServiceImpl implements BannerServiceAPI {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> getBanners() {
        return bannerMapper.selectBanners();
    }
}
