package com.citycloud.nacostest.score.config;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Timing  {

//
//    @Override
//    public void execute() throws Exception {
//        List<User> list = userService.lambdaQuery().list();
//        for (User user : list) {
//            log.debug(user.getName());
//        }
//    }

    // 可参考Sample示例执行器中的 "com.xxl.job.executor.service.jobhandler.SampleXxlJob" ，如下：
    @XxlJob("aabb")
    public ReturnT<String> aabb() throws Exception {
        try {
            log.info("aabb success");
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            log.info("aabb failed");
            return ReturnT.FAIL;
        }

    }
}
