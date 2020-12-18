package com.example.utility;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect
{
    private static final String POINTCUT = "execution(* com.example.service.*Impl.*(..))";

    @AfterThrowing(pointcut = POINTCUT ,throwing = "exception")
    public void log(Exception exception) { log.error(exception.getMessage(), exception); }
}