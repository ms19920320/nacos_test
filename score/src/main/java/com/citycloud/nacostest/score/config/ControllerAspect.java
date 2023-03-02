package com.citycloud.nacostest.score.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class ControllerAspect {
    @Value("${name}")
    private String name;

    public ControllerAspect() {
        System.out.println("ControllerAspect init");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void andbefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        // log.info("before param is :{}", JSON.toJSONString(args));
    }

}
