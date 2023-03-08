package com.citycloud.nacostest.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web视图管理配置
 *
 * @author ms
 * @since 2023/03/07
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    BackAuthInterceptor backAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(backAuthInterceptor)
                .addPathPatterns("/gateway/**")
                .excludePathPatterns("/gateway/login/**")
        ;
    }
}
