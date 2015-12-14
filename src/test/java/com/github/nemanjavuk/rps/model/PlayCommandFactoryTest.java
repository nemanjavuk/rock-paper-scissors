package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nemanja on 12/14/15.
 */
public class PlayCommandFactoryTest {

    @Test
    public void testCreateValidPlayCommandFromInput() {
        PlayCommand playCommand = PlayCommandFactory.createPlayCommandFromInput("r");

        Assert.assertNotEquals(null, playCommand);
    }

    @Test
    public void testCreateRandomPlayCommand() {
        PlayCommand playCommand = PlayCommandFactory.createRandomPlayCommand();

        Assert.assertNotEquals(null, playCommand);
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandFromInvalidInput() {
        PlayCommand playCommand = PlayCommandFactory.createPlayCommandFromInput("zzz");
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandWithNullInput() {
        PlayCommand playCommand = PlayCommandFactory.createPlayCommandFromInput(null);
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandWithEmptyInput() {
        PlayCommand playCommand = PlayCommandFactory.createPlayCommandFromInput("");
    }

}
