package com.mikael.game.util;

import com.mikael.game.Entity.Player;
import com.mikael.game.GamePanel;
import com.mikael.game.States.PlayState;

import java.awt.*;

public class Camera {

    private AABB collisionCam;
    private AABB bounds;
    private Player p;


    private int widthLimit;
    private int heightLimit;


    public Camera(AABB collisionCam) { this.collisionCam = collisionCam;}

    public void setLimit(int widthLimit, int heightLimit) {
        this.widthLimit = widthLimit;
        this.heightLimit = heightLimit;
    }

    public AABB getBounds() {
        return collisionCam;
    }

    public void update() {
        if ((p.getBounds().getPos().getWorldVar().x + p.getDX()) < Vector2f.getWorldVarX(widthLimit - collisionCam.getWidth() / 2 - 64) &&
           (p.getBounds().getPos().getWorldVar().x + p.getDX()) > Vector2f.getWorldVarX(GamePanel.width / 2 )) {

                PlayState.map.x = p.pos.x - (GamePanel.width / 2);

        }


        if ((p.getBounds().getPos().getWorldVar().y + p.getDY()) < Vector2f.getWorldVarY(heightLimit - collisionCam.getHeight() / 2 - 64) &&
           (p.getBounds().getPos().getWorldVar().y + p.getDY()) > Vector2f.getWorldVarY(GamePanel.height / 2 )) {
                PlayState.map.y = p.pos.y - (GamePanel.height / 2);
        }
    }

    public void target(Player p) {
        this.p = p;
    }


    public void render(Graphics2D g) {
    }
}
