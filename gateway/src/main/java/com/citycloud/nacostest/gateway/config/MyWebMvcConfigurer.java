package com.citycloud.nacostest.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义视图管理配置
 *
 * @author ms
 * @since 2023/03/13
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    TokenInterceptor tokenInterceptor;

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(1048576);
        // 1048576上传文件大小 50M 50*1024*1024
        resolver.setMaxUploadSize(50 * 1024 * 1024);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/gateway/**")
        ;
    }

    /**
     * spring.mvc.pathmatch.use-suffix-pattern=false
     * spring.mvc.pathmatch.use-registered-suffix-pattern=true
     *
     * @param pathMatchConfigurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        pathMatchConfigurer.setUseSuffixPatternMatch(false);
        //将http://www/ww.xx的链接同http://www/ww等价，配置完后会在匹配servlet时将.xx自动忽略
        pathMatchConfigurer.setUseRegisteredSuffixPatternMatch(true);
    }

    /**
     * spring.mvc.contentnegotiation.favor-path-extension=false
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}
