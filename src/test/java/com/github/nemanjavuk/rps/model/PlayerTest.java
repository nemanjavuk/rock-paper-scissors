package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja.
 */
public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test(expected = RuntimeException.class)
    public void testMakeBadChoice() {
        player.makeChoice("zzz");
    }

    @Test(expected = RuntimeException.class)
    public void testMakeBadEmptyChoice() {
        player.makeChoice("");
    }

    @Test(expected = RuntimeException.class)
    public void testMakeBadNullChoice() {
        player.makeChoice(null);
    }

    @Test(expected = RuntimeException.class)
    public void testCompareToNullPlayer() {
        player.compareAgainst(null);
    }

    @Test
    public void testCompareToRealPlayer() {
        player.makeChoice("s");

        Player otherPlayer = new Player();
        otherPlayer.makeChoice("r");

        Assert.assertEquals(Outcome.LOSES, player.compareAgainst(otherPlayer));
    }
}
