package com.example.demo.controller;
import com.example.demo.entity.Wishlist;
import com.example.demo.requestResponse.SuccessResponse;
import com.example.demo.serviceImpl.WishlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController{
    @Autowired
    WishlistServiceImpl wishlistServiceImpl;

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlistItems(@PathVariable int userId) {
        return wishlistServiceImpl.findAllByUserId(userId);
    }

    @PostMapping("/save/wishlist")
    public ResponseEntity<SuccessResponse> createWishlistItem(@RequestBody Wishlist wishlist) {
        return new ResponseEntity<>(new SuccessResponse("wishlistItem added Successfully",wishlistServiceImpl.saveItem(wishlist)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteWishlistItem(@PathVariable int id) {
        wishlistServiceImpl.deleteById(id);
        return new ResponseEntity<>(new SuccessResponse("wishlistItem deleted successfully ",null),HttpStatus.NO_CONTENT);
    }
}
