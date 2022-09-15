package com.citycloud.nacostest.score.controller;


import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.score.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@RestController
@RequestMapping("/score/test-user")
public class TestUserController {
    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping(value = "/findUsers")
    public List<TestUser> findUsers() {
        redisTemplate.opsForValue().set("name", "zs");
        redisTemplate.opsForValue().set("age", 24);
        TestUser testUser = new TestUser();
        testUser.setAddress("aa");
        testUser.setId(UUID.randomUUID().toString());
        testUser.setName("aba");
        testUser.setTelephone("232423");
        redisTemplate.opsForValue().set("user", testUser, 3000, TimeUnit.SECONDS);
        redisTemplate.opsForList().leftPush("list", "zs");
        redisTemplate.opsForList().leftPush("list", "lisi");
        return testUserMapper.findUsers();
    }

}
