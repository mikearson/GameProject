package com.mikael.game.Tiles;

import com.mikael.game.util.AABB;

import java.awt.Graphics2D;

public abstract class TileMap {
    public abstract void render(Graphics2D g, AABB cam);
}
