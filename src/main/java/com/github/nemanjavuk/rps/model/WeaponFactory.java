package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;

/**
 * Created by nemanja.
 */
public class WeaponFactory {

    public Weapon createWeapon(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("input must be a first letter of a choice");
        }
        if (WeaponType.ROCK.getCode().equalsIgnoreCase(input)) {
            return new RockWeapon();
        } else if (WeaponType.PAPER.getCode().equalsIgnoreCase(input)) {
            return new PaperWeapon();
        } else if (WeaponType.SCISSORS.getCode().equalsIgnoreCase(input)) {
            return new ScissorsWeapon();
        } else {
            throw new InvalidInputException("Wrong input, try again");
        }
    }

    public Weapon createWeapon(WeaponType weaponType) {
        if (weaponType == null) {
            throw new InvalidInputException("valid input needed");
        }
        switch (weaponType) {
            case ROCK:
                return new RockWeapon();
            case PAPER:
                return new PaperWeapon();
            case SCISSORS:
                return new ScissorsWeapon();
            default:
                throw new InvalidInputException("I don't know what to create");
        }
    }
}
