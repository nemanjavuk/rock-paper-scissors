package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class PaperWeaponTest {

    private PaperWeapon paperChoice;

    @Before
    public void setUp() {
        paperChoice = new PaperWeapon();
    }

    @Test
    public void testCompareWithRockChoice() {
        RockWeapon rockChoice = new RockWeapon();
        Assert.assertEquals(BattleOutcome.BEATS, paperChoice.compare(rockChoice));
    }

    @Test
    public void testCompareWithPaperChoice() {
        PaperWeapon paperChoiceAgain = new PaperWeapon();
        Assert.assertEquals(BattleOutcome.TIE, paperChoice.compare(paperChoiceAgain));
    }

    @Test
    public void testCompareWithScissorsChoice() {
        ScissorsWeapon scissorsChoice = new ScissorsWeapon();
        Assert.assertEquals(BattleOutcome.LOSES, paperChoice.compare(scissorsChoice));
    }

    @Test(expected = NullPointerException.class)
    public void testCompareWithNullChoice() {
        paperChoice.compare(null);
    }
}
