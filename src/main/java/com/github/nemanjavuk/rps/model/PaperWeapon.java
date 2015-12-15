package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.WeaponComparisonException;

/**
 * Created by nemanja.
 */
public class PaperWeapon extends Weapon {

    public PaperWeapon() {
        super(WeaponType.PAPER);
    }

    @Override
    public BattleOutcome compare(Weapon otherWeapon) {
        if (otherWeapon == null) {
            throw new WeaponComparisonException("can't compare with null weapon");
        }
        switch (otherWeapon.getWeaponType()) {
            case PAPER:
                return BattleOutcome.TIE;
            case ROCK:
                return BattleOutcome.BEATS;
            case SCISSORS:
                return BattleOutcome.LOSES;
            default:
                throw new RuntimeException();
        }
    }


}
