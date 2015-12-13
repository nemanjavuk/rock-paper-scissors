package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class ScissorsChoiceTest {

    private ScissorsChoice scissorsChoice;

    @Before
    public void setUp() {
        scissorsChoice = new ScissorsChoice();
    }

    @Test
    public void testCompareWithRockChoice() {
        RockChoice rockChoice = new RockChoice();
        Assert.assertEquals(Outcome.LOSES, scissorsChoice.compare(rockChoice));
    }

    @Test
    public void testCompareWithPaperChoice() {
        PaperChoice paperChoice = new PaperChoice();
        Assert.assertEquals(Outcome.BEATS, scissorsChoice.compare(paperChoice));
    }

    @Test
    public void testCompareWithScissorsChoice() {
        ScissorsChoice scissorsChoiceAgain = new ScissorsChoice();
        Assert.assertEquals(Outcome.TIE, scissorsChoice.compare(scissorsChoiceAgain));
    }

    @Test(expected = NullPointerException.class)
    public void testCompareWithNullChoice() {
        scissorsChoice.compare(null);
    }
}
