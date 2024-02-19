package com.example.demo.serviceImpl;
import com.example.demo.entity.Wishlist;
import com.example.demo.exception.WishlistNotFound;
import com.example.demo.repository.WishlistRepository;
import com.example.demo.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {
    @Autowired
    WishlistRepository wishlistRepository;


    @Override
    public List<Wishlist> findAllByUserId(int userId){
        return wishlistRepository.findAllByUser_UserId(userId)
                .orElseThrow(() -> new WishlistNotFound("wishlistItems not found"));

    }

    @Override
    public Wishlist saveItem(Wishlist wishlist){
        Wishlist wishlistItems = new Wishlist();
        wishlistItems.setId(wishlist.getId());
        wishlistItems.setItemName(wishlist.getItemName());
        return wishlistRepository.save(wishlistItems);
    }

    @Override
    public Wishlist findById(int id){
        return wishlistRepository.findById(id)
                .orElseThrow(()-> new WishlistNotFound("wishlistItem not found"));
    }
    @Override
    public void deleteById(int id){
        wishlistRepository.findById(id).orElseThrow(()-> new WishlistNotFound("wishlistItem Not Found"));
        wishlistRepository.deleteById(id);
    }
}
