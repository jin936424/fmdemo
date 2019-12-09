package com.server.zhserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * Created by dz on 2019-12-4
 */
@Configuration
public class PicutreConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/profile/**").
                addResourceLocations("E:\\Idea_workspace\\taskspace\\zh-server\\src\\main\\resources\\static\\headpoint");
    }
}
