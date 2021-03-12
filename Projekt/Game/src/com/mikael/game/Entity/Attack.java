package com.mikael.game.Entity;

import com.mikael.game.util.AABB;

public class Attack {

    protected int delay;
    protected int count;

    public AABB bounds;

    public Attack() {
        count = 0;
    }

    public void update() {
        if (delay == -1)
            return;
        count++;
        if (count == delay)
            count = 0;
    }

    public AABB getBounds() {
        return bounds;
    }
}
