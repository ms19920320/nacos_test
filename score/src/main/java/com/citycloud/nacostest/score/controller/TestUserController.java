package com.citycloud.nacostest.score.controller;


import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.score.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(value = "/findUsers")
    public List<TestUser> findUsers() {
        return testUserMapper.findUsers();
    }
}
