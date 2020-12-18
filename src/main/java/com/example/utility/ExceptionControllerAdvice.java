package com.example.utility;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice
{
    @Autowired
    private Environment environment;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorInfo> handleGeneralException(Exception exception)
    {
        log.error(exception.getMessage(), exception);
        ErrorInfo err = new ErrorInfo(
                BAD_REQUEST.value(),
                environment.getProperty(exception.getMessage()
                ));
        return new ResponseEntity<>(err, BAD_REQUEST);
    }
}
