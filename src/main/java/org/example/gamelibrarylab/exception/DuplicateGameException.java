package org.example.gamelibrarylab.exception;

public class DuplicateGameException extends RuntimeException {
    public DuplicateGameException(String message) {
        super(message);
    }
}