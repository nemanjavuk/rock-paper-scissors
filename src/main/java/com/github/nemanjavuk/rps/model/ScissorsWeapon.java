package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.WeaponComparisonException;

/**
 * Created by nemanja.
 */
public class ScissorsWeapon extends Weapon {

    public ScissorsWeapon() {
        super(WeaponType.SCISSORS);
    }

    @Override
    public BattleOutcome compare(Weapon otherWeapon) {
        if (otherWeapon == null) {
            throw new WeaponComparisonException("can't compare with null weapon");
        }
        switch (otherWeapon.getWeaponType()) {
            case SCISSORS:
                return BattleOutcome.TIE;
            case ROCK:
                return BattleOutcome.LOSES;
            case PAPER:
                return BattleOutcome.BEATS;
            default:
                throw new RuntimeException();
        }
    }
}
