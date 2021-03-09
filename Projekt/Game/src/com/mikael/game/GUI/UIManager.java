package com.mikael.game.GUI;

import java.awt.Graphics2D;

public class UIManager {

    int width;
    int height;
    int hitPoints;

    private HealthBar healthBar;

    public UIManager(int width, int height, int hitPoints) {
        this.width = width;
        this.height = height;
        this.hitPoints = hitPoints;

        healthBar = new HealthBar(width, height, hitPoints);
    }

    public void render(Graphics2D g) {
        healthBar.render(g);
    }
}
