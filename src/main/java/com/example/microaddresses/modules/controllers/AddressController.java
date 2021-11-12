package com.example.microaddresses.modules.controllers;


import com.example.microaddresses.modules.dtos.AddressInput;
import com.example.microaddresses.modules.entities.Address;
import com.example.microaddresses.modules.exceptions.AuthenticationFailedException;
import com.example.microaddresses.modules.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/addresses")
public class AddressController {

    @Value("${api-key}")
    String apiKey;

    private final AddressService addressService;


    public void checkApiKey(HttpServletRequest request) throws Exception {
        String headerApiKey = request.getHeader("X-API-KEY");
        if (headerApiKey == null || !headerApiKey.equals(apiKey)) {
            throw new AuthenticationFailedException("authorization failed");
        }
    }

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Address>> getAllAddresses(HttpServletRequest request) throws Exception {
        checkApiKey(request);
        return new ResponseEntity<>(addressService.getAllAddresses(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Address>> getUserAddresses(@PathVariable(name = "userId") Long userId, HttpServletRequest request) throws Exception {
        checkApiKey(request);
        return new ResponseEntity<>(addressService.getUserAddresses(userId), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody AddressInput addressInput, HttpServletRequest request) throws Exception {
        checkApiKey(request);
        return new ResponseEntity<>(addressService.createAddress(addressInput), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(name = "id") Long id, HttpServletRequest request) throws Exception {
        checkApiKey(request);
        addressService.deleteAddressById(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
