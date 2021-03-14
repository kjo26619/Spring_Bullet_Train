package com.challenge.topcoder.bullettrain.error;

public class EntityEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityEmptyException(String msg) {
        super(msg);
    }
}
