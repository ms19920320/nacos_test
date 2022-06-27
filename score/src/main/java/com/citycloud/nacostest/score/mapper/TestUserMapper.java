package com.citycloud.nacostest.score.mapper;

import com.citycloud.nacostest.score.entity.TestUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Mapper
public interface TestUserMapper extends BaseMapper<TestUser> {
    List<TestUser> findUsers();
}
