package com.livegoods.banner;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDubbo
@EnableDubboConfig
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.livegoods.banner.mapper"})
public class LiveGoodsBannerApp {
    public static void main(String[] args) {
        SpringApplication.run(LiveGoodsBannerApp.class,args);
    }
}
