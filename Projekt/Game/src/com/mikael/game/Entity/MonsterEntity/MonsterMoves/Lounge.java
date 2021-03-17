package com.mikael.game.Entity.MonsterEntity.MonsterMoves;

import com.mikael.game.States.PlayState;
import com.mikael.game.util.Vector2f;

public class Lounge extends MonsterMoveManager {

    private int loungeThresholdRange;
    private boolean loungeActive;
    private int loungeDuration;
    private int loungeCounter;

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

        // MÅSTE FÅ IN RANGE

        // måste fixa N / W direction

        if (loungeActive) {

            if (PlayState.player.pos.x - monsterEntityPos.x > loungeThresholdRange
                    && !(PlayState.player.pos.x - monsterEntityPos.x < -loungeThresholdRange)) {
                loungeCooldown();
                System.out.println("hej");

                return true;

            } else if (PlayState.player.pos.x - monsterEntityPos.x >= -loungeThresholdRange
                    && !(PlayState.player.pos.x - monsterEntityPos.x <= loungeThresholdRange)) {
                loungeCooldown();
                return true;
            } else if (PlayState.player.pos.y - monsterEntityPos.y >= loungeThresholdRange
                    && !(PlayState.player.pos.y - monsterEntityPos.y <= -loungeThresholdRange)) {
                loungeCooldown();
                return true;

            } else if (PlayState.player.pos.y - monsterEntityPos.y >= -loungeThresholdRange
                    && !(PlayState.player.pos.y - monsterEntityPos.y <= loungeThresholdRange)) {
                loungeCooldown();
                return true;
            }
            return false;
        }
        return false;
    }

    private void loungeCooldown() {

        if (cooldownCounter.getReset() < cooldownCounter.getCooldown() - 2 && !loungeActive) {
            cooldownCounter.update();
            System.out.println(cooldownCounter.getReset() + " " + cooldownCounter.getCooldown());
        } else {
            if (loungeDuration != loungeCounter) {
                loungeCounter++;
                loungeActive = true;
                System.out.println(loungeCounter);
            } else {
                loungeCounter = 0;
                cooldownCounter.update();
                loungeActive = false;
            }
        }
    }
}
