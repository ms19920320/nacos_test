package com.citycloud.nacostest.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author ms
 * @since 2022-06-29
 */
@Getter
@Setter
@TableName("test_order")
@ApiModel(value = "TestOrder对象", description = "订单信息")
public class TestOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private String id;

    @ApiModelProperty("账号id")
    @TableField("account_id")
    private String accountId;

    @ApiModelProperty("订单详情")
    @TableField("detail")
    private String detail;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("商品id")
    @TableField("goods_id")
    private String goodsId;


}
