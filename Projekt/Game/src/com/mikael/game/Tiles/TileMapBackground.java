package com.mikael.game.Tiles;

import com.mikael.game.Graphics.Sprite;
import com.mikael.game.Tiles.Blocks.BackgroundBlock;
import com.mikael.game.Tiles.Blocks.Block;
import com.mikael.game.Tiles.Blocks.UsableBlock;
import com.mikael.game.util.AABB;
import com.mikael.game.util.Vector2f;

import java.awt.*;

public class TileMapBackground extends TileMap{

    private Block[] blocks;
    private int tileWidth;
    private int tileHeight;
    private int height;
    private int width;

    public TileMapBackground(String data, Sprite sprite, int width, int height, int blockWidth, int blockHeight) {
        blocks = new Block[width * height];

        this.tileWidth = blockWidth;
        this.tileHeight = blockHeight;

        this.height = height;
        this.width = width;

        String[] block = data.split(",");

        for(int i = 0;i < (width * height);i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if(temp != 0) {
                blocks[i] = new BackgroundBlock(sprite.getSprite((int) ((temp - 1) % 7), (int) ((temp - 1)  / 7) ),
                        new Vector2f((int) (i % width) * blockWidth, (int) (i / height) * blockHeight),
                        blockWidth, blockHeight);
            }
        }
    }


    @Override
    public void render(Graphics2D g, AABB cam) {
        int x = (int) ((cam.getPos().getCamVar().x) / tileHeight);
        int y = (int)  ((cam.getPos().getCamVar().y) / tileHeight);

        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if(blocks[i + (j * height)] != null  ) {
                        blocks[i + (j * height)].render(g);
                }
            }
        }
    }
}
