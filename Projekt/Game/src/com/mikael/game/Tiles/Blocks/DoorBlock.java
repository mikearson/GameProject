package com.mikael.game.Tiles.Blocks;

import com.mikael.game.util.AABB;
import com.mikael.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DoorBlock extends Block {

    public DoorBlock(BufferedImage img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(AABB p) {
        return true;
    }

    public boolean isInside(AABB p) {
        return false;
    }

    public void render(Graphics2D g) { super.render(g); }
}
