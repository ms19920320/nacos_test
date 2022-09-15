package com.citycloud.nacostest.stock.controller;


import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.stock.entity.TestStock;
import com.citycloud.nacostest.stock.mapper.TestStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/stock/test-stock")
public class TestStockController {
    @Autowired
    private TestStockMapper testStockMapper;


    @PostMapping(value = "/updateStock")
    public ResValue updateStock(@RequestBody Map<String, Object> params) {

        String accountId = (String) params.get("goodsId");
        Integer num = (Integer) params.get("num");
        boolean isAdd = (boolean) params.get("isAdd");
        TestStock testStock = testStockMapper.selectById(accountId);
        if (testStock == null) {
            ResValue.failedWithCodeAndMsg(1000, "无效的货物id");
        }
        if (isAdd) {
            testStock.setStock(testStock.getStock() + num);
        } else {
            testStock.setStock(testStock.getStock() - num);
        }
        return ResValue.success();
    }
}
