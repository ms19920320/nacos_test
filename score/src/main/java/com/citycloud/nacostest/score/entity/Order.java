package com.citycloud.nacostest.score.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@Data
public class Order {
    private String oid;
    private Integer pid;
    private String name;
    private String pname;
}
