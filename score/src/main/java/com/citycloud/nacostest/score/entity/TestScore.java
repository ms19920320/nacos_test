package com.citycloud.nacostest.score.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 积分表
 * </p>
 *
 * @author ms
 * @since 2022-06-27
 */
@Getter
@Setter
@TableName("test_score")
@ApiModel(value = "TestScore对象", description = "积分表")
public class TestScore implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("账号id")
    @TableField("account_id")
    private String accountId;

    @ApiModelProperty("当前积分")
    @TableField("score")
    private Long score;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private String updateTime;


}
