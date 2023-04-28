package io.github.sandersgutierrez.avoristech.hotel.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SuchElementAlreadyExistsException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public SuchElementAlreadyExistsException(String message) {
        super(message);
    }
}
