package com.github.nemanjavuk.rps.model;

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
            throw new NullPointerException();
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
