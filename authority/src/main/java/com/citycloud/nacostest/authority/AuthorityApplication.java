package com.citycloud.nacostest.authority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 孟帅
 * @since 2022/4/22
 */
@SpringBootApplication(scanBasePackages = {"com.citycloud.nacostest"})
@EnableDiscoveryClient
@MapperScan(basePackages = "com.citycloud.nacostest.authority.mapper")
@EnableFeignClients
public class AuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityApplication.class, args);
    }
}
