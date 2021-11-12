package com.example.microaddresses.modules.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    public Address(Long userId, String country, String city) {
        this.userId = userId;
        this.country = country;
        this.city = city;
    }

    public Address() {
    }
}
