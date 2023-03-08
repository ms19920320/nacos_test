package com.citycloud.nacostest.stock.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.stock.entity.TestStock;
import com.citycloud.nacostest.stock.mapper.TestStockMapper;
import com.citycloud.nacostest.stock.service.TestStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@Service
public class TestStockServiceImpl extends ServiceImpl<TestStockMapper, TestStock> implements TestStockService {
    @Autowired
    private TestStockMapper testStockMapper;

    @Override
    public ResValue updateStock(Map<String, Object> params) {

        String goodsId = (String) params.get("goodsId");
        Integer num = (Integer) params.get("count");
        boolean isAdd = (boolean) params.get("isAdd");
        QueryWrapper<TestStock> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TestStock::getGoodsId,goodsId);
        TestStock testStock = testStockMapper.selectOne(queryWrapper);
        if (testStock == null) {
            return ResValue.failedWithCodeAndMsg("1000", "无效的货物id");
        }
        if (isAdd) {
            testStock.setStock(testStock.getStock() + num);
        } else {
            Long stock = testStock.getStock();
            if (stock < num) {
                return ResValue.failedWithCodeAndMsg("1000", "存储不足");
            }
            testStock.setStock(testStock.getStock() - num);
        }
        testStockMapper.updateById(testStock);
        return ResValue.success();
    }
}
