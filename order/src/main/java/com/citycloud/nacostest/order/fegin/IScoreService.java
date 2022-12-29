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
@FeignClient(value = "score")
public interface IScoreService {

    /**
     * 更新积分
     *
     * @return
     */
    @RequestMapping(value = "/TestScoreController/updateScore", method = RequestMethod.POST)
    ResValue updateScore(@RequestBody Map<String, Object> params);


}
