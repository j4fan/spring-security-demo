package com.j4fan.springsecuritydemo.exception;

import com.j4fan.springsecuritydemo.common.Result;
import com.j4fan.springsecuritydemo.common.ResultGenerator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ValidateException.class)
    public Result validateExceptionHandler(ValidateException exception) {
        String errorMessage = exception.getMessage();
        return ResultGenerator.genFailResult("参数校验失败:" + errorMessage);
    }

    @ExceptionHandler(value = EmailExistsException.class)
    public Result validateEmailExistHandler(EmailExistsException exception) {
        String errorMessage = exception.getMessage();
        return ResultGenerator.genFailResult("邮箱校验失败:" + errorMessage);
    }

    @ExceptionHandler(value = Exception.class)
    public Result errorHandlerOverJson(Exception exception) {
        String errorMessage = exception.getMessage();
        return ResultGenerator.genFailResult(errorMessage);
    }


}
