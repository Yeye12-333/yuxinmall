package com.example.mallelectron.exception.handler;



import com.example.mallelectron.exception.CustomException;
import com.example.mallelectron.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public Result exceptionHandler(CustomException customException){
        customException.printStackTrace();
        return Result.error().message(customException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        log.error("异常 => {}", e.getMessage());
        e.printStackTrace();
        return Result.error().message("操作失败," + e.getMessage());
    }

}
