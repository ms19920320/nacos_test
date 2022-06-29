package com.citycloud.nacostest.order.mapper;

import com.citycloud.nacostest.order.entity.TestOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单信息 Mapper 接口
 * </p>
 *
 * @author ms
 * @since 2022-06-29
 */
@Mapper
public interface TestOrderMapper extends BaseMapper<TestOrder> {

}
