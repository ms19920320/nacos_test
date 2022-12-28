package com.citycloud.nacostest.score.feign;


import com.citycloud.nacostest.common.exception.ResValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author wbm
 * @version 1.0
 * @date 2022/7/20 9:34
 */
@FeignClient(path = "order", value = "order")
public interface IOrderService {

    /**
     * 身份证信息OCR识别
     *
     * @return
     */
    @RequestMapping(value = "/OrderTestController/aa", method = RequestMethod.GET)
    ResValue aa();


}
