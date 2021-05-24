package com.example.wsn.bbsadminsys.config;
/*
 *project:JavaCode
 *file:MyWebAppConfiguration
 *@author:wsn
 *date:2021/5/19 11:23
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在< img src="/Path/picName.jpg" />便可以直接引用图片
         *这是图片的物理路径  "file:/+本地图片的地址"
         */
        registry.addResourceHandler("/imgs/**").addResourceLocations("file:/E:/img/");
        super.addResourceHandlers(registry);
    }
}
