package com.citycloud.nacostest.score.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分表
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_score")
public class TestScore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 账号id
     */
    @TableField("account_id")
    private String accountId;

    /**
     * 当前积分
     */
    @TableField("score")
    private Long score;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
