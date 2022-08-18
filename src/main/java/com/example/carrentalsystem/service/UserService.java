package com.example.carrentalsystem.service;

import com.example.carrentalsystem.model.UserEntity;

public interface UserService{
    public UserEntity findByUsername(String username);
    public UserEntity register(UserEntity u);
}