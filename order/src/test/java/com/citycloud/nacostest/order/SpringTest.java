package com.citycloud.nacostest.order;

import com.citycloud.nacostest.common.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 孟帅
 * @since 2022/7/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test() {
    }

}



