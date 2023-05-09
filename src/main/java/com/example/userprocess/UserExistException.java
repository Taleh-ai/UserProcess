package com.example.userprocess;

public class UserExistException extends  Exception{
    public UserExistException(String s) {
        System.out.println("Username already exists: "+ s);
    }

}
