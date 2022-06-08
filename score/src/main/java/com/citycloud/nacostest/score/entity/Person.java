package com.citycloud.nacostest.score.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@Data
public class Person {
    private String id;
    private String name;
    private int age;
    private Date birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
