package com.citycloud.nacostest.score.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 货物表
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_goods")
public class TestGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField("id")
    private String id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 单价
     */
    @TableField("price")
    private BigDecimal price;


}
