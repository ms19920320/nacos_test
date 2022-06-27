package com.citycloud.nacostest.score.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_order")
public class TestOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField("id")
    private String id;

    /**
     * 账号id
     */
    @TableField("account_id")
    private String accountId;

    /**
     * 订单详情
     */
    @TableField("detail")
    private String detail;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private String goodsId;


}
