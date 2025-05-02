package com.example.dhruvil.userService.User_Service.repository;

import com.example.dhruvil.userService.User_Service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
