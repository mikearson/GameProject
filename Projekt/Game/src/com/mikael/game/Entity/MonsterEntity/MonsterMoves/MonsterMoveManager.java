package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.Entity.Entity;
import com.mikael.game.Entity.Player;
import com.mikael.game.States.PlayState;
import com.mikael.game.util.CooldownCounter;
import com.mikael.game.util.Vector2f;

import java.awt.geom.Rectangle2D;

public abstract class MonsterMoveManager {

    protected Vector2f monsterEntityPos;
    protected int loungeThresholdRange;
    protected int cooldown;

    public static Player player;
    protected CooldownCounter cooldownCounter;

    public MonsterMoveManager(Vector2f monsterEntityPos, int cooldown) {

        this.monsterEntityPos = monsterEntityPos;
        player = PlayState.player;
        cooldownCounter = new CooldownCounter(cooldown);
    }

    public Boolean didItHit(Entity attackingMonster) {

        Rectangle2D aM = new Rectangle2D.Float(attackingMonster.pos.x, attackingMonster.pos.y, attackingMonster.size,
                attackingMonster.size), p = new Rectangle2D.Float(player.pos.x, player.pos.y, player.size, player.size);

        return p.intersects(aM);

    }
}