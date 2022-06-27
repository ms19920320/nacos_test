package com.citycloud.nacostest.score.service.impl;

import com.citycloud.nacostest.score.entity.TestOrder;
import com.citycloud.nacostest.score.mapper.TestOrderMapper;
import com.citycloud.nacostest.score.service.TestOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Service
public class TestOrderServiceImpl extends ServiceImpl<TestOrderMapper, TestOrder> implements TestOrderService {

}
