package com.mikael.game.GUI;

import java.awt.Graphics2D;

public class UIManager {

    int width;
    int height;

    private HealthBar healthBar;

    public UIManager(int width, int height) {
        this.width = width;
        this.height = height;

        healthBar = new HealthBar(width, height);
    }

    public void render(Graphics2D g) {
        healthBar.render(g);
    }
}
