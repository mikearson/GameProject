package com.mikael.game.Entity;

import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.Vector2f;
import java.awt.*;

public abstract class MonsterEntity extends Entity {

    public MonsterEntity(Sprite sprite, Vector2f pos, int size) {
        super(sprite, pos, size);
    }

    public void render(Graphics2D g) {
    }
}
