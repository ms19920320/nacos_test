package com.citycloud.nacostest.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限过滤
 *
 * @author ms
 * @since 2023/03/09
 **/
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);

//        // 获取token头
//        String token = request.getHeaders().getFirst("token");//获取token
//        if (!StringUtils.isEmpty(token)) {
//            if ("admin".equals(token)) {
//                return chain.filter(exchange); //如果token存在，且输入的登录名与tokenz中的一直，放行
//            }
//        }
//        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//权限不足，需要登录
//        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
