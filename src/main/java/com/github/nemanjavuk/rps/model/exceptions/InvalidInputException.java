package com.github.nemanjavuk.rps.model.exceptions;

/**
 * Created by nemanja.
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String msg) {
        super(msg);
    }
}
