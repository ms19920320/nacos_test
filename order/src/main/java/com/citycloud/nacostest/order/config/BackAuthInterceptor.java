//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.citycloud.nacostest.order.config;

import com.citycloud.nacostest.common.annotation.NoToken;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 *
 * @author ms
 * @since 2023/03/07
 */
@Component
@Slf4j
public class BackAuthInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public BackAuthInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new MyException("请求头缺乏token");
        }
        HandlerMethod method;
        try {
            method = (HandlerMethod) handler;
        } catch (ClassCastException var10) {
            return true;
        }
        if (method.getBeanType().isAnnotationPresent(NoToken.class)) {
            return true;
        }
        TestUser testUser = (TestUser) redisTemplate.opsForValue().get("token");
        if (testUser != null) {
            return true;
        }
        return false;
    }
}
