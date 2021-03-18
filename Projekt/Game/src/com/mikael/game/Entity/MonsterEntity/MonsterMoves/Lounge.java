package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.States.PlayState;
import com.mikael.game.util.Vector2f;

public class Lounge extends MonsterMoveManager {

    private int loungeThresholdRange;
    private boolean loungeActive;
    private int loungeDuration;
    private int loungeCounter;

    private boolean monsterWithinRangeX;
    private boolean monsterWithinRangeY;

    public Lounge(Vector2f monsterEntityPos, int loungeThresholdRange, int cooldown, int loungeDuration) {

        super(monsterEntityPos, cooldown);
        this.loungeThresholdRange = loungeThresholdRange;
        this.loungeDuration = loungeDuration;

        loungeActive = false;
        loungeCounter = 0;
    }

    public boolean LoungeMove() {

        if (!loungeActive) {
            loungeCooldown();
        }

        if ((PlayState.player.pos.x - monsterEntityPos.x <= loungeThresholdRange
                && !(PlayState.player.pos.x - monsterEntityPos.x >= loungeThresholdRange))
                || (PlayState.player.pos.x - monsterEntityPos.x >= -loungeThresholdRange
                        && !(PlayState.player.pos.x - monsterEntityPos.x >= loungeThresholdRange))) {

            monsterWithinRangeX = true;
        } else {
            monsterWithinRangeX = false;
        }

        if ((PlayState.player.pos.y - monsterEntityPos.y <= loungeThresholdRange
                && !(PlayState.player.pos.y - monsterEntityPos.y >= -loungeThresholdRange))
                || (PlayState.player.pos.y - monsterEntityPos.y >= -loungeThresholdRange
                        && !(PlayState.player.pos.y - monsterEntityPos.y >= loungeThresholdRange))) {

            monsterWithinRangeY = true;
        } else {
            monsterWithinRangeY = false;
        }

        if (loungeActive && monsterWithinRangeX && monsterWithinRangeY) {
            loungeCooldown();
            return true;
        }
        return false;
    }

    private void loungeCooldown() {

        if (cooldownCounter.getReset() < cooldownCounter.getCooldown() - 2 && !loungeActive) {
            cooldownCounter.update();
        } else {
            if (loungeDuration != loungeCounter) {
                loungeCounter++;
                loungeActive = true;
            } else {
                loungeCounter = 0;
                cooldownCounter.update();
                loungeActive = false;
            }
        }
    }
}
