package com.mikael.game.util;

import java.awt.Graphics2D;

import com.mikael.game.Graphics.Sprite;

public class UI {

    Sprite sprite;

    public UI(int w, int h) {

        sprite = new Sprite("com/mikael/game/util/UI_prototype.png", w, h);
    }

    public void render(Graphics2D g, int w, int h) {
        g.drawImage(sprite.getSprite(0, 0), 0, 0, w, h, null);
    }
}
