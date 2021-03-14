package com.challenge.topcoder.bullettrain.error;

public class HandlerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HandlerNotFoundException(String msg) {
        super(msg);
    }
}
