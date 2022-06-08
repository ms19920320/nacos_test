package com.citycloud.nacostest.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@RestController
@RequestMapping("/scoreController")
@RefreshScope
public class ScoreController {
    @Value("${name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test() {
        return "score test";
    }

    @GetMapping("/getName")
    public String getName() {
        return name;
    }

    @GetMapping("/orderTest")
    public String orderTest() {
        String forObject = restTemplate.getForObject("http://order/order/orderController/test", String.class);
        return forObject;
    }
}
