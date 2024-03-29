package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String name){

        User user = repository.findByUserName(name);
        if (user != null) return user;
        else throw  new UserNotFoundException("User Not found");
    }


    @Override
    public void saveUser(User userEntity){
        User user = new User();
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        repository.save(user);
    }

}
