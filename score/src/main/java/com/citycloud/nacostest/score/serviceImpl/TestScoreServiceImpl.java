package com.citycloud.nacostest.score.serviceImpl;

import com.citycloud.nacostest.score.entity.TestScore;
import com.citycloud.nacostest.score.mapper.TestScoreMapper;
import com.citycloud.nacostest.score.service.TestScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
