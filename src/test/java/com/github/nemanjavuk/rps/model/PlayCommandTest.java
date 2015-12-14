package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nemanja on 12/14/15.
 */
public class PlayCommandTest {

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandWithNullInput() {
        PlayCommand playCommand = new PlayCommand(null);
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandWithEmptyInput() {
        PlayCommand playCommand = new PlayCommand("");
    }

    @Test
    public void testWeaponOfChoiceNotNullWhenCreatingPlayCommand() {
        PlayCommand playCommand = new PlayCommand("r");

        Assert.assertNotEquals(null, playCommand.getWeaponOfChoice());
    }
}
