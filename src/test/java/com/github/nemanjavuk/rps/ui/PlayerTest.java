package com.github.nemanjavuk.rps.ui;

import com.github.nemanjavuk.rps.model.*;
import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;

/**
 * Created by nemanja.
 */
public class PlayerTest extends BaseTestWithMocks {

    @Mock
    private KeyboardInput dummyInputDevice;

    @Mock
    private PlayCommand dummyPlayCommand;

    @Mock
    private PlayCommandFactory dummyPlayCommandFactory;

    @Mock
    private WeaponFactory dummyWeaponFactory;

    @Mock
    private RockWeapon dummyWeapon;

    private PlayCommandFactory realPlayCommandFactory;
    private WeaponFactory realWeaponFactory;

    @Before
    public void setUp() {
        when(dummyPlayCommandFactory.createPlayCommandFromInput("R")).thenReturn(dummyPlayCommand);
        when(dummyPlayCommand.getWeaponOfChoice()).thenReturn(dummyWeapon);

        realWeaponFactory = new WeaponFactory();
        realPlayCommandFactory = new PlayCommandFactory(realWeaponFactory);
    }

    @Test
    public void testNextMoveOnValidInputFromHumanConsolePlayerMocked() {
        when(dummyInputDevice.next()).thenReturn("R");

        Player humanPlayer = new HumanConsolePlayer(dummyInputDevice, dummyPlayCommandFactory);
        PlayCommand nextMove = humanPlayer.nextMove();
        Assert.assertThat(nextMove.getWeaponOfChoice(), instanceOf(RockWeapon.class));
    }

    @Test(expected = InvalidInputException.class)
    public void testEmptyInputFromKeyboard() {
        when(dummyInputDevice.next()).thenReturn("");

        Player humanPlayer = new HumanConsolePlayer(dummyInputDevice, dummyPlayCommandFactory);
        humanPlayer.nextMove();
    }

    @Test(expected = InvalidInputException.class)
    public void testNullInputFromKeyboard() {
        when(dummyInputDevice.next()).thenReturn(null);

        Player humanPlayer = new HumanConsolePlayer(dummyInputDevice, dummyPlayCommandFactory);
        humanPlayer.nextMove();
    }

    @Test
    public void testNextMoveOnValidUserInput() {
        when(dummyInputDevice.next()).thenReturn("S");

        Player humanPlayer = new HumanConsolePlayer(dummyInputDevice, realPlayCommandFactory);
        PlayCommand nextMove = humanPlayer.nextMove();
        Assert.assertThat(nextMove.getWeaponOfChoice(), instanceOf(ScissorsWeapon.class));
    }

    @Test
    public void testNextMoveOnComputerPlayer() {
        Player computerPlayer = new ComputerPlayer(realPlayCommandFactory);
        PlayCommand nextMove = computerPlayer.nextMove();
        Assert.assertThat(nextMove.getWeaponOfChoice(), instanceOf(Weapon.class));
    }
}