package com.example.dhruvil.userService.User_Service.controller;

import com.example.dhruvil.userService.User_Service.dto.LoginDto;
import com.example.dhruvil.userService.User_Service.dto.ResponseDto;
import com.example.dhruvil.userService.User_Service.dto.UserDto;
import com.example.dhruvil.userService.User_Service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Slf4j
//@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/public/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody(required = true)UserDto userDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return userService.createUser(userDto);
    }

    @PostMapping("/public/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto userDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return userService.login(userDto);
    }

}
