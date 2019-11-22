package com.mikael.game.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Sprite {

    private BufferedImage SPRITESHEET;
    private BufferedImage[][] spriteArray;
    private int TILE_SIZE = 16;
    public int w;
    public int h;

    private int wSprite;
    private int hSprite;


    public Sprite(String file){
        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }
    public Sprite(String file, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("loading " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }


    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sprite;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[hSprite][wSprite];

        for(int y = 0; y < hSprite; y++) {
            for(int x = 0; x < wSprite; x++) {
                spriteArray[y][x] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSprite(int x, int y) { return SPRITESHEET.getSubimage(x * w, y * h, w, h);}
    public BufferedImage[] getSpriteArray(int i) { return spriteArray[i]; }



}
