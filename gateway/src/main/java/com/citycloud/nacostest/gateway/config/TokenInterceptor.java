package com.citycloud.nacostest.gateway.config;

import com.citycloud.nacostest.common.annotation.NoToken;
import com.citycloud.nacostest.common.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token权限认证拦截器
 *
 * @author ms
 * @since 2023/03/13
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = null;
        try {
            method = (HandlerMethod) handler;
        } catch (ClassCastException var10) {
            throw new MyException("系统内部错误");
        }
        if (method.getBeanType().isAnnotationPresent(NoToken.class)) {
            return true;
        }
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new MyException("无效请求，请输入token");
        }
        Object o = redisTemplate.opsForValue().get(token);
        if (o == null) {
            throw new MyException("token无效或已过期");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }


}
