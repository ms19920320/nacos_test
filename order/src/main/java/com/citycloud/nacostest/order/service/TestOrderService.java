package com.citycloud.nacostest.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.order.entity.TestOrder;
import com.citycloud.nacostest.order.vo.TestOrderVo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author ms
 * @since 2022-06-29
 */
public interface TestOrderService extends IService<TestOrder> {
    /**
     * 插入订单数据
     *
     * @param testOrder 参数
     * @return 插入结果
     */
    ResValue insert(@RequestBody TestOrderVo testOrderVo);
}
