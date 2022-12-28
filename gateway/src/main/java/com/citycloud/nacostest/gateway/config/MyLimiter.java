/*
 *  城云科技 ©1997-2022
 */

package com.citycloud.nacostest.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyLimiter implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        if (exchange == null) {
            return null;
        }
        return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
