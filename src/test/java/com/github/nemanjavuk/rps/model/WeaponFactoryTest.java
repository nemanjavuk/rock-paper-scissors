package com.github.nemanjavuk.rps.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nemanja on 12/13/15.
 */
public class WeaponFactoryTest {

    @Test
    public void testCreateRockChoiceStringInput() {
        Weapon weapon = WeaponFactory.createWeapon("r");

        Assert.assertEquals(RockWeapon.class, weapon.getClass());
        Assert.assertNotEquals(PaperWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreateRockChoiceEnumInput() {
        Weapon weapon = WeaponFactory.createWeapon(WeaponType.ROCK);

        Assert.assertEquals(RockWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreatePaperChoiceStringInput() {
        Weapon weapon = WeaponFactory.createWeapon("p");

        Assert.assertEquals(PaperWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreatePaperChoiceEnumInput() {
        Weapon weapon = WeaponFactory.createWeapon(WeaponType.PAPER);

        Assert.assertEquals(PaperWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreateScissorsChoiceStringInput() {
        Weapon weapon = WeaponFactory.createWeapon("s");

        Assert.assertEquals(ScissorsWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreateScissorsChoiceEnumInput() {
        Weapon weapon = WeaponFactory.createWeapon(WeaponType.SCISSORS);

        Assert.assertEquals(ScissorsWeapon.class, weapon.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithWrongStringInput() {
        Weapon weapon = WeaponFactory.createWeapon("abrakadabra");
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithNullStringInput() {
        String input = null;
        Weapon weapon = WeaponFactory.createWeapon(input);
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithEmptyStringInput() {
        String input = "";
        Weapon weapon = WeaponFactory.createWeapon(input);
    }

    @Test(expected = RuntimeException.class)
    public void testCreateChoiceWithNullEnumInput() {
        WeaponType option = null;
        Weapon weapon = WeaponFactory.createWeapon(option);
    }
}
