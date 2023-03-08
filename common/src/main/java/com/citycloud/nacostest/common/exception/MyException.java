package com.citycloud.nacostest.common.exception;

import lombok.Data;

/**
 * @author 孟帅
 * @since 2022/7/4
 */
@Data
public class MyException extends RuntimeException {
    private String code;
    private String message;

    public MyException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public MyException(String message) {
        this.code = ResCode.FAILED.getCode();
        this.message = message;
    }
}
