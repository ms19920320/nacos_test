package com.citycloud.nacostest.stock.controller;


import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.stock.service.TestStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/TestStockController")
public class TestStockController {
    @Autowired
    private TestStockService testStockService;


    @PostMapping(value = "/updateStock")
    public ResValue updateStock(@RequestBody Map<String, Object> params) {
        return testStockService.updateStock(params);
    }
}
