package com.mikael.game.States;

import com.mikael.game.Entity.Player;
import com.mikael.game.GamePanel;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.Tiles.TileManager;
import com.mikael.game.util.AABB;
import com.mikael.game.util.Camera;
import com.mikael.game.util.KeyHandler;
import com.mikael.game.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState {

    private Player player;
    public static Vector2f map;
    private TileManager tileManager;
    private Camera cam;



    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);

        map = new Vector2f();
        System.out.println(map.x + " " + map.y);
        Vector2f.setWorldVar(map.x, map.y);

        cam = new Camera(new AABB(new Vector2f(0,0), GamePanel.width + 64, GamePanel.height + 64));
        tileManager = new TileManager("com/mikael/game/States/MapSketch1-02-26.xml", cam);
        player = new Player(new Sprite("com/mikael/game/Entity/linkFormatted.png", 32, 32), new Vector2f(0, 0), 80); //576
        cam.target(player);
    }


    public void update() {
       Vector2f.setWorldVar(map.x, map.y);
        player.update();
        cam.update();
    }

    public void input(KeyHandler key) {
        player.input(key);
    }

    public void render(Graphics2D g) {
        tileManager.render(g);
        player.render(g);
        cam.render(g);
    }
}
