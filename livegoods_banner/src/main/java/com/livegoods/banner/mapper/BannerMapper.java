package com.livegoods.banner.mapper;


import com.livegoods.pojo.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 轮播图数据访问接口
 */
@Mapper
public interface BannerMapper {
    /**
     * 查询所欲符合条件的轮播图数据
     */
    List<Banner> selectBanners();
}
