package com.mikael.game.Entity;

public class HPManager {

    private int HitPoints;

    public HPManager(int startingHitPoints) {
        HitPoints = startingHitPoints;
    }

    public void setHitPoints(int damage) {

        HitPoints += damage;
    }

    public int getHitPoints() {

        return HitPoints;
    }
}
