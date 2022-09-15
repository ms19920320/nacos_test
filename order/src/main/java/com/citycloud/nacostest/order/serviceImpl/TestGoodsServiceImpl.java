package com.citycloud.nacostest.order.serviceImpl;

import com.citycloud.nacostest.order.entity.TestGoods;
import com.citycloud.nacostest.order.mapper.TestGoodsMapper;
import com.citycloud.nacostest.order.service.TestGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 货物表 服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@Service
public class TestGoodsServiceImpl extends ServiceImpl<TestGoodsMapper, TestGoods> implements TestGoodsService {

}
