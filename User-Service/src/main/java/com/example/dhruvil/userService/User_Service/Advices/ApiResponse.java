package com.example.dhruvil.userService.User_Service.Advices;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private int statusCode;
    private T data;
    private String error;

    public ApiResponse(int statusCode, T data, String error) {
        this.statusCode = statusCode;
        this.data = data;
        this.error = error;
    }

    // Getters and setters
}