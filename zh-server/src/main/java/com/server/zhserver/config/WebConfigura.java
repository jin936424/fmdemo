package com.server.zhserver.config;

import com.server.zhserver.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * Created by dz on 2019-11-18
 * @author Administrator
 */
// @SpringBootConfiguration
public class WebConfigura implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这条语句的作用是对所有路径应用拦截器，除了 /index.html。
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").
                excludePathPatterns("/index.xml").
                excludePathPatterns("/api/login").
                excludePathPatterns("/api/logout");
    }
}
