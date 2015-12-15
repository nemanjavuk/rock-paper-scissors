package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

/**
 * Created by nemanja.
 */
public class PlayCommandFactoryTest extends BaseTestWithMocks {

    private PlayCommandFactory playCommandFactory;

    @Mock
    private WeaponFactory dummyWeaponFactory;

    @Before
    public void setUp() {
        playCommandFactory = new PlayCommandFactory(dummyWeaponFactory);
    }

    @Test
    public void testCreateValidPlayCommandFromInput() {
        PlayCommand playCommand = playCommandFactory.createPlayCommandFromInput("r");

        Assert.assertNotEquals(null, playCommand);
    }

    @Test
    public void testCreateRandomPlayCommand() {
        PlayCommand playCommand = playCommandFactory.createRandomPlayCommand();

        Assert.assertNotEquals(null, playCommand);
    }

    @Test(expected = InvalidInputException.class)
    public void testCreatePlayCommandFromInvalidInput() {
        when(dummyWeaponFactory.createWeapon("zzz")).thenThrow(new InvalidInputException());

        PlayCommand playCommand = playCommandFactory.createPlayCommandFromInput("zzz");
    }

    @Test(expected = InvalidInputException.class)
    public void testCreatePlayCommandWithNullInput() {
        PlayCommand playCommand = playCommandFactory.createPlayCommandFromInput(null);
    }

    @Test(expected = InvalidInputException.class)
    public void testCreatePlayCommandWithEmptyInput() {
        PlayCommand playCommand = playCommandFactory.createPlayCommandFromInput("");
    }

}
