package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class RockWeaponTest {

    RockWeapon rockChoice;

    @Before
    public void setUp() {
        rockChoice = new RockWeapon();
    }

    @Test
    public void testCompareWithRockChoice() {
        RockWeapon rockChoiceAgain = new RockWeapon();
        Assert.assertEquals(BattleOutcome.TIE, rockChoice.compare(rockChoiceAgain));
    }

    @Test
    public void testCompareWithPaperChoice() {
        PaperWeapon paperChoice = new PaperWeapon();
        Assert.assertEquals(BattleOutcome.LOSES, rockChoice.compare(paperChoice));
    }

    @Test
    public void testCompareWithScissorsChoice() {
        ScissorsWeapon scissorsChoice = new ScissorsWeapon();
        Assert.assertEquals(BattleOutcome.BEATS, rockChoice.compare(scissorsChoice));
    }

    @Test(expected = NullPointerException.class)
    public void testCompareWithNullChoice() {
        rockChoice.compare(null);
    }
}

