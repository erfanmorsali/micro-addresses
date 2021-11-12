package com.example.microaddresses.modules.consumers;

import com.example.microaddresses.modules.services.AddressService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeletedConsumer {

    private final AddressService addressService;

    @Autowired
    public UserDeletedConsumer(AddressService addressService) {
        this.addressService = addressService;
    }

    @RabbitListener(queues = "user_queue")
    public void consumeMessage(UserDeletedEvent userDeleted) {
        if (userDeleted.getMessage().equals("user deleted")) {
            addressService.deleteAddressesByUserId(userDeleted.getUserId());
        }
    }

}
