package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

/**
 * Created by nemanja on 12/14/15.
 */
public class PlayCommandTest extends BaseTestWithMocks {

    @Mock
    private WeaponFactory dummyWeaponFactory;

    @Mock
    private RockWeapon dummyRockWeapon;

    @Before
    public void setUp() {
        when(dummyWeaponFactory.createWeapon("r")).thenReturn(dummyRockWeapon);
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandWithNullInput() {
        PlayCommand playCommand = new PlayCommand(null, dummyWeaponFactory);
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlayCommandWithEmptyInput() {
        PlayCommand playCommand = new PlayCommand("", dummyWeaponFactory);
    }

    @Test
    public void testWeaponOfChoiceNotNullWhenCreatingPlayCommand() {
        PlayCommand playCommand = new PlayCommand("r", dummyWeaponFactory);

        Assert.assertNotEquals(null, playCommand.getWeaponOfChoice());
    }
}
