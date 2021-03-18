package com.mikael.game.Entity.MonsterEntity;

import com.mikael.game.Entity.Entity;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.Direction;
import com.mikael.game.util.Vector2f;
import java.awt.*;
import com.mikael.game.States.PlayState;

public abstract class MonsterEntity extends Entity {

    public MonsterEntity(Sprite sprite, Vector2f pos, int size) {
        super(sprite, pos, size);
    }

    public void move() {

        // RIGHT MOVEMENT FOLLOW PLAYER
        if (PlayState.player.pos.x > (this.pos.x + 40)) {

            this.pos.x += acc;
            right = true;

            if (dx > maxSpeed) {
                dx = maxSpeed;
            }

        } else {
            right = false;

            if (dx > 0) {
                dx -= deacc;
                if (dx < 0)
                    dx = 0;
            }
        }

        // LEFT MOVEMENT FOLLOW PLAYER
        if (PlayState.player.pos.x < this.pos.x - 40) {

            this.pos.x -= acc;
            left = true;

            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            left = false;
            if (dx < 0) {
                dx += deacc;
                if (dx > 0)
                    dx = 0;
            }
        }

        // DOWN MOVEMENT FOLLOW PLAYER
        if (PlayState.player.pos.y > this.pos.y + 40) {

            this.pos.y += acc;

            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            down = false;
            if (dy > 0) {
                dy -= deacc;
                if (dy < 0)
                    dy = 0;
            }
        }

        // UP MOVEMENT FOLLOW PLAYER
        if (PlayState.player.pos.y < this.pos.y - 40) {

            this.pos.y -= acc;

            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            } else {
                up = false;
                if (dy < 0) {
                    dy += deacc;
                    if (dy > 0)
                        dy = 0;
                }
            }
        }

    }

    public void update() {
        super.update();
        move();

        pos.x += dx;
        pos.y += dy;

    }

    public void render(Graphics2D g) {
    }
}
