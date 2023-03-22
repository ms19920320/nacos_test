package com.citycloud.nacostest.score;

import com.alibaba.fastjson.JSON;
import com.citycloud.nacostest.common.util.RedisUtil;
import com.citycloud.nacostest.score.entity.TestScore;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        A a = new A();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zs");
        map.put("sex", "男");

        Object map1 = redisUtil.getValue("HANDLE::MENGSHUAI::map");
        if (map1 != null) {
            Map<String, Object> aa = (Map<String, Object>) map1;
            System.out.println("AA IS " + JSON.toJSON(aa));
        } else {
            redisUtil.setValueTimeUnit("HANDLE::MENGSHUAI::map", map, 600, TimeUnit.SECONDS);
        }


        TestScore testScore = new TestScore();
        testScore.setScore(98l);
        testScore.setId("001");

        TestScore testScore1 = new TestScore();
        testScore1.setScore(88l);
        testScore1.setId("002");

        List<TestScore> list = new ArrayList<>();
        list.add(testScore);
        list.add(testScore1);

        a.setName("ww");
        a.setAge(23);
        a.setMap(map);
        a.setList(list);

        String key = "HANDLE::MENGSHUAI::aaa";

        Object o = redisUtil.getValue(key);
        if (o != null) {
            A b = (A) o;
            System.out.println("end--" + JSON.toJSONString(b));
        } else {
            redisUtil.setValueTimeUnit(key, a, 600, TimeUnit.SECONDS);
        }
        System.out.println("end");

    }

    @Test
    public void test1() {
        String key = "HANDLE::TOGETHER::CLIENT::15090001::331018";
        Object o = redisUtil.getValue(key);
        System.out.println("ed");

    }
}

@Data
class A implements Serializable {
    private String name;

    private Integer age;

    private Map<String, Object> map;

    private List<TestScore> list;
}


