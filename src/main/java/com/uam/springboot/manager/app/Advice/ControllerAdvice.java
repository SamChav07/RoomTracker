package com.uam.springboot.manager.app.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice
{
    private final View error;

    public ControllerAdvice(View error) {
        this.error = error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> GetValidationExpection(MethodArgumentNotValidException ex)
    {
        Map<String, String> ErrorValidation = new HashMap<>();

        ex.getBindingResult().getFieldErrors().
                forEach(error-> {
                    ErrorValidation.put(error.getField(),
                            error.getDefaultMessage());
                });


        return ErrorValidation;
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> GetException(Exception ex)
    {
        Map <String, String> Error = new HashMap<>();

        Error.put("Error", ex.getMessage());

        return Error;
    }

}
