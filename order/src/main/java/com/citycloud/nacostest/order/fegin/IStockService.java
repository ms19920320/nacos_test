package com.citycloud.nacostest.order.fegin;


import com.citycloud.nacostest.common.exception.ResValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * @author wbm
 * @version 1.0
 * @date 2022/7/20 9:34
 */
@FeignClient(path = "stock", value = "stock")
public interface IStockService {

    /**
     * 更新存储
     *
     * @return 是否更新成功
     */
    @RequestMapping(value = "/TestStockController/updateStock", method = RequestMethod.POST)
    ResValue updateStock(@RequestBody Map<String, Object> params);

}
