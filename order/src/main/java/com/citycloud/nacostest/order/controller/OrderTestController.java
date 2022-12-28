package com.citycloud.nacostest.order.controller;


import com.citycloud.nacostest.common.exception.ResValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 货物表 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/OrderTestController")
public class OrderTestController {
    @GetMapping("/aa")
    public ResValue aa() {
        System.out.println("aa");
        return ResValue.success();
    }
}
