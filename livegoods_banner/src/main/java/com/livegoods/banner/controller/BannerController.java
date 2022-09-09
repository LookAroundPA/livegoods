package com.livegoods.banner.controller;

import com.livegoods.banner.service.BannerService;
import com.livegoods.commons.pojo.LiveGoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 轮播图控制器
 */
@RestController
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping("/Banner")
    public LiveGoodsResult getBanners(){
        return bannerService.getBanners();
    }
}
