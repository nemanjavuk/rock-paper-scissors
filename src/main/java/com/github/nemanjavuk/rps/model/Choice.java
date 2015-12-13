package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public abstract class Choice {

    protected ChoiceOption choiceOption;

    public abstract Outcome compare(Choice otherChoice);

    public ChoiceOption getChoiceOption() {
        return choiceOption;
    }
}
