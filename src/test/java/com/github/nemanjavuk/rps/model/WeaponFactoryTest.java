package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nemanja on 12/13/15.
 */
public class WeaponFactoryTest {

    private WeaponFactory weaponFactory;

    @Before
    public void setUp() {
        weaponFactory = new WeaponFactory();
    }

    @Test
    public void testCreateRockChoiceStringInput() {
        Weapon weapon = weaponFactory.createWeapon("r");

        Assert.assertEquals(RockWeapon.class, weapon.getClass());
        Assert.assertNotEquals(PaperWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreateRockChoiceEnumInput() {
        Weapon weapon = weaponFactory.createWeapon(WeaponType.ROCK);

        Assert.assertEquals(RockWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreatePaperChoiceStringInput() {
        Weapon weapon = weaponFactory.createWeapon("p");

        Assert.assertEquals(PaperWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreatePaperChoiceEnumInput() {
        Weapon weapon = weaponFactory.createWeapon(WeaponType.PAPER);

        Assert.assertEquals(PaperWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreateScissorsChoiceStringInput() {
        Weapon weapon = weaponFactory.createWeapon("s");

        Assert.assertEquals(ScissorsWeapon.class, weapon.getClass());
    }

    @Test
    public void testCreateScissorsChoiceEnumInput() {
        Weapon weapon = weaponFactory.createWeapon(WeaponType.SCISSORS);

        Assert.assertEquals(ScissorsWeapon.class, weapon.getClass());
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateChoiceWithWrongStringInput() {
        Weapon weapon = weaponFactory.createWeapon("abrakadabra");
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateChoiceWithNullStringInput() {
        String input = null;
        Weapon weapon = weaponFactory.createWeapon(input);
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateChoiceWithEmptyStringInput() {
        String input = "";
        Weapon weapon = weaponFactory.createWeapon(input);
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateChoiceWithNullEnumInput() {
        WeaponType option = null;
        Weapon weapon = weaponFactory.createWeapon(option);
    }
}
