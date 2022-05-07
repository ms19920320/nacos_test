package com.citycloud.nacostest.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@RestController
@RequestMapping("/orderController")
public class OrderController {
    @GetMapping("/test")
    public String test() {
        return "order1 test";
    }
}
