package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

