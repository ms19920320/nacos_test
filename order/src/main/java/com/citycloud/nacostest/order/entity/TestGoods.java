package com.citycloud.nacostest.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 货物表
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@Getter
@Setter
@TableName("test_goods")
@ApiModel(value = "TestGoods对象", description = "货物表")
public class TestGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private String id;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("单价")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("商品积分")
    @TableField("score")
    private Long score;


}
