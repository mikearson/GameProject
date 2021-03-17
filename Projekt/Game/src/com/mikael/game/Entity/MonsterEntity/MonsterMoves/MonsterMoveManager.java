package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.Entity.Entity;
import com.mikael.game.Entity.Player;
import com.mikael.game.States.PlayState;
import com.mikael.game.util.AABB;
import com.mikael.game.util.CooldownCounter;
import com.mikael.game.util.Direction;
import com.mikael.game.util.Vector2f;

public abstract class MonsterMoveManager {

    protected Vector2f monsterEntityPos;
    protected int loungeThresholdRange;
    protected int cooldown;

    public static Player player;
    public AABB bounds;
    protected CooldownCounter cooldownCounter;

    public MonsterMoveManager(Vector2f monsterEntityPos, int cooldown) {

        this.monsterEntityPos = monsterEntityPos;
        player = PlayState.player;
        cooldownCounter = new CooldownCounter(cooldown);
    }

    public AABB getBounds() {
        return bounds;
    }

    public Boolean didItHit(Entity monsterAttack) {

        // int attackX = (int) (monsterAttack.getBounds().getPos().x *
        // monsterAttack.getBounds().getWidth()
        // + monsterAttack.getBounds().getXOffset()) / 64;
        // int attackY = (int) (monsterAttack.getBounds().getPos().y *
        // monsterAttack.getBounds().getHeight()
        // + monsterAttack.getBounds().getYOffset()) / 64;

        int attackX = (int) (monsterAttack.getBounds().getPos().x);
        int attackY = (int) (monsterAttack.getBounds().getPos().y);

        // int playerX = (int) (player.getBounds().getPos().x *
        // player.getBounds().getWidth()
        // + player.getBounds().getXOffset()) / 64;
        // int playerY = (int) (player.getBounds().getPos().y *
        // player.getBounds().getHeight()
        // + player.getBounds().getYOffset()) / 64;

        int playerX = (int) (player.getBounds().getPos().x);
        int playerY = (int) (player.getBounds().getPos().y);

        // for (int hitBox = -32; hitBox <= 32; hitBox++) {

        if (monsterAttack.direction == Direction.RIGHT || monsterAttack.direction == Direction.LEFT) {
            for (int x = 0; x < player.getBounds().getWidth(); x++) {
                if (attackX + 64 == playerX + x && playerY - attackY < 32 && playerY - attackY > -32) {
                    return true;
                }
            }
        }
        if (monsterAttack.direction == Direction.DOWN || monsterAttack.direction == Direction.UP) {
            for (int y = 0; y < player.getBounds().getHeight(); y++) {
                // if (attackY == playerY + y) {
                // return true;
                // }
            }
        }
        // if (monsterAttack.direction == Direction.RIGHT) {
        // attackX += 32;
        // } else if (monsterAttack.direction == Direction.LEFT) {
        // attackX -= 32;
        // }

        // if (monsterAttack.direction == Direction.DOWN) {
        // attackY += 32;
        // } else if (monsterAttack.direction == Direction.UP) {
        // attackY -= 32;
        // }

        // if (attackX == playerX) {
        // return true;
        // }
        // if (attackY == (playerY + hitBox) && attackX == playerX) {
        // return true;
        // }
        // }

        return false;
    }
}