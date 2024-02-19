package com.example.demo.repository;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUserName(String userName);

}