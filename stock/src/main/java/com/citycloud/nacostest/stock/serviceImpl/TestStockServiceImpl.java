package com.citycloud.nacostest.stock.serviceImpl;

import com.citycloud.nacostest.stock.entity.TestStock;
import com.citycloud.nacostest.stock.mapper.TestStockMapper;
import com.citycloud.nacostest.stock.service.TestStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@Service
public class TestStockServiceImpl extends ServiceImpl<TestStockMapper, TestStock> implements TestStockService {

}
