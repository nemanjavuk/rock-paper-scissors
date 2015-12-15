package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidGameStateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

/**
 * Created by nemanja on 12/15/15.
 */
public class GameTest extends BaseTest {

    @Mock
    private PlayCommandFactory dummyPlayCommandFactory;

    @Mock
    private WeaponFactory dummyWeaponFactory;

    @Mock
    private PlayCommand dummyPlayer1Command;

    @Mock
    private PlayCommand dummyPlayer2Command;

    @Mock
    private Weapon dummyPlayer1Weapon;

    @Mock
    private Weapon dummyPlayer2Weapon;

    @Before
    public void setUp() {
        when(dummyPlayer1Command.getWeaponOfChoice()).thenReturn(dummyPlayer1Weapon);
        when(dummyPlayer2Command.getWeaponOfChoice()).thenReturn(dummyPlayer2Weapon);
    }

    @Test
    public void testFinishTurnPlayer1Won() {
        when(dummyPlayer1Command.getWeaponOfChoice().compare(dummyPlayer2Command.getWeaponOfChoice())).thenReturn(BattleOutcome.BEATS);

        Game game = new Game();

        TurnOutcome turnOutcome = game.finishTurn(dummyPlayer1Command, dummyPlayer2Command);

        Assert.assertEquals(1, game.getNumOfTurns());
        Assert.assertEquals(1, game.getPlayer1Wins());
        Assert.assertEquals(0, game.getPlayer2Wins());
        Assert.assertEquals(0, game.getTies());
        Assert.assertEquals(false, game.isGameFinished());
        Assert.assertEquals("Player 1", turnOutcome.getWinnerName());
    }

    @Test
    public void testFinishTurnPlayer2Won() {
        when(dummyPlayer1Command.getWeaponOfChoice().compare(dummyPlayer2Command.getWeaponOfChoice())).thenReturn(BattleOutcome.LOSES);

        Game game = new Game();

        TurnOutcome turnOutcome = game.finishTurn(dummyPlayer1Command, dummyPlayer2Command);

        Assert.assertEquals(1, game.getNumOfTurns());
        Assert.assertEquals(0, game.getPlayer1Wins());
        Assert.assertEquals(1, game.getPlayer2Wins());
        Assert.assertEquals(0, game.getTies());
        Assert.assertEquals(false, game.isGameFinished());
        Assert.assertEquals("Player 2", turnOutcome.getWinnerName());
    }

    @Test
    public void testFinishTurnItsATie() {
        when(dummyPlayer1Command.getWeaponOfChoice().compare(dummyPlayer2Command.getWeaponOfChoice())).thenReturn(BattleOutcome.TIE);

        Game game = new Game();

        TurnOutcome turnOutcome = game.finishTurn(dummyPlayer1Command, dummyPlayer2Command);

        Assert.assertEquals(1, game.getNumOfTurns());
        Assert.assertEquals(0, game.getPlayer1Wins());
        Assert.assertEquals(0, game.getPlayer2Wins());
        Assert.assertEquals(1, game.getTies());
        Assert.assertEquals(false, game.isGameFinished());
        Assert.assertEquals("No one", turnOutcome.getWinnerName());
    }

    @Test
    public void testFinishGame() {
        Game game = new Game();
        when(dummyPlayer1Command.getWeaponOfChoice().compare(dummyPlayer2Command.getWeaponOfChoice())).thenReturn(BattleOutcome.LOSES);
        game.finishGame();

        Assert.assertTrue(game.isGameFinished());
    }

    @Test(expected = InvalidGameStateException.class)
    public void testTryToFinishTurnWithNoValidPlayCommands() {
        dummyPlayer1Command = null;

        Game game = new Game();

        game.finishTurn(dummyPlayer1Command, dummyPlayer2Command);
    }

}
