package com.mikael.game.util;

import com.mikael.game.Entity.Entity;
import com.mikael.game.States.PlayState;

public class EntityCollision {

    public EntityCollision() {
    }

    public Boolean isInside(Entity attack, Entity reciever) {

        int attackEntity_x = (int) (attack.getBounds().getPos().x * attack.getBounds().getWidth()
                + attack.getBounds().getXOffset()) / 64;
        int attackEntity_y = (int) (attack.getBounds().getPos().y * attack.getBounds().getHeight()
                + attack.getBounds().getYOffset()) / 64;

        int recieverEntity_x = (int) (reciever.getBounds().getPos().x * reciever.getBounds().getWidth()
                + reciever.getBounds().getXOffset()) / 64;
        int recieverEntity_y = (int) (reciever.getBounds().getPos().y * reciever.getBounds().getHeight()
                + reciever.getBounds().getYOffset()) / 64;

        for (int hitBox = -32; hitBox <= 32; hitBox++) {
            if (attackEntity_x == (recieverEntity_x + hitBox) || attackEntity_x == (recieverEntity_x - hitBox)) {
                return true;
            }
            if (attackEntity_y == (recieverEntity_y + hitBox) || attackEntity_y == (recieverEntity_y - hitBox)) {
                return true;
            }
        }

        return false;
    }
}
