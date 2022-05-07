package com.citycloud.nacostest.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孟帅
 * @since 2022/5/7
 */
@RestController
@RequestMapping("testController")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "gateway test";
    }
}
