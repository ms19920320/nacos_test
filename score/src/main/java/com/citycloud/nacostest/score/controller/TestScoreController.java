package com.citycloud.nacostest.score.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.score.entity.TestScore;
import com.citycloud.nacostest.score.mapper.TestScoreMapper;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 积分表 前端控制器
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@RestController
@RequestMapping("/score/test-score")
@Slf4j
public class TestScoreController {
    @Autowired
    private TestScoreMapper testScoreMapper;

    @PostMapping(value = "/updateScore")
    public ResValue updateScore(@RequestBody Map<String, Object> params) {
        String accountId = (String) params.get("accountId");
        Integer score = (Integer) params.get("score");
        boolean isAdd = (boolean) params.get("isAdd");
        QueryWrapper<TestScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TestScore::getAccountId, accountId);
        TestScore testScore = testScoreMapper.selectOne(queryWrapper);
        if (testScore == null) {
            testScore = new TestScore();
            testScore.setId(UUID.randomUUID().toString());
            testScore.setAccountId(accountId);
            testScore.setScore(0L + score);
            testScoreMapper.insert(testScore);
            return ResValue.success();
        }
        if (isAdd) {
            testScore.setScore(testScore.getScore() + score);
        } else {
            testScore.setScore(testScore.getScore() - score);
        }
        testScoreMapper.updateById(testScore);
        return ResValue.success();
    }


    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("aa")
    public void aa() throws Exception {
        log.info("demoJobHandler start");
        XxlJobHelper.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        log.info("demoJobHandler end");
        // default success
        // }
    }
}
