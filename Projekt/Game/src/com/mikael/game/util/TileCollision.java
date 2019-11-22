package com.mikael.game.util;

import com.mikael.game.Entity.Entity;
import com.mikael.game.Tiles.Blocks.Block;
import com.mikael.game.Tiles.Blocks.WaterBlock;
import com.mikael.game.Tiles.TileMapObj;

public class TileCollision {

    Entity e;

    public TileCollision(Entity e) {
        this.e = e;
    }

    public boolean collisionTile(float ax, float ay) {
        for(int c = 0; c < 4; c++) { //0-3 all sides of a block
            if(c == 0) { // Top side of a block to not have normal collide movement
                int xt = (int) ((e.getBounds().getPos().x + ax) + (c % 2) * e.getBounds().getWidth() + e.getBounds().getXOffset()) / 64;
                int yt = (int) ((e.getBounds().getPos().y + ay) + ((int) (c / 2)) * e.getBounds().getHeight() + e.getBounds().getYOffset()) / 64;
                if (TileMapObj.ObjBlock[xt + (yt * TileMapObj.height)] instanceof Block) {
                    Block block = TileMapObj.ObjBlock[xt + (yt * TileMapObj.height)];
                    if (block instanceof WaterBlock) {
                        return collisionWater(ax, ay, xt, yt, block);
                    }
                    e.roofCollision(false);
                    return block.update(e.getBounds());
                }
            } else { // All other side of the block, to not have normal collide movement
                int xt = (int) ((e.getBounds().getPos().x + ax) + (c % 2) * e.getBounds().getWidth()+ e.getBounds().getXOffset()) / 64;
                int yt = (int) ((e.getBounds().getPos().y + ay) + ((int)(c / 2)) * e.getBounds().getHeight() + e.getBounds().getYOffset()) / 64;
                if (TileMapObj.ObjBlock[xt + (yt * TileMapObj.height)] instanceof Block) {
                    Block block = TileMapObj.ObjBlock[xt + (yt * TileMapObj.height)];
                    e.roofCollision(true);
                    return block.update(e.getBounds());
                }
            }
        }
        return false;
    }

    private boolean collisionWater(float ax, float ay, int xt, int yt, Block block) {
        int nextXt = (int) ((( (e.getBounds().getPos().x + ax) + e.getBounds().getXOffset()) / 64) + e.getBounds().getWidth() / 64);
        int nextYt = (int) ((( (e.getBounds().getPos().y + ay) + e.getBounds().getYOffset()) / 64) + e.getBounds().getHeight() / 64);

        if(block.isInside(e.getBounds())) {
            e.setDeath(true);
            return false;
        } else if((nextXt == yt + 1) || (nextXt == xt +1) || (nextYt == yt -1) || (nextXt == xt -1)) {
            if(TileMapObj.ObjBlock[nextXt + (nextYt * TileMapObj.height)] instanceof WaterBlock) {
                if(e.getBounds().getPos().x > block.getPos().x) {
                  e.setDeath(true);
                }
                return false;
            }
        }
        return false;
    }
}
