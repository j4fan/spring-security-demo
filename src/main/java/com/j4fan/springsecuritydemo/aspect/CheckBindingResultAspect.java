package com.j4fan.springsecuritydemo.aspect;

import com.j4fan.springsecuritydemo.exception.ValidateException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@Aspect
public class CheckBindingResultAspect {

    @Pointcut("@annotation(com.j4fan.springsecuritydemo.annotations.CheckBindingResult)")
    public void checkBindingResultPointCut() {

    }

    @Before("checkBindingResultPointCut()")
    public void checkResult(JoinPoint joinPoint) throws ValidateException {
        Object[] args = joinPoint.getArgs();
        BindingResult result = (BindingResult) args[1];
        StringBuffer stringBuffer = new StringBuffer();
        if (result.hasErrors()) {
            throw new ValidateException(result.getAllErrors().get(0).getDefaultMessage());
        }
    }
}
