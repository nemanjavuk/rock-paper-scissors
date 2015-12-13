package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class PaperChoiceTest {

    private PaperChoice paperChoice;

    @Before
    public void setUp() {
        paperChoice = new PaperChoice();
    }

    @Test
    public void testCompareWithRockChoice() {
        RockChoice rockChoice = new RockChoice();
        Assert.assertEquals(Outcome.BEATS, paperChoice.compare(rockChoice));
    }

    @Test
    public void testCompareWithPaperChoice() {
        PaperChoice paperChoiceAgain = new PaperChoice();
        Assert.assertEquals(Outcome.TIE, paperChoice.compare(paperChoiceAgain));
    }

    @Test
    public void testCompareWithScissorsChoice() {
        ScissorsChoice scissorsChoice = new ScissorsChoice();
        Assert.assertEquals(Outcome.LOSES, paperChoice.compare(scissorsChoice));
    }

    @Test(expected = NullPointerException.class)
    public void testCompareWithNullChoice() {
        paperChoice.compare(null);
    }
}
