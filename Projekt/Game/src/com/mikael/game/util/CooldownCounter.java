package com.mikael.game.util;

public class CooldownCounter {

    private int cooldown;
    private int count;

    public CooldownCounter(int cooldown) {
        this.cooldown = cooldown;
    }

    public void update() {
        if (cooldown == -1)
            return;
        count++;
        if (count == cooldown)
            count = 0;
    }

    public int getReset() {
        return count;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
