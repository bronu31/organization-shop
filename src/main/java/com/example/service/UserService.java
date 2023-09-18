package com.example.service;

import com.example.entity.Student;
import com.example.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);
    User getUserByName(String name);
    User getUserByEmail(String email);
    User updateUser(User student);
    void deleteUserById(Long id);

}
