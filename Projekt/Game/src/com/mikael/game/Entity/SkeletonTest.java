package com.mikael.game.Entity;

import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.Vector2f;
import java.awt.*;

import com.mikael.game.States.PlayState;

public class SkeletonTest extends MonsterEntity {

    int animationWait = 0;

    public SkeletonTest(Sprite sprite, Vector2f pos, int size) {
        super(sprite, pos, size);

        acc = 1.0f;
        deacc = 0.3f;
        maxSpeed = 1.2f;
        bounds.setWidth(40);
        bounds.setHeight(-40);
        bounds.setXOffset(20);
        bounds.setYOffset(60);

    }

    public void render(Graphics2D g) {
        g.drawImage(animation.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }
}
