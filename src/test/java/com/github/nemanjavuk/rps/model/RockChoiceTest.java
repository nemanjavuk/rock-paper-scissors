package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class RockChoiceTest {

    RockChoice rockChoice;

    @Before
    public void setUp() {
        rockChoice = new RockChoice();
    }

    @Test
    public void testCompareWithRockChoice() {
        RockChoice rockChoiceAgain = new RockChoice();
        Assert.assertEquals(BattleOutcome.TIE, rockChoice.compare(rockChoiceAgain));
    }

    @Test
    public void testCompareWithPaperChoice() {
        PaperChoice paperChoice = new PaperChoice();
        Assert.assertEquals(BattleOutcome.LOSES, rockChoice.compare(paperChoice));
    }

    @Test
    public void testCompareWithScissorsChoice() {
        ScissorsChoice scissorsChoice = new ScissorsChoice();
        Assert.assertEquals(BattleOutcome.BEATS, rockChoice.compare(scissorsChoice));
    }

    @Test(expected = NullPointerException.class)
    public void testCompareWithNullChoice() {
        rockChoice.compare(null);
    }
}

