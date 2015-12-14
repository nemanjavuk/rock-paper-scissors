package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class ScissorsWeaponTest {

    private ScissorsWeapon scissorsChoice;

    @Before
    public void setUp() {
        scissorsChoice = new ScissorsWeapon();
    }

    @Test
    public void testCompareWithRockChoice() {
        RockWeapon rockChoice = new RockWeapon();
        Assert.assertEquals(BattleOutcome.LOSES, scissorsChoice.compare(rockChoice));
    }

    @Test
    public void testCompareWithPaperChoice() {
        PaperWeapon paperChoice = new PaperWeapon();
        Assert.assertEquals(BattleOutcome.BEATS, scissorsChoice.compare(paperChoice));
    }

    @Test
    public void testCompareWithScissorsChoice() {
        ScissorsWeapon scissorsChoiceAgain = new ScissorsWeapon();
        Assert.assertEquals(BattleOutcome.TIE, scissorsChoice.compare(scissorsChoiceAgain));
    }

    @Test(expected = NullPointerException.class)
    public void testCompareWithNullChoice() {
        scissorsChoice.compare(null);
    }
}
