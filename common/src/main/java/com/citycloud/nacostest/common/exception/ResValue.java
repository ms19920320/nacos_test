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
    // 响应码
    public int code;

    // 描述
    public String desc;

    // 返回内容
    public Object content;

    ResValue(){}

    ResValue(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    ResValue(int code, String desc, Object content) {
        this.code = code;
        this.desc = desc;
        this.content = content;
    }

    public static ResValue defaultSuccess() {
        return new ResValue(ResCode.SUCCESS.getCode(), ResCode.SUCCESS.getDesc(), null);
    }

    public static ResValue defaultFailed() {
        return new ResValue(ResCode.FAILED.getCode(), ResCode.FAILED.getDesc(), null);
    }

    public static ResValue invalidParam() {
        return new ResValue(ResCode.INVALID_PARAM.getCode(), ResCode.INVALID_PARAM.getDesc(), null);
    }

    public static ResValue unauthorizedError() {
        return new ResValue(ResCode.UNAUTHORIZED_ERROR.getCode(), ResCode.UNAUTHORIZED_ERROR.getDesc(), null);
    }

    public static ResValue internalError() {
        return new ResValue(ResCode.INTERNAL_ERROR.getCode(), ResCode.INTERNAL_ERROR.getDesc(), null);
    }

    public static ResValue fuseError() {
        return new ResValue(ResCode.FUSE_ERROR.getCode(), ResCode.FUSE_ERROR.getDesc(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
