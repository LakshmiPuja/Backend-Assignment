package com.example.demo.service;
import com.example.demo.entity.User;

public interface UserService  {
    User findByUserName(String userName);
    void saveUser(User user);

}

