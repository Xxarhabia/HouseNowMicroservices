package com.example.user.services;

import com.example.user.entities.UserEntity;
import com.example.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserEntity> findUsers() {
        return userRepository.findAll();
    }
}
