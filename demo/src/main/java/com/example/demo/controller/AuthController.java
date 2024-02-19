package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.requestResponse.SuccessResponse;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse> signup(@RequestBody User user){
        userServiceImpl.saveUser(user);
        return new ResponseEntity<>(new SuccessResponse("User Successfully signup",null), HttpStatus.CREATED);
    }
}
