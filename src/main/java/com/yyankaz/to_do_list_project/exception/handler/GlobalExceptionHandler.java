package com.yyankaz.to_do_list_project.exception.handler;

import com.yyankaz.to_do_list_project.exception.ErrorResponse;
import com.yyankaz.to_do_list_project.exception.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(NotFoundException ex){
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintValidation(ConstraintViolationException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations()
                .forEach(violation ->
                        errors.put(violation.getPropertyPath().toString(), violation.getMessage())
                );
        return errors;
    }
}
