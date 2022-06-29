/*
 *  城云科技 ©1997-2022
 */

package com.citycloud.nacostest.common.exception;

/**
 * 通用返回响应码定义（个别任务返回状态值可能有多个，单独定义状态对象）100以内的码为系统全局自定义异常
 *
 * @author 孟帅
 * @since 2022/3/16
 */
public enum ResCode {
    // 成功
    SUCCESS(0, "success"),

    // 失败
    FAILED(1000, "fail"),

    // 失败，参数无效
    INVALID_PARAM(1001, "Invalid parameter"),

    // 权限认证错误
    UNAUTHORIZED_ERROR(401, "Authority authentication error"),

    // 服务器内部错误
    INTERNAL_ERROR(500, "Server internal error"),

    // 服务超时熔断错误码
    FUSE_ERROR(504, "Service call timeout");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 正确或错误信息描述
     */
    private final String message;

    ResCode(int code, String desc) {
        this.code = code;
        this.message = desc;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
