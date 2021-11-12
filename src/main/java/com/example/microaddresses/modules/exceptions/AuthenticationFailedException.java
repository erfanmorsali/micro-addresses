package com.example.microaddresses.modules.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AuthenticationFailedException extends Exception {

    @Serial
    private static final long serialVersionUID = 2L;

    public AuthenticationFailedException(String message) {
        super(message);
    }
}
