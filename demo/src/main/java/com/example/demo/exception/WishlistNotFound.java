package com.example.demo.exception;

public class WishlistNotFound extends RuntimeException {
    public WishlistNotFound(String message){
         super(message);
    }
}
