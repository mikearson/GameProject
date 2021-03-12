package com.mikael.game.Entity.MonsterEntity.Monsters;

import com.mikael.game.Entity.MonsterEntity.MonsterEntity;
import com.mikael.game.Entity.MonsterEntity.MonsterMoves.Lounge;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.Vector2f;
import java.awt.*;

public class SkeletonTest extends MonsterEntity {

    int animationWait = 0;
    private int loungeThresholdRange = 80;
    private int loungeCooldown = 300;
    private boolean loungeRange = false;

    private Lounge lounge;

    public SkeletonTest(Sprite sprite, Vector2f pos, int size) {
        super(sprite, pos, size);

        acc = 0.2f;
        deacc = 0.3f;
        maxSpeed = 0.6f;
        bounds.setWidth(40);
        bounds.setHeight(-40);
        bounds.setXOffset(20);
        bounds.setYOffset(60);

        lounge = new Lounge();

    }

    private void attack() {
        loungeRange = lounge.LoungeMove(this.pos, loungeThresholdRange, loungeCooldown);

        if (loungeRange) {
            acc = 5f;
            deacc = 1.5f;
            maxSpeed = 8f;
        } else {
            acc = 0.2f;
            deacc = 0.3f;
            maxSpeed = 0.6f;
        }
        // System.out.println(maxSpeed);
    }

    public void update() {
        super.update();
        attack();
    }

    public void render(Graphics2D g) {
        g.drawImage(animation.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }
}
