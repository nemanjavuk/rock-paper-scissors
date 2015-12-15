package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public abstract class Weapon {

    private WeaponType weaponType;

    public abstract BattleOutcome compare(Weapon otherWeapon);

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Weapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponName() {
        return weaponType.getFullName();
    }

    @Override
    public String toString() {
        return weaponType.getFullName();
    }
}
