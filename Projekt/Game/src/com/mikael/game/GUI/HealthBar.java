package com.mikael.game.GUI;

import java.awt.Graphics2D;

import com.mikael.game.Graphics.Sprite;

public class HealthBar {

    private UIRender r;
    private Sprite sprite;

    public HealthBar(int width, int height, int hitPoints) {

        r = new UIRender(width, height);

        try {
            sprite = new Sprite("com/mikael/game/GUI/Assets/HealthBar_Prototype.png");
        } catch (Exception e) {
            System.out.println("Could not load healthbar sprite");
        }

    }

    public void render(Graphics2D g) {
        r.render(g, sprite);
    }
}
