package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.requestResponse.SuccessResponse;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/{userName}")
    public ResponseEntity<SuccessResponse> findByUserName(@PathVariable String userName){
        User user = userServiceImpl.findByUserName(userName);
        return new ResponseEntity<>(new SuccessResponse("",user), HttpStatus.OK);
    }
    @PostMapping("/add-user")
    public  ResponseEntity<SuccessResponse> signup(@RequestBody User user){
        userServiceImpl.saveUser(user);
        return new ResponseEntity<>(new SuccessResponse("User Successfully signup",null), HttpStatus.CREATED);
    }

}
