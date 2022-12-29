package com.citycloud.nacostest.order.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class TestOrderVo implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

    private String accountId;

    private List<Map<String, Object>> detail;

    private Date createTime;

}
