package com.citycloud.nacostest.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author 孟帅
 * @since 2022/4/22
 */
@SpringBootApplication(scanBasePackages = {"com.citycloud.nacostest.gateway"})
@MapperScan(basePackages = {"com.citycloud.nacostest.gateway.mapper"})
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
