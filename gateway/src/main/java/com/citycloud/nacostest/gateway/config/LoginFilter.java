package com.citycloud.nacostest.gateway.config;

import com.citycloud.nacostest.common.exception.MyException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

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

    /**
     * 不需要校验的接口
     */
    @Value("${allow.not.valid.url:}")
    private String allowNotValidUrl;

    public LoginFilter() {
        System.out.println("aa loginFilter");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("bb filter");
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        String[] split = allowNotValidUrl.split(",");
        List<String> list = Arrays.asList(split);
        if (list.contains(path)) {
            return chain.filter(exchange);
        }
        // 获取token头
        String token = request.getHeaders().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            throw new MyException("无法获取token");
        }
        Object o = redisTemplate.opsForValue().get(token);
        if (o == null) {
            throw new MyException("token校验不通过");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
