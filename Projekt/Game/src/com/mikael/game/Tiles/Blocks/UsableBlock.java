package com.mikael.game.Tiles.Blocks;

import com.mikael.game.util.AABB;
import com.mikael.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UsableBlock extends Block {

    public UsableBlock(BufferedImage img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(AABB p) {
        return true;
    }

    public boolean isInside(AABB p) {
        if(p.getPos().x + p.getXOffset() < pos.x) return false;
        if(p.getPos().y + p.getYOffset() < pos.y) return false;
        if(w + pos.x < p.getWidth() + (p.getPos().x + p.getXOffset())) return false;
        if(h + pos.y < p.getHeight() + (p.getPos().y + p.getYOffset())) return false;
        return true;
    }

    public void render(Graphics2D g) { super.render(g); }
}
