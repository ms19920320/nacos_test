package com.citycloud.nacostest.score.controller;


import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.score.mapper.TestUserMapper;
import com.citycloud.nacostest.score.feign.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@RestController
@RequestMapping("/score/ScoreTestController")
public class ScoreTestController {
    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping(value = "/aa")
    public ResValue aa() {
        return orderService.aa();
    }

}
