package com.citycloud.nacostest.authority.controller;

import com.citycloud.nacostest.authority.service.TestUserService;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 *
 * @author 孟帅
 * @since 2022/5/7
 */
@RestController
@RequestMapping("/testController")
@RefreshScope
public class TestController {
    @Autowired
    private TestUserService testUserService;


    @PostMapping
    @RequestMapping("/login")
    public ResValue login(@RequestBody TestUser testUser) {
        return testUserService.login(testUser);
    }
}
