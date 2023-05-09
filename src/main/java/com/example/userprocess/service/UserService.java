package com.example.userprocess.service;

import com.example.userprocess.UserExistException;
import com.example.userprocess.dto.UserDTO;
import com.example.userprocess.entity.UserEntity;
import com.example.userprocess.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity createUser(UserDTO dto) throws UserExistException {
        if (userRepo.findByUsername(dto.getUserName()).isPresent()){
            throw new UserExistException("Username already exists: " + dto.getUserName()) ;

        }
        UserEntity user = UserEntity.builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .full_name(dto.getFull_name())
                .build();

        return userRepo.save(user);


    }



}
