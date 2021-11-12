package com.example.microaddresses.modules.services;


import com.example.microaddresses.modules.dtos.AddressInput;
import com.example.microaddresses.modules.entities.Address;
import com.example.microaddresses.modules.exceptions.AddressNotFoundException;
import com.example.microaddresses.modules.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getUserAddresses(Long userId) {
        return addressRepository.findAllByUserId(userId);
    }

    public Address createAddress(AddressInput addressInput) {
        Address address = addressInput.toAddress();
        addressRepository.save(address);
        return address;
    }

    public void deleteAddressById(Long id) throws AddressNotFoundException {
        boolean isExists = addressRepository.existsById(id);
        if (!isExists){
            throw new AddressNotFoundException("address not found");
        }
        addressRepository.deleteById(id);
    }

    public void deleteAddressesByUserId(Long userId){
        List<Address> addresses = addressRepository.findAllByUserId(userId);
        addressRepository.deleteAll(addresses);
    }
}
