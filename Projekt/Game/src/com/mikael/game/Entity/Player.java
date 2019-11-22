package com.mikael.game.Entity;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.States.PlayState;
import com.mikael.game.util.KeyHandler;
import com.mikael.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {

    int animationWait = 0;

    public Player(Sprite sprite, Vector2f pos, int size) {

        super(sprite, pos, size);

        acc = 1.3f;
        deacc = 0.3f;
        maxSpeed = 1.5f;
        upAcc = 4f;
        upMaxSpeed = 2f;
        fallAcc = 0.01f;
        bounds.setWidth(40);
        bounds.setHeight(-40);
        bounds.setXOffset(20);
        bounds.setYOffset(60);


    }


    private void move() {

        if(!roofCollision) {
            if (!up && yCol) {
                if (right) {
                    dx += acc;          //accelerate
                    if (dx > maxSpeed) { //if acceleration is higher than chosen maxspeed set dx to maxspeed.
                        dx = maxSpeed;

                    }
                } else {
                    if (dx > 0) {
                        dx -= deacc;
                        if (dx < 0) { //if deaccelaretion goes to less than 0 set dx to 0.
                            dx = 0;
                        }
                    }
                }

                if (left) {
                    dx -= acc;          //-accelerate
                    if (dx < -maxSpeed) { //if acceleration is higher than chosen (-)maxspeed set dx to (-)maxspeed .
                        dx = -maxSpeed;
                    }
                } else {
                    if (dx < 0) {
                        dx += deacc;
                        if (dx > 0) {
                            dx = 0;
                        }
                    }
                }
            } else {
                if (right && dx < maxSpeed / 4) {
                    dx += acc / 4;          //accelerate
                    if (dx > maxSpeed) { //if acceleration is higher than chosen maxspeed set dx to maxspeed.
                        dx = maxSpeed;

                    }
                }

                if (left && dx > -maxSpeed / 4) {
                    dx -= acc / 4;      //-accelerate
                    if (dx < -maxSpeed) { //if acceleration is higher than chosen (-)maxspeed set dx to (-)maxspeed .
                        dx = -maxSpeed;
                    }
                }
            }
            if (!vine && !doorCol) {
                if (up && yCol) {
                    dy = -upMaxSpeed;
                }
            }
        } else {
            if(dy < 0) {
                dy = 0;
            }
            roofCollision = false;
        }
        if(doorCol) {
            if(up) {
                resetPlayer();
                doorCol = false;
            }
        }
        if(vineCol) {
            if(up) {
                dy = -1.5f;
            }
        }

        dy += fallAcc;
    }

    public void update() {
        super.update();
        move();
        if(!dead) {
            if(usableTile.usableVineCollision(dx,dy)) {
                vineCol = true;
            } else {
                vineCol = false;
            }
            if (!tileCollision.collisionTile(dx, 0)) {
                pos.x += dx;
                xCol = false;
            } else {
                xCol = true;
            }
            if (!tileCollision.collisionTile(0, dy)) {
                pos.y += dy;
                yCol = false;
            } else {
                yCol = true;
            }
            if(!usableTile.usableDoorCollision(dx,dy)) {
                doorCol = false;
            } else {
                doorCol = true;
            }

        } else {
            pos.y += dy;
            animationWait++;

            if(animationWait > 70) {
                dead = false;
                resetPlayer();
                animationWait = 0;
            }
        }
    }


    private void resetPlayer() {
        pos.x = 576;
        PlayState.map.x = 0;
        pos.y = 5800;
        PlayState.map.y = 0;
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }
    public void render(Graphics2D g) {
        g.drawImage(animation.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }

    public void input(KeyHandler key) {

        if (key.right.down) {
            right = true;
        } else {
            right = false;
        }
        if (key.left.down) {
            left = true;
        } else {
            left = false;
        }
        if (key.up.down) {
            up = true;
        } else {
            up = false;
        }
    }
}
