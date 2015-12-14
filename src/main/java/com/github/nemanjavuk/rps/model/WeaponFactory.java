package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja on 12/13/15.
 */
public class WeaponFactory {

    public static Weapon createWeapon(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("input must be a first letter of a choice");
        }
        if (WeaponType.ROCK.getCode().equalsIgnoreCase(input)) {
            return new RockWeapon();
        } else if (WeaponType.PAPER.getCode().equalsIgnoreCase(input)) {
            return new PaperWeapon();
        } else if (WeaponType.SCISSORS.getCode().equalsIgnoreCase(input)) {
            return new ScissorsWeapon();
        } else {
            throw new RuntimeException("Wrong input, try again");
        }
    }

    public static Weapon createWeapon(WeaponType weaponType) {
        if (weaponType == null) {
            throw new NullPointerException("valid input needed");
        }
        switch (weaponType) {
            case ROCK:
                return new RockWeapon();
            case PAPER:
                return new PaperWeapon();
            case SCISSORS:
                return new ScissorsWeapon();
            default:
                throw new RuntimeException("I don't know what to create");
        }
    }
}
