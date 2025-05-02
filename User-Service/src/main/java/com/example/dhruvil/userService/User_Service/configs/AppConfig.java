package com.example.dhruvil.userService.User_Service.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()  // Optional: disable CSRF for APIs
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**", "/auth/**").permitAll()  // public routes
//                        .anyRequest().authenticated()                           // secure all other routes
//                )
//                .httpBasic();  // or .formLogin() for web login
//
//        return http.build();
//    }
}
