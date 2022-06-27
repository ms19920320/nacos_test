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
@TableName("test_stock")
public class TestStock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField("id")
    private String id;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private String goodsId;

    /**
     * 当前库存
     */
    @TableField("stock")
    private Long stock;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
