package com.mikael.game.util;

import com.mikael.game.Entity.Entity;
import com.mikael.game.Tiles.Blocks.Block;
import com.mikael.game.Tiles.Blocks.DoorBlock;
import com.mikael.game.Tiles.Blocks.UsableBlock;
import com.mikael.game.Tiles.TileMapUsable;

public class TileCollisionUsable {

    Entity e;

    public TileCollisionUsable(Entity e) {
        this.e = e;
    }

    public boolean usableDoorCollision(float ax, float ay) {
        for(int c = 0; c < 4; c++) {
            int xt = (int) ((e.getBounds().getPos().x + ax) + (c % 2) * e.getBounds().getWidth() + e.getBounds().getXOffset()) / 64;
            int yt = (int) ((e.getBounds().getPos().y + ay) + ((int) (c / 2)) * e.getBounds().getHeight() + e.getBounds().getYOffset()) / 64;

            if(TileMapUsable.usableBlock[xt + (yt * TileMapUsable.height)] instanceof Block) {
                Block block = TileMapUsable.usableBlock[xt + (yt * TileMapUsable.height)];
                if(block instanceof DoorBlock) {
                    e.doorCollision(true);
                    return block.update(e.getBounds());

                }
            }
        }
        return false;
    }

    public boolean usableVineCollision(float ax, float ay) {
        for(int c = 0; c < 4; c++) {
            int xt = (int) ((e.getBounds().getPos().x + ax) + (c % 2) * e.getBounds().getWidth() + e.getBounds().getXOffset()) / 64;
            int yt = (int) ((e.getBounds().getPos().y + ay) + ((int) (c / 2)) * e.getBounds().getHeight() + e.getBounds().getYOffset()) / 64;

            if(TileMapUsable.usableBlock[xt + (yt * TileMapUsable.height)] instanceof Block) {
                Block block = TileMapUsable.usableBlock[xt + (yt * TileMapUsable.height)];
                if(block instanceof UsableBlock) {
                    e.vineCollision(true);
                    return block.update(e.getBounds());
                }
            }
        }
        e.vineCollision(false);
        return false;
    }
}
