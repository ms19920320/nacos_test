package com.citycloud.nacostest.score.rocketmq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author ms
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "provider", topic = "order")
public class MessageReceiveService implements RocketMQListener<Object> {
    @Override
    public void onMessage(Object o) {
        log.info("收到订单信息，内容如下：{}， ", JSON.toJSONString(o));
    }
}
