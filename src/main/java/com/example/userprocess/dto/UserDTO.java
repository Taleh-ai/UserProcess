package com.example.userprocess.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String full_name;
}
