package com.mikael.game.Tiles;

import com.mikael.game.Graphics.Sprite;
import com.mikael.game.Tiles.Blocks.Block;
import com.mikael.game.Tiles.Blocks.DoorBlock;
import com.mikael.game.Tiles.Blocks.UsableBlock;
import com.mikael.game.util.AABB;
import com.mikael.game.util.Vector2f;

import java.awt.*;

public class TileMapUsable extends TileMap{

    public static Block[] usableBlock;
    private int tileWidth;
    private int tileHeight;

    public static int height;

    public TileMapUsable(String data, Sprite sprite, int width, int height, int blockWidth, int blockHeight) {
        usableBlock = new Block[width * height];

        this.tileWidth = blockWidth;
        this.tileHeight = blockHeight;

        TileMapUsable.height = height;

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            System.out.println(temp);
            // if(temp != 0) {
            //     if(temp == 12) {
            //         usableBlock[i] = new DoorBlock(sprite.getSprite((int) (temp - 1) % 40, (int) (temp - 1) / 36),
            //                 new Vector2f((int)(i % width) * blockWidth, (int)(i / height) * blockHeight),
            //                 blockWidth, blockHeight);
            //     } else {
            //         usableBlock[i] = new UsableBlock(sprite.getSprite((int) (temp - 1) % 40, (int) (temp - 1) / 36),
            //                 new Vector2f((int) (i % width) * blockWidth, (int) (i / height) * blockHeight),
            //                 blockWidth, blockHeight);
            //     }
            // }
        }
    }

    public void render(Graphics2D g, AABB cam) {
        int x = (int) ((cam.getPos().getCamVar().x) / tileWidth);
        int y = (int) ((cam.getPos().getCamVar().y) / tileHeight);

        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if(usableBlock[i + (j * height)] != null) {
                    usableBlock[i +(j * height)].render(g);
                }
            }
        }
    }
}
