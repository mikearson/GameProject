package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.util.Vector2f;

public class Lounge extends MonsterMoveManager {

    public Lounge() {
        super();
    }

    public boolean LoungeMove(Vector2f monsterEntityPos, int loungeThresholdRange, int cooldown) {

        delay = cooldown;
        update();

        if (count < 50) {
            if (playerPos.x - monsterEntityPos.x >= loungeThresholdRange
                    && !(playerPos.x - monsterEntityPos.x <= -loungeThresholdRange)) {

                return true;

            } else if (playerPos.x - monsterEntityPos.x >= -loungeThresholdRange
                    && !(playerPos.x - monsterEntityPos.x <= loungeThresholdRange)) {

                return true;
            } else if (playerPos.y - monsterEntityPos.y >= loungeThresholdRange
                    && !(playerPos.y - monsterEntityPos.y <= -loungeThresholdRange)) {

                return true;

            } else if (playerPos.y - monsterEntityPos.y >= -loungeThresholdRange
                    && !(playerPos.y - monsterEntityPos.y <= loungeThresholdRange)) {

                return true;
            }
            return false;
        }
        return false;
    }
}
