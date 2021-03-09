package com.mikael.game.GUI;

import java.awt.Graphics2D;

import com.mikael.game.Graphics.Sprite;

public class UIRender {

    private int w;
    private int h;

    public UIRender(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void render(Graphics2D g, Sprite sprite) {
        g.drawImage(sprite.getSprite(0, 0), 0, 0, w, h, null);
    }
}
