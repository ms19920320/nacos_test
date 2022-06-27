package com.citycloud.nacostest.score.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2022-06-27
 */
@Getter
@Setter
@TableName("test_user")
@ApiModel(value = "TestUser对象", description = "")
public class TestUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private String id;

    @ApiModelProperty("账号名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("手机号码")
    @TableField("telephone")
    private Long telephone;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;


}
