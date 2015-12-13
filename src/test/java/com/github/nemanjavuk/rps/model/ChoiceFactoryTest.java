package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nemanja on 12/13/15.
 */
public class ChoiceFactoryTest {

    @Test
    public void testCreateRockChoiceStringInput() {
        Choice choice = ChoiceFactory.createChoice("r");

        Assert.assertEquals(RockChoice.class, choice.getClass());
        Assert.assertNotEquals(PaperChoice.class, choice.getClass());
    }

    @Test
    public void testCreateRockChoiceEnumInput() {
        Choice choice = ChoiceFactory.createChoice(ChoiceOption.ROCK);

        Assert.assertEquals(RockChoice.class, choice.getClass());
    }

    @Test
    public void testCreatePaperChoiceStringInput() {
        Choice choice = ChoiceFactory.createChoice("p");

        Assert.assertEquals(PaperChoice.class, choice.getClass());
    }

    @Test
    public void testCreatePaperChoiceEnumInput() {
        Choice choice = ChoiceFactory.createChoice(ChoiceOption.PAPER);

        Assert.assertEquals(PaperChoice.class, choice.getClass());
    }

    @Test
    public void testCreateScissorsChoiceStringInput() {
        Choice choice = ChoiceFactory.createChoice("s");

        Assert.assertEquals(ScissorsChoice.class, choice.getClass());
    }

    @Test
    public void testCreateScissorsChoiceEnumInput() {
        Choice choice = ChoiceFactory.createChoice(ChoiceOption.SCISSORS);

        Assert.assertEquals(ScissorsChoice.class, choice.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithWrongStringInput() {
        Choice choice = ChoiceFactory.createChoice("abrakadabra");
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithNullStringInput() {
        String input = null;
        Choice choice = ChoiceFactory.createChoice(input);
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithEmptyStringInput() {
        String input = "";
        Choice choice = ChoiceFactory.createChoice(input);
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithNullEnumInput() {
        ChoiceOption option = null;
        Choice choice = ChoiceFactory.createChoice(option);
    }
}
