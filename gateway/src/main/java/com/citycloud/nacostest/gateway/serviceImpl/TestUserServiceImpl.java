package com.citycloud.nacostest.gateway.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.gateway.mapper.TestUserMapper;
import com.citycloud.nacostest.gateway.service.TestUserService;
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
