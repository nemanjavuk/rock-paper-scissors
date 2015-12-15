package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.WeaponComparisonException;

/**
 * Created by nemanja.
 */
public class RockWeapon extends Weapon {

    public RockWeapon() {
        super(WeaponType.ROCK);
    }

    @Override
    public BattleOutcome compare(Weapon otherWeapon) {
        if (otherWeapon == null) {
            throw new WeaponComparisonException("can't compare with null weapon");
        }
        switch (otherWeapon.getWeaponType()) {
            case PAPER:
                return BattleOutcome.LOSES;
            case SCISSORS:
                return BattleOutcome.BEATS;
            case ROCK:
                return BattleOutcome.TIE;
            default:
                throw new RuntimeException();
        }
    }

}
