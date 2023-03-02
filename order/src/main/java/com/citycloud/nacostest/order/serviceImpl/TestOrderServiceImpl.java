package com.citycloud.nacostest.order.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.order.entity.TestGoods;
import com.citycloud.nacostest.order.entity.TestOrder;
import com.citycloud.nacostest.order.fegin.IScoreService;
import com.citycloud.nacostest.order.fegin.IStockService;
import com.citycloud.nacostest.order.mapper.TestGoodsMapper;
import com.citycloud.nacostest.order.mapper.TestOrderMapper;
import com.citycloud.nacostest.order.service.TestOrderService;
import com.citycloud.nacostest.order.vo.TestOrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author ms
 * @since 2022-06-29
 */
@Service
public class TestOrderServiceImpl extends ServiceImpl<TestOrderMapper, TestOrder> implements TestOrderService {
    @Autowired
    private TestOrderMapper testOrderMapper;

    @Autowired
    private TestGoodsMapper testGoodsMapper;

    @Autowired
    private IScoreService iScoreService;

    @Autowired
    private IStockService iStockService;

    @Override
    @Transactional
    public ResValue insert(TestOrderVo testOrderVo) {
        List<Map<String, Object>> detail = testOrderVo.getDetail();
        String accountId = testOrderVo.getAccountId();
        detail.stream().forEach(p -> {
            String goodsId = (String) p.get("goodsId");
            Integer count = (Integer) p.get("count");
            TestGoods testGoods = testGoodsMapper.selectById(goodsId);
            Long score = testGoods.getScore();

            // 更新积分
            Map<String, Object> scoreParam = new HashMap<>();
            scoreParam.put("accountId", accountId);
            scoreParam.put("score", count * score);
            scoreParam.put("isAdd", true);
            iScoreService.updateScore(scoreParam);

            // 更新库存
            Map<String, Object> stockParam = new HashMap<>();
            stockParam.put("goodsId", goodsId);
            stockParam.put("count", count);
            stockParam.put("isAdd", false);
            iStockService.updateStock(stockParam);
        });
        TestOrder testOrder = new TestOrder();
        BeanUtils.copyProperties(testOrderVo, testOrder);
        testOrder.setId(UUID.randomUUID().toString());
        testOrder.setDetail(JSON.toJSONString(detail));
        // 插入订单
        testOrderMapper.insert(testOrder);
        int b = 1/0;
        return ResValue.success();
    }
}
