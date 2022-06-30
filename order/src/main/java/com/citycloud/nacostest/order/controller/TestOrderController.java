package com.citycloud.nacostest.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.order.entity.TestOrder;
import com.citycloud.nacostest.order.service.TestOrderService;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单信息 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-06-29
 */
@RestController
@RequestMapping("/order/test-order")
public class TestOrderController {
    @Autowired
    private TestOrderService testOrderService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping(value = "insert")
    public ResValue insert(@RequestBody TestOrder testOrder) {
        return testOrderService.save(testOrder) ? ResValue.success() : ResValue.failed();
    }

    @PostMapping(value = "validateGlobalException")
    public ResValue validateGlobalException() {
        int a = 1 / 0;
        return ResValue.successWithMsg("验证全局异常");
    }

    @PostMapping(value = "testRocketMq")
    public ResValue testRocketMq() {
        // 发送一个同步消息，会返回值 ---发送到 stringTopic 主题
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accountId", "01");
        jsonObject.put("score", 5);
        SendResult sendResult = rocketMQTemplate.syncSend("ms-score", "Hello RocketMQ");
        return ResValue.successWithMsg(sendResult.toString());
    }
}
