package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.util.Vector2f;
import com.mikael.game.States.PlayState;

public abstract class MonsterMoveManager {

    protected static Vector2f playerPos;

    protected int delay;
    protected int count;

    public MonsterMoveManager() {
        playerPos = PlayState.player.pos;
        count = 0;
    }

    public void update() {
        if (delay == -1)
            return;
        count++;
        if (count == delay)
            count = 0;
    }

}