package com.example.microaddresses.modules.dtos;

import com.example.microaddresses.modules.entities.Address;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressInput {

    @NotNull
    private Long userId;

    @NotNull
    private String city;

    @NotNull
    private String country;


    public AddressInput(Long userId, String city, String country) {
        this.city = city;
        this.country = country;
        this.userId = userId;
    }

    public Address toAddress() {
        return new Address(userId, country, city);
    }

}
