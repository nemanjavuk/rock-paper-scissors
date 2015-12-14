package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public enum WeaponType {

    ROCK("r", "Rock"),
    PAPER("p", "Paper"),
    SCISSORS("s", "Scissors");

    private String code;
    private String fullName;

    WeaponType(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }
}
