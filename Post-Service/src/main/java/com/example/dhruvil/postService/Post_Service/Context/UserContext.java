package com.example.dhruvil.postService.Post_Service.Context;

import org.springframework.stereotype.Component;


public class UserContext {
    private static final ThreadLocal<String> userEmail = new ThreadLocal<>();

    public static void setEmail(String email) {
        userEmail.set(email);
    }

    public static String getEmail() {
        return userEmail.get();
    }

    public static void clear() {
        userEmail.remove();
    }
}
