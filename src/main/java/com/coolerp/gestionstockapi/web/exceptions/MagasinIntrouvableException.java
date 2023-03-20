package com.coolerp.gestionstockapi.web.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MagasinIntrouvableException extends RuntimeException {
    public MagasinIntrouvableException(String s) {
        super(s);
    }
}
