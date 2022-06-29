/*
 *  城云科技 ©1997-2022
 */

package com.citycloud.nacostest.common.exception;

import java.io.Serializable;

/**
 * 接口统一返回格式对象
 *
 * @author 孟帅
 * @since 2022/3/16
 */
public class ResValue implements Serializable {
    /**
     * 响应是否成功标志
     */
    private boolean success;

    /**
     * 响应码，主要在错误的时候区分错误类型
     */
    public int code;

    /**
     * 响应描述，主要在错误的时候获取描述信息
     */
    public String message;

    /**
     * 响应数据，响应成功时需要获取的数据内容
     */
    public Object data;

    ResValue() {
    }

    ResValue(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    ResValue(boolean success, int code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResValue success() {
        return new ResValue(true, ResCode.SUCCESS.getCode(), ResCode.SUCCESS.getMessage(), null);
    }

    public static ResValue successWithMsg(String message) {
        return new ResValue(true, ResCode.SUCCESS.getCode(), message, null);
    }

    public static ResValue successWithData(Object data) {
        return new ResValue(true, ResCode.SUCCESS.getCode(), ResCode.SUCCESS.getMessage(), data);
    }

    public static ResValue successWithMsgAndData(String message, Object data) {
        return new ResValue(true, ResCode.SUCCESS.getCode(), message, data);
    }

    public static ResValue failed() {
        return new ResValue(false, ResCode.FAILED.getCode(), "失败", null);
    }

    public static ResValue failedWithCodeAndMsg(Integer code, String message) {
        return new ResValue(false, code, "失败", message);
    }

    public static ResValue failedWithResCode(ResCode resCode) {
        return new ResValue(false, resCode.getCode(), resCode.getMessage(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
