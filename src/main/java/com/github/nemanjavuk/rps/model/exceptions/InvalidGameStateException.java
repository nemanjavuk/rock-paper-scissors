package com.github.nemanjavuk.rps.model.exceptions;

/**
 * Created by nemanja.
 */
public class InvalidGameStateException extends RuntimeException {

    public InvalidGameStateException() {
        super();
    }

    public InvalidGameStateException(String msg) {
        super(msg);
    }

}
