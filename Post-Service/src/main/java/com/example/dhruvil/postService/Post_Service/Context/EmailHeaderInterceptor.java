package com.example.dhruvil.postService.Post_Service.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class EmailHeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String email = request.getHeader("X-User-Email");

        if (email != null) {
            System.out.println("Intercepted email: " + email);

            // Optional: store in context for later access
            UserContext.setEmail(email);
        }

        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // Clear the context after the request is processed
        UserContext.clear();
    }
}

