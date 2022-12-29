package com.citycloud.nacostest.stock.service;

import com.citycloud.nacostest.common.exception.ResValue;
import com.citycloud.nacostest.stock.entity.TestStock;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
public interface TestStockService extends IService<TestStock> {
    /**
     * 更新货物存储
     *
     * @param params 参数
     * @return 是否更新成功
     */
    ResValue updateStock(Map<String, Object> params);
}
