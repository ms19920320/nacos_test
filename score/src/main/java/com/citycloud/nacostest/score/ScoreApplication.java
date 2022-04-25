package com.citycloud.nacostest.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 孟帅
 * @since 2022/4/22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ScoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoreApplication.class, args);
    }
}
