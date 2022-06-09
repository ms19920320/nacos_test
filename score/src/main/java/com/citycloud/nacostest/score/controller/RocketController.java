package com.citycloud.nacostest.score.controller;

import com.alibaba.fastjson.JSON;
import com.citycloud.nacostest.score.entity.Order;
import com.citycloud.nacostest.score.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 孟帅
 * @since 2022/6/9
 */
@RestController
@RequestMapping("/rocketController")
@Slf4j
public class RocketController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    private static Integer count = 5;

    /**
     * http://localhost:8761/order/prod/1
     *
     * @param id
     * @return
     */
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer id) {
        log.info("收到下单请求，准备查询商品信息。id={}", id);
        if (id < 0) {
            log.info("不存在该商品");
            return null;
        } else {
            Product product = new Product();
            product.setName("电视");
            product.setCount(count);
            product.setMoney(1500);
            log.info("商品信息查询成功。内容为：{}", JSON.toJSONString(product));
            // 进行容错判断
            if (count <= 0) {
                log.info("商品库存不足下单失败");
                return null;
            }
            log.info("库存数量。count={}", count);
            count--;
            product.setCount(count);
            // 生成商品信息保存
            Order order = new Order();
            order.setOid(UUID.randomUUID().toString());
            order.setPid(1);
            order.setPname("电视");
            log.info("订单信息保存成功。内容为：{}", JSON.toJSONString(order));
            rocketMQTemplate.convertAndSend("order", order);
            return order;
        }
    }
}
