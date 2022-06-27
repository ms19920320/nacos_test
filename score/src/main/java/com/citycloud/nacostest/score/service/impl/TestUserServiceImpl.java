package com.citycloud.nacostest.score.service.impl;

import com.citycloud.nacostest.score.entity.TestUser;
import com.citycloud.nacostest.score.mapper.TestUserMapper;
import com.citycloud.nacostest.score.service.TestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {

}
