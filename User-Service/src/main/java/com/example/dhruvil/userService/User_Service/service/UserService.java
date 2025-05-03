package com.example.dhruvil.userService.User_Service.service;

import com.example.dhruvil.userService.User_Service.dto.LoginDto;
import com.example.dhruvil.userService.User_Service.dto.ResponseDto;
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
    private final JwtService jwtService;

    public ResponseEntity<UserDto> createUser(UserDto userDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserEntity userEntity = modelMapper.map(userDto,UserEntity.class);
        log.info("UserEntity: {}", userEntity);
//        byte[] salt = PasswordHasher.generateSalt();
//        userEntity.setPassword(PasswordHasher.hashPassword(userEntity.getPassword().toCharArray(),salt));
        userRepository.save(userEntity);
        return ResponseEntity.ok(userDto);
    }

    public ResponseEntity<ResponseDto> login(LoginDto userDto) {

        UserEntity userEntity = userRepository.findByEmail(userDto.getEmail());
        if(userEntity == null){
            return ResponseEntity.ok(new ResponseDto("","User not found"));
        }
        if(!userEntity.getPassword().equals(userDto.getPassword())){
            return ResponseEntity.ok(new ResponseDto("", "Invalid password"));
        }
        String token = jwtService.generateToken(userEntity.getEmail());
        return ResponseEntity.ok(new ResponseDto(token, null));


    }
}
