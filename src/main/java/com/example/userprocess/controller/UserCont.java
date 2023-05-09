package com.example.userprocess.controller;

import com.example.userprocess.UserExistException;
import com.example.userprocess.dto.UserDTO;
import com.example.userprocess.entity.UserEntity;
import com.example.userprocess.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserCont {
    private final UserService userService;

    public UserCont(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public UserEntity register(UserDTO dto)  {
        try {
            return    userService.createUser(dto);
        } catch (UserExistException e) {
            throw new RuntimeException(e);
        }
    }
}
