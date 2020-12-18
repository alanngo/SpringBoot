# Utilities 
Used for error handling, logging and miscellaneous methods to handle I/O

## Starter code

#### ExceptionControllerAdvice
```java
@RestControllerAdvice
public class ExceptionControllerAdvice
{
    private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

    @Autowired
    private Environment environment;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorInfo> handleGeneralException(Exception exception)
    {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo err = new ErrorInfo(
                BAD_REQUEST.value(),
                environment.getProperty(exception.getMessage()
                ));
        return new ResponseEntity<>(err, BAD_REQUEST);
    }
}
```

#### ErrorInfo
```java
@Data
public class ErrorInfo
{
    private final Integer errorCode;
    private final String message;
}
```

#### LoggingAspect
```java
public class LoggingAspect
{
    private static final String POINTCUT = "execution(* CLASSES TO USE)";
    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut = POINTCUT ,throwing = "exception")
    public void log(Exception exception) { LOGGER.error(exception.getMessage(), exception); }
}
```





