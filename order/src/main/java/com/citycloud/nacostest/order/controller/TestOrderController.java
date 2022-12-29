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
import com.citycloud.nacostest.order.vo.TestOrderVo;
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
@RequestMapping("/TestOrderController")
public class TestOrderController {
    @Autowired
    private TestOrderService testOrderService;

    @PostMapping(value = "insert")
    public ResValue insert(@RequestBody TestOrderVo testOrderVo) {
        return testOrderService.insert(testOrderVo);
    }
}
