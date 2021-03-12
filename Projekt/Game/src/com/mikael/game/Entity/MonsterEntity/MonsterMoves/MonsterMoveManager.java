package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.Entity.Player;
import com.mikael.game.States.PlayState;
import com.mikael.game.util.AABB;

public abstract class MonsterMoveManager {

    protected int delay;
    protected int count;

    public static Player player;
    public AABB bounds;

    public MonsterMoveManager() {
        count = 0;
        player = PlayState.player;
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

    public Boolean didItHit() {

        int attackX = (int) (this.getBounds().getPos().x * this.getBounds().getWidth() + this.getBounds().getXOffset())
                / 64;
        int attackY = (int) (this.getBounds().getPos().y * this.getBounds().getHeight() + this.getBounds().getYOffset())
                / 64;

        int playerX = (int) (player.getBounds().getPos().x * player.getBounds().getWidth()
                + player.getBounds().getXOffset()) / 64;
        int playerY = (int) (player.getBounds().getPos().y * player.getBounds().getHeight()
                + player.getBounds().getYOffset()) / 64;

        for (int hitBox = -32; hitBox <= 32; hitBox++) {
            if (attackX == (playerX + hitBox)) {
                return true;
            }
            if (attackY == (playerY + hitBox)) {
                return true;
            }
        }

        return false;
    }
}