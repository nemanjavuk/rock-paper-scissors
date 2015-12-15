package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;

import java.util.Random;

/**
 * Created by nemanja.
 */
public class PlayCommand {

    private Weapon weaponOfChoice;

    protected PlayCommand(WeaponFactory weaponFactory) {
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(WeaponType.values().length);
        weaponOfChoice = weaponFactory.createWeapon(WeaponType.values()[randomNum]);
    }

    protected PlayCommand(String input, WeaponFactory weaponFactory) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("wrong input params");
        }
        try {
            weaponOfChoice = weaponFactory.createWeapon(input);
        } catch (InvalidInputException iie) {
            throw new InvalidInputException(iie.getMessage());
        }
    }

    public Weapon getWeaponOfChoice() {
        return weaponOfChoice;
    }

    @Override
    public String toString() {
        return "PlayCommand{" +
                "weaponOfChoice=" + weaponOfChoice +
                '}';
    }
}
