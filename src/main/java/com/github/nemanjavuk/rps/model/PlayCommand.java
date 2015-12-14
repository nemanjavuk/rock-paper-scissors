package com.github.nemanjavuk.rps.model;

import java.util.Random;

/**
 * Created by nemanja.
 */
public class PlayCommand {

    private Weapon weaponOfChoice;

    //TODO:nemanja:this smells in the sense that it doesn't say that's random is being created
    protected PlayCommand() {
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(WeaponType.values().length);
        weaponOfChoice = WeaponFactory.createWeapon(WeaponType.values()[randomNum]);
    }

    protected PlayCommand(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("wrong input params");
        }
        try {
            weaponOfChoice = WeaponFactory.createWeapon(input);
        } catch (RuntimeException rte) {
            throw new RuntimeException(rte.getMessage());
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
