package org.example;

public class CarConfigNotFoundException extends RuntimeException {
    public CarConfigNotFoundException(String message) {
        super(message);
    }
}
