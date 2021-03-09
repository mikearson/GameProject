package com.mikael.game.GUI;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;

import com.mikael.game.Graphics.Sprite;

public class HealthBar extends UIRender {

    // private UIRender r;
    private Sprite sprite;
    private int hitPoints;

    public HealthBar(int width, int height, int hitPoints) {

        super(width, height);
        this.hitPoints = hitPoints;
        sprite = new Sprite("com/mikael/game/GUI/Assets/HealthBar_Prototype.png", width, height);

    }

    public void healthBarFiller(Graphics g, int hitPoints) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(67, 42, 3 * hitPoints, 40);
        // g2d.fillRect(5, y, width, height);
    }

    public void render(Graphics2D g) {
        super.render(g, sprite);
        healthBarFiller(g, hitPoints);
    }
}
