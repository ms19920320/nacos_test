package com.citycloud.nacostest.gateway.config;

import com.alibaba.fastjson.JSON;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.common.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * 权限过滤
 *
 * @author ms
 * @since 2023/03/09
 **/
@Component
@RefreshScope
@Service
public class LoginFilter implements GlobalFilter, Ordered {
    @Autowired
    private RedisUtil redisUtil;

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
            return writeResponse(exchange.getResponse(), ResValue.failedWithMsg("请输入token"));
        }
        Object o = redisUtil.getValue(token);
        if (o == null) {
            return writeResponse(exchange.getResponse(), ResValue.failedWithMsg("token校验不通过"));
        }
        return chain.filter(exchange);
    }

    /**
     * 构建返回内容
     *
     * @param response ServerHttpResponse
     * @param resValue 输出返回内容
     * @return Mono
     */
    protected Mono<Void> writeResponse(ServerHttpResponse response, ResValue resValue) {
        byte[] bits = JSON.toJSONString(resValue).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.OK);
        // 指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
