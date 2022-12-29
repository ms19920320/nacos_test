package com.citycloud.nacostest.score.service;

import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.score.entity.TestScore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 积分表 服务类
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
public interface TestScoreService extends IService<TestScore> {
    /**
     * 更新用户积分
     *
     * @param params 参数
     * @return 是否更新成功
     */
    ResValue updateScore(Map<String, Object> params);
}
