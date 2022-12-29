package com.citycloud.nacostest.score.controller;


import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.score.service.TestScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 积分表 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@RestController
@RequestMapping("/TestScoreController")
@Slf4j
public class TestScoreController {
    @Autowired
    private TestScoreService testScoreService;

    @PostMapping(value = "/updateScore")
    public ResValue updateScore(@RequestBody Map<String, Object> params) {
        return testScoreService.updateScore(params);
    }


}
