package com.citycloud.nacostest.common.util;

import com.citycloud.nacostest.common.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis操作公共类
 *
 * @author 孟帅
 * @since 2023/3/17
 */
@Component
@ComponentScan
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtil() {
        System.out.println("RedisUtil init");
    }

    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setValueTime(String key, Object value, Long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    public void setValueTimeUnit(String key, Object value, Integer time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    public boolean delValue(String key) {
        return redisTemplate.delete(key);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public TestUser getUser(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            return null;
        }
        if (o instanceof TestUser) {
            return (TestUser) o;
        }
        return null;
    }
}
