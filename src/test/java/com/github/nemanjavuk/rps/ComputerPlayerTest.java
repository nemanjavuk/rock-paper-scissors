package com.github.nemanjavuk.rps;

import com.github.nemanjavuk.rps.model.PaperChoice;
import com.github.nemanjavuk.rps.model.RockChoice;
import com.github.nemanjavuk.rps.model.ScissorsChoice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;


/**
 * Created by nemanja on 12/13/15.
 */
public class ComputerPlayerTest {

    @InjectMocks
    private ComputerPlayer computerPlayer;

    @Mock
    private Random random;

    @Before
    public void setUp() {
        computerPlayer = new ComputerPlayer();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldMakeAChoiceWhenRandomNumberIs0() {
        given(random.nextInt(anyInt())).willReturn(0);

        computerPlayer.makeChoice();

        Assert.assertThat(computerPlayer.madeChoice, instanceOf(RockChoice.class));
    }

    @Test
    public void testShouldMakeAChoiceWhenRandomNumberIs1() {
        given(random.nextInt(anyInt())).willReturn(1);

        computerPlayer.makeChoice();

        Assert.assertThat(computerPlayer.madeChoice, instanceOf(PaperChoice.class));
    }

    @Test
    public void testShouldMakeAChoiceWhenRandomNumberIs2() {
        given(random.nextInt(anyInt())).willReturn(2);

        computerPlayer.makeChoice();

        Assert.assertThat(computerPlayer.madeChoice, instanceOf(ScissorsChoice.class));
    }

}
