/*
 * 城云科技 ©1997-2022
 */

package com.citycloud.nacostest.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        ResValue resValue = ResValue.internalError();
        resValue.setContent(e.getMessage());
        log.info("the global exception:{}", e.toString());
        return resValue;
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    @ResponseBody
    public ResValue fileNotExceptionHandler(FileNotFoundException e) {
        ResValue resValue = ResValue.internalError();
        resValue.setContent("file not found");
        log.info("the global FileNotFoundException:{}", e.toString());
        return resValue;
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public ResValue ioeExceptionHandler(IOException e) {
        ResValue resValue = ResValue.internalError();
        resValue.setContent("ioe exception");
        log.info("the global IOException:{}", e.toString());
        return resValue;
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResValue nullPointExceptionHandler(NullPointerException e) {
        ResValue resValue = ResValue.internalError();
        resValue.setContent(e.toString());
        log.info("the global NullPointerException:{}", e.toString());
        return resValue;
    }
}
