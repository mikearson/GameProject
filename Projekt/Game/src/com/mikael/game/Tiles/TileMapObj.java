package com.mikael.game.Tiles;

import com.mikael.game.Graphics.Sprite;
import com.mikael.game.Tiles.Blocks.Block;
import com.mikael.game.Tiles.Blocks.ObjBlock;
import com.mikael.game.Tiles.Blocks.WaterBlock;
import com.mikael.game.util.AABB;
import com.mikael.game.util.Vector2f;

import java.awt.*;

public class TileMapObj extends TileMap {

    public static Block[] ObjBlock;

    private int tileWidth;
    private int tileHeight;
    public static int width;
    public static int height;

    public TileMapObj(String data, Sprite sprite, int width, int height, int blockWidth, int blockHeight) {
        ObjBlock = new Block[width * height];

        this.tileWidth = blockWidth;
        this.tileHeight = blockHeight;

        TileMapObj.width = width;
        TileMapObj.height = height;

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            if (temp != 0) {
                if(temp == 41){
                    ObjBlock[i] = new WaterBlock(sprite.getSprite((int) (temp - 1) % 40, (int) (temp -1) / 36),
                            new Vector2f((int) (i % width) * blockWidth,(int) (i / height) * blockHeight),
                            blockWidth, blockHeight);
                } else {
                    ObjBlock[i] = new ObjBlock(
                            sprite.getSprite((int) (temp - 1) % 40, (int) (temp - 1) / 36),
                            new Vector2f((int) (i % width) * blockWidth, (int) (i / height) * blockHeight),
                            blockWidth, blockHeight);
                }
            }

        }
    }


    public void render(Graphics2D g, AABB cam) {
       int x = (int) ((cam.getPos().getCamVar().x) / tileWidth);
        int y = (int) ((cam.getPos().getCamVar().y) / tileHeight);

        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if (ObjBlock[i + (j * height)] != null) {
                    ObjBlock[i + (j * height)].render(g);
                }
            }
        }
    }
}
