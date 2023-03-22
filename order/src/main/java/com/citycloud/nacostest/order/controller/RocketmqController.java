package com.citycloud.nacostest.order.controller;

import com.citycloud.nacostest.order.service.MessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * rocketmq测试类
 *
 * @author ms
 * @since 2023/03/22
 */
@RestController
@RequestMapping("/rocketmq")
public class RocketmqController {

    @Resource
    private MessageProducer messageProducer;

    @GetMapping("/message")
    public void message() throws Exception {
        messageProducer.run("");
    }
}
