package com.mikael.game.Entity.MonsterEntity.Monsters;

import java.awt.Graphics2D;

public interface Monster {
    public void attack();

    public void update();

    public void render(Graphics2D g);
}
