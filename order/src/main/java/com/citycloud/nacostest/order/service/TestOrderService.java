package com.citycloud.nacostest.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.citycloud.nacostest.order.entity.TestOrder;
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
    int insert(@RequestBody TestOrder testOrder);
}
