package com.citycloud.nacostest.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.citycloud.nacostest.common.exception.MyException;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.order.entity.TestGoods;
import com.citycloud.nacostest.order.entity.TestOrder;
import com.citycloud.nacostest.order.mapper.TestGoodsMapper;
import com.citycloud.nacostest.order.service.TestOrderService;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map;

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
    private RestTemplate restTemplate;

    @Autowired
    private TestGoodsMapper testGoodsMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "insert")
    public ResValue insert(@RequestBody TestOrder testOrder) {
        return testOrderService.save(testOrder) ? ResValue.success() : ResValue.failed();
    }

    @PostMapping(value = "validateGlobalException")
    public ResValue validateGlobalException() throws MyException {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            throw new MyException();
        }
        return ResValue.successWithMsg("验证全局异常");
    }

    @PostMapping(value = "testRocketMq")
    public ResValue testRocketMq() {
        // 发送一个同步消息，会返回值 ---发送到 stringTopic 主题
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accountId", "01");
        jsonObject.put("score", 5);
        // SendResult sendResult = rocketMQTemplate.syncSend("ms-score", "Hello RocketMQ");
        return ResValue.successWithMsg("sendResult.toString()");
    }

    @PostMapping(value = "/createOrder")
    public ResValue createOrder(@RequestBody TestOrder testOrder) {
        testOrder.setId(UUID.randomUUID().toString());
        String accountId = testOrder.getAccountId();
        String goodsId = testOrder.getGoodsId();
        TestGoods testGoods = testGoodsMapper.selectById(goodsId);
        Long score = testGoods.getScore();
        Map<String, Object> params = new HashMap<>();
        params.put("accountId", accountId);
        params.put("score", score);
        params.put("isAdd", true);

        List<ServiceInstance> score1 = discoveryClient.getInstances("score");
        ServiceInstance serviceInstance = score1.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();


        String scoreUrl = "http://192.168.99.103:8060/score/score/test-score/updateScore";
//        String scoreUrl = "http://" + host + ":" + port + "/score/test-score/updateScore";
        ResValue res = restTemplate.postForObject(scoreUrl,
                params, ResValue.class);

        String stockUrl = "http://stock/stock/test-stock/updateStock";
        ResValue res1 = restTemplate.getForObject(stockUrl, ResValue.class
                , params);
        if (res.getCode() == ResValue.success().getCode() && res1.getCode() == ResValue.failed().getCode()) {
            return ResValue.success();
        } else {
            return ResValue.failed();
        }
    }
}
