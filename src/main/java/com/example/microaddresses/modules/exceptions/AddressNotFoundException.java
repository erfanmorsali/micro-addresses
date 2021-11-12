package com.example.microaddresses.modules.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 2L;

    public AddressNotFoundException(String message) {
        super(message);
    }
}
