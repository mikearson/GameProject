package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.Entity.Attack;
import com.mikael.game.States.PlayState;
import com.mikael.game.util.Vector2f;

public class Lounge extends Attack {

    public Attack attack;

    public Lounge() {
        super();
    }

    public boolean LoungeMove(Vector2f monsterEntityPos, int loungeThresholdRange, int cooldown) {

        delay = cooldown;
        update();

        if (count < 50) {
            if (PlayState.player.pos.x - monsterEntityPos.x >= loungeThresholdRange
                    && !(PlayState.player.pos.x - monsterEntityPos.x <= -loungeThresholdRange)) {

                return true;

            } else if (PlayState.player.pos.x - monsterEntityPos.x >= -loungeThresholdRange
                    && !(PlayState.player.pos.x - monsterEntityPos.x <= loungeThresholdRange)) {

                return true;
            } else if (PlayState.player.pos.y - monsterEntityPos.y >= loungeThresholdRange
                    && !(PlayState.player.pos.y - monsterEntityPos.y <= -loungeThresholdRange)) {

                return true;

            } else if (PlayState.player.pos.y - monsterEntityPos.y >= -loungeThresholdRange
                    && !(PlayState.player.pos.y - monsterEntityPos.y <= loungeThresholdRange)) {

                return true;
            }
            return false;
        }
        return false;
    }
}
