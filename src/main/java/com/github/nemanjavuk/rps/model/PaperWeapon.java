package com.github.nemanjavuk.rps.model;

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
            throw new NullPointerException();
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
