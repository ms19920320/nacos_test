package com.citycloud.nacostest.score.controller;


import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.util.RedisUtil;
import com.citycloud.nacostest.score.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    private RedisUtil redisUtil;

    @PostMapping(value = "/findUsers")
    public List<TestUser> findUsers() {
        redisUtil.setValue("name", "zs");
        redisUtil.setValue("age", 24);
        TestUser testUser = new TestUser();
        testUser.setAddress("aa");
        testUser.setId(UUID.randomUUID().toString());
        testUser.setName("aba");
        testUser.setTelephone("232423");
        redisUtil.setValueTimeUnit("user", testUser, 3000, TimeUnit.SECONDS);
        redisUtil.getRedisTemplate().opsForList().leftPush("list", "zs");
        redisUtil.getRedisTemplate().opsForList().leftPush("list", "lisi");
        return testUserMapper.findUsers();
    }

}
