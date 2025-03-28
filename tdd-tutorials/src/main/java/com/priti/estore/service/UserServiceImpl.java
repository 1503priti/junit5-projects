package com.priti.estore.service;

import com.priti.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {


    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        if (firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("User first name is empty");
        }
        return new User(firstName,lastName,email, UUID.randomUUID().toString());
    }
}
