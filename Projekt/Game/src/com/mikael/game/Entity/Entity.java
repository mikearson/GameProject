package com.mikael.game.Entity;

import com.mikael.game.Graphics.Animation;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.AABB;
import com.mikael.game.util.TileCollision;
import com.mikael.game.util.TileCollisionUsable;
import com.mikael.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Entity {
    protected final int RIGHT = 0;
    protected final int LEFT = 1;
    protected final int DEAD = 2;
    protected int currentAnimation;

    protected Animation animation;
    protected Sprite sprite;
    public Vector2f pos;
    protected int size;


    protected boolean right = false;
    protected boolean left = false;
    protected boolean upRight = false;
    protected boolean upLeft = false;
    protected boolean up = false;

    protected boolean roofCollision = false;
    protected boolean dead = false;
    public boolean door = false;
    public boolean vine = false;

    public boolean xCol = false;
    public boolean yCol = false;
    public boolean doorCol = false;
    public boolean vineCol = false;



    public float dx;
    public float dy;

    protected float maxSpeed;
    public float acc;
    public float deacc;
    public float upAcc;
    public float upMaxSpeed;
    public float fallAcc;

    protected AABB hitBounds;
    protected AABB bounds;

    public TileCollision tileCollision;
    public TileCollisionUsable usableTile;

    public Entity(Sprite sprite, Vector2f pos, int size) {
        this.sprite = sprite;
        this.pos = pos;
        this.size = size;

        bounds = new AABB(pos, size, size);
        hitBounds = new AABB(pos, size, size);
        hitBounds.setXOffset(size / 2);

        animation = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);

        tileCollision = new TileCollision(this);
        usableTile = new TileCollisionUsable(this);
    }

    public AABB

    getBounds() {return bounds;}

    public float getDX() {return dx;}
    public float getDY() {return dy;}
    public void setDeath(boolean d) {dead = d;}

    public void roofCollision(Boolean roofCollision) {
        this.roofCollision = roofCollision;
    }
    public void doorCollision(Boolean doorCollision) {
        this.door = doorCollision;
    }
    public void vineCollision(Boolean vineCollision) {
        this.vine = vineCollision;
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public void animate() {

            if (right) {
                if (currentAnimation != RIGHT || animation.getDelay() == -1) {
                    setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
                }
            } else if (left) {
                if (currentAnimation != LEFT || animation.getDelay() == -1) {
                    setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
                }
            } else if (upRight) {  //FEL
                if (currentAnimation != RIGHT || animation.getDelay() == -1) {
                    setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
                }
            } else if (upLeft) { // FEL
                if (currentAnimation != LEFT || animation.getDelay() == -1) {
                    setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
                }
            } else if (up) { //FEL
                if (currentAnimation != RIGHT || animation.getDelay() == -1) {
                    setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
                }
            } else if(dead) {
                if(currentAnimation != DEAD || animation.getDelay()== -1) {
                    setAnimation(DEAD, sprite.getSpriteArray(DEAD), 15);
                }
            } else{
                setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
            }

    }

    public void update() {
        animate();
        animation.update();
    }

    public abstract void render(Graphics2D g);

}
