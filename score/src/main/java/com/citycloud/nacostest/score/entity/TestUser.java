package com.citycloud.nacostest.score.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_user")
public class TestUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField("id")
    private String id;

    /**
     * 账号名称
     */
    @TableField("name")
    private Date name;

    /**
     * 手机号码
     */
    @TableField("telphone")
    private Long telphone;

    /**
     * 地址
     */
    @TableField("address")
    private Date address;


}
