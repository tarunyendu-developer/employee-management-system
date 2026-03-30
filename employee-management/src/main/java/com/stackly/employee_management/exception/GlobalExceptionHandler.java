package com.stackly.employee_management.exception;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, String> handleNotFound(ResourceNotFoundException ex) {
        return Map.of("message", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleGeneral(Exception ex) {
        return Map.of("error", ex.getMessage());
    }
}