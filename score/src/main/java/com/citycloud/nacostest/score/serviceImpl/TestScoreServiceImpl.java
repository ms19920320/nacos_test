package com.citycloud.nacostest.score.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.score.entity.TestScore;
import com.citycloud.nacostest.score.mapper.TestScoreMapper;
import com.citycloud.nacostest.score.service.TestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 积分表 服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Service
public class TestScoreServiceImpl extends ServiceImpl<TestScoreMapper, TestScore> implements TestScoreService {
    @Autowired
    private TestScoreMapper testScoreMapper;

    @Override
    public ResValue updateScore(Map<String, Object> params) {
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
            Long score1 = testScore.getScore();
            if (score1 < score) {
                ResValue failed = ResValue.failed();
                failed.setMessage("积分不足");
                return failed;
            }
            testScore.setScore(testScore.getScore() - score);
        }
        testScoreMapper.updateById(testScore);
        return ResValue.success();
    }
}
