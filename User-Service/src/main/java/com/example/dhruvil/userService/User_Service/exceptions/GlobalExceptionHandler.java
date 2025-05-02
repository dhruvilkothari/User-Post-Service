package com.example.dhruvil.userService.User_Service.exceptions;

import com.example.dhruvil.userService.User_Service.Advices.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAllExceptions(Exception ex) {
        return ResponseEntity.status(500).body(new ApiResponse<>(500, null, ex.getMessage()));
    }
}
