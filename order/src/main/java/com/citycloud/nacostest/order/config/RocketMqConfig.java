package com.citycloud.nacostest.order.config;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rocketmq全局实力类
 *
 * @author 孟帅
 * @since 2022/4/28
 */
@Configuration
public class RocketMqConfig {

    @Bean
    public RocketMQTemplate rocketMQTemplate() {
        return new RocketMQTemplate();
    }

}
