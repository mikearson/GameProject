package com.mikael.game.States;

import com.mikael.game.util.KeyHandler;

import java.awt.*;

public abstract class GameState {

    private GameStateManager gameStateManager;

    public GameState(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public abstract void update();
    public abstract void input(KeyHandler key);
    public abstract void render(Graphics2D g);
}
