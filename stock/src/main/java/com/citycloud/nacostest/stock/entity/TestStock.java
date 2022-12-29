package com.citycloud.nacostest.stock.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author ms
 * @since 2022-08-18
 */
@Getter
@Setter
@TableName("test_stock")
@ApiModel(value = "TestStock对象", description = "")
public class TestStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private String id;

    @ApiModelProperty("商品id")
    @TableField("goods_id")
    private String goodsId;

    @ApiModelProperty("当前库存")
    @TableField("stock")
    private Long stock;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private String updateTime;


}
