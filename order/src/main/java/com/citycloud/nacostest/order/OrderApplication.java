package com.citycloud.nacostest.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 孟帅
 * @since 2022/4/22
 */
@SpringBootApplication(scanBasePackages = "com.citycloud.nacostest")
@EnableDiscoveryClient
@MapperScan(basePackages = "com.citycloud.nacostest.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
