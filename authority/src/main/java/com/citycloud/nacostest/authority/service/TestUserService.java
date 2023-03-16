package com.citycloud.nacostest.authority.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
public interface TestUserService extends IService<TestUser> {

    ResValue login(TestUser testUser);

}
