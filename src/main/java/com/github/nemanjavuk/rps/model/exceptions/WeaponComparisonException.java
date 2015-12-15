package com.github.nemanjavuk.rps.model.exceptions;

/**
 * Created by nemanja.
 */
public class WeaponComparisonException extends RuntimeException {

    public WeaponComparisonException() {
        super();
    }

    public WeaponComparisonException(String msg) {
        super(msg);
    }
}
