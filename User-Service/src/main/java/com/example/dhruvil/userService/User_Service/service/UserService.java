package com.example.dhruvil.userService.User_Service.service;

import com.example.dhruvil.userService.User_Service.dto.UserDto;
import com.example.dhruvil.userService.User_Service.entity.UserEntity;
import com.example.dhruvil.userService.User_Service.repository.UserRepository;
import com.example.dhruvil.userService.User_Service.util.PasswordHasher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
//    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<UserDto> createUser(UserDto userDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserEntity userEntity = modelMapper.map(userDto,UserEntity.class);
        log.info("UserEntity: {}", userEntity);
//        byte[] salt = PasswordHasher.generateSalt();
//        userEntity.setPassword(PasswordHasher.hashPassword(userEntity.getPassword().toCharArray(),salt));
        userRepository.save(userEntity);
        return ResponseEntity.ok(userDto);
    }

}
