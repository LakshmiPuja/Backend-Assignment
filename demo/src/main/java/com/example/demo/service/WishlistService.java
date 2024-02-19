package com.example.demo.service;

import com.example.demo.entity.Wishlist;

import java.util.List;

public interface WishlistService {
    List<Wishlist> findAllByUserId(int id);
    Wishlist findById(int id);
    Wishlist saveItem (Wishlist wishlist);
    void deleteById(int id);
}
