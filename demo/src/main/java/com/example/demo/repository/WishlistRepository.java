package com.example.demo.repository;
import com.example.demo.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{
    Optional<List<Wishlist>> findAllByUser_UserId(int userId);
}
