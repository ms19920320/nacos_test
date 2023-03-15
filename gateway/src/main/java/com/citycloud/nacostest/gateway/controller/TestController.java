package com.citycloud.nacostest.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.citycloud.nacostest.common.annotation.NoToken;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.common.util.RsaUtils;
import com.citycloud.nacostest.gateway.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("testController")
@RefreshScope
public class TestController {

    @Autowired
    private TestUserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${name}")
    private String name;

    @GetMapping("/test")
    public String test() {
        return "gateway test " + name;
    }

    @PostMapping
    @NoToken
    @RequestMapping("/login")
    public ResValue login(@RequestBody TestUser testUser) {
        if (testUser == null) {
            return ResValue.failedWithMsg("请输入用户名或者密码");
        }
        String name = testUser.getName();
        String password = testUser.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return ResValue.failedWithMsg("请输入用户名或者密码");
        }
        QueryWrapper<TestUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TestUser::getName, name);
        TestUser testUser1 = userMapper.selectOne(queryWrapper);
        if (testUser1 == null) {
            return ResValue.failedWithMsg("用户名或者密码错误");
        }
        String token;
        try {
            token = RsaUtils.encryptByPublicKey(RsaUtils.publicKey, name + "-" + password);
            redisTemplate.opsForValue().set(token, testUser1, 50, TimeUnit.MINUTES);
        } catch (Exception e) {
            return ResValue.failedWithMsg("系统内部错误，请稍后再试");
        }
        TestUser o = (TestUser) redisTemplate.opsForValue().get(token);
        System.out.println("o is " + JSON.toJSONString(o));
        return ResValue.successWithMsgAndData("登录成功", token);
    }
}
