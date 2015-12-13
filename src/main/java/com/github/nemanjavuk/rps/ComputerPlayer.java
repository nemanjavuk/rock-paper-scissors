package com.github.nemanjavuk.rps;


import com.github.nemanjavuk.rps.model.ChoiceFactory;
import com.github.nemanjavuk.rps.model.ChoiceOption;

import java.util.Random;

/**
 * Created by nemanja.
 */
public class ComputerPlayer extends Player {

    private Random randomGenerator;

    public ComputerPlayer() {
        randomGenerator = new Random();
    }

    public void makeChoice() {
        int randomNum = randomGenerator.nextInt(ChoiceOption.values().length);
        madeChoice = ChoiceFactory.createChoice(ChoiceOption.values()[randomNum]);
    }
}
