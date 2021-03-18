package com.mikael.game.util;

public class AABB {

    private Vector2f pos;
    private float xOffset = 0;
    private float yOffset = 0;
    private float w;
    private float h;
    private float r;
    private int size;
    // private Entity e;

    public AABB(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w, h);
    }

    public Vector2f getPos() {
        return pos;
    }

    public float getWidth() {
        return w;
    }

    public float getHeight() {
        return h;
    }

    public float getXOffset() {
        return xOffset;
    }

    public void setXOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getYOffset() {
        return yOffset;
    }

    public void setYOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public void setWidth(int width) {
        w = width;
    }

    public void setHeight(int height) {
        h = height;
    }

    public Vector2f getTopLeft() {
        return pos;
    }

    public Vector2f getTopRightx() {
        return new Vector2f(pos.x + w, pos.y);
    }

    public Vector2f getBottomLeft() {
        return new Vector2f(pos.x, pos.y + h);
    }

    public Vector2f getBottomRight() {
        return new Vector2f(pos.x + w, pos.y + h);
    }

}
