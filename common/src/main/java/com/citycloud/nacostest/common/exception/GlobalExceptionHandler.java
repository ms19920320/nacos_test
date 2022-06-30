/*
 * 城云科技 ©1997-2022
 */

package com.citycloud.nacostest.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

/**
 * 全局异常处理
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResValue exceptionHandler(Exception e) {
        ResValue resValue = ResValue.failedWithResCode(ResCode.INTERNAL_ERROR);
        log.info("the global exception:{}", e.toString());
        return resValue;
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    @ResponseBody
    public ResValue fileNotExceptionHandler(FileNotFoundException e) {
        ResValue resValue = ResValue.failed();
        log.info("the global FileNotFoundException:{}", e.toString());
        return resValue;
    }

}
