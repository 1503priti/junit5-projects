package com.priti.estore.service;

import com.priti.estore.model.User;

public interface UserService {
     User createUser(String firstName, String lastName,
                     String email, String password, String repeatPassword);
}
