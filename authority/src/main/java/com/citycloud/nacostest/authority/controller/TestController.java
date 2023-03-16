package com.citycloud.nacostest.authority.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.citycloud.nacostest.authority.mapper.TestUserMapper;
import com.citycloud.nacostest.authority.service.TestUserService;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.common.util.RsaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 测试类
 *
 * @author 孟帅
 * @since 2022/5/7
 */
@RestController
@RequestMapping("/gateway/testController")
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
