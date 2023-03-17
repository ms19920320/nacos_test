package com.citycloud.nacostest.authority.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
public interface TestUserService extends IService<TestUser> {

    /**
     * 登录接口
     *
     * @param testUser 用户信息
     * @return 登录结果
     */
    ResValue login(TestUser testUser);

    /**
     * 退出接口
     *
     * @param request .
     * @return
     */
    ResValue logout(HttpServletRequest request);

}
