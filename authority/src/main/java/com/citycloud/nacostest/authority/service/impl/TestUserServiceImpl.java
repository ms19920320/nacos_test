package com.citycloud.nacostest.authority.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.citycloud.nacostest.authority.mapper.TestUserMapper;
import com.citycloud.nacostest.authority.service.TestUserService;
import com.citycloud.nacostest.common.entity.TestUser;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.common.util.RedisUtil;
import com.citycloud.nacostest.common.util.RsaUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 用户表 服务实现类
 *
 * @author ms
 * @since 2022-08-18
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TestUserMapper userMapper;

    @Override
    public ResValue login(TestUser testUser) {
        if (testUser == null) {
            return ResValue.failedWithMsg("请输入用户名或者密码");
        }
        String name = testUser.getName();
        String password = testUser.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return ResValue.failedWithMsg("请输入用户名或者密码");
        }
        QueryWrapper<TestUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TestUser::getName, name);
        TestUser testUser1 = userMapper.selectOne(queryWrapper);
        if (testUser1 == null) {
            return ResValue.failedWithMsg("用户名或者密码错误");
        }
        String token;
        try {
            token = RsaUtils.encryptByPublicKey(RsaUtils.publicKey, name + "-" + password);
            redisUtil.setValueTimeUnit(token, testUser1, 50, TimeUnit.MINUTES);
        } catch (Exception e) {
            return ResValue.failedWithMsg("系统内部错误，请稍后再试");
        }
        return ResValue.successWithMsgAndData("登录成功", token);
    }

    @Override
    public ResValue logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isNotEmpty(token)) {
            redisUtil.delValue(token);
        }
        return ResValue.success();
    }
}
