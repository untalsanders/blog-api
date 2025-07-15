package com.untalsanders.blog.domain.exception;

import java.io.Serial;

public class PostNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public PostNotFoundException(String message) {
        super(message);
    }
}
