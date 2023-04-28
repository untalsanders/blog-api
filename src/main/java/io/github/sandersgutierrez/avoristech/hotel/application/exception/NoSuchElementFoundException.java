package io.github.sandersgutierrez.avoristech.hotel.application.exception;

public class NoSuchElementFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public NoSuchElementFoundException(String message) {
        super(message);
    }
}
