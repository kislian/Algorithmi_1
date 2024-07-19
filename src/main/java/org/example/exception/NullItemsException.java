package org.example.exception;

public class NullItemsException extends RuntimeException{

    public NullItemsException() {
    }

    public NullItemsException(String message) {
        super(message);
    }
}
