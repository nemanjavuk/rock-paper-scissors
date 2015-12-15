package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;

/**
 * Created by nemanja.
 */
public class PlayCommandFactory {

    private WeaponFactory weaponFactory;

    public PlayCommandFactory(WeaponFactory weaponFactory) {
        this.weaponFactory = weaponFactory;
    }

    public PlayCommand createPlayCommandFromInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("Wrong input, try again");
        }
        return new PlayCommand(input, weaponFactory);
    }

    public PlayCommand createRandomPlayCommand() {
        return new PlayCommand(weaponFactory);
    }
}
