package com.untalsanders.blog.domain.exception;

import java.io.Serial;

public class NoSuchElementFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NoSuchElementFoundException(String message) {
        super(message);
    }
}
