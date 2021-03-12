package com.mikael.game.States;

import com.mikael.game.Entity.Player;
import com.mikael.game.Entity.MonsterEntity.MonsterEntity;
import com.mikael.game.Entity.MonsterEntity.Monsters.SkeletonTest;
import com.mikael.game.GamePanel;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.Tiles.TileManager;
import com.mikael.game.util.AABB;
import com.mikael.game.util.Camera;
import com.mikael.game.util.KeyHandler;
import com.mikael.game.util.Vector2f;
import com.mikael.game.GUI.UIManager;

import java.awt.*;

public class PlayState extends GameState {

    public static Player player;
    private MonsterEntity skeleton;
    public static Vector2f map;
    private TileManager tileManager;
    private Camera cam;
    private UIManager ui;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);

        map = new Vector2f();
        System.out.println(map.x + " " + map.y);
        Vector2f.setWorldVar(map.x, map.y);
        player = new Player(new Sprite("com/mikael/game/Entity/linkFormatted.png", 32, 32), new Vector2f(0, 0), 80); // 576
        cam = new Camera(new AABB(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));
        tileManager = new TileManager("com/mikael/game/States/MapSketch1-02-26.xml", cam);
        skeleton = new SkeletonTest(new Sprite("com/mikael/game/Entity/skellyPrototype.png", 32, 32),
                new Vector2f(300, 300), 80); // 576
        ui = new UIManager(GamePanel.width, GamePanel.height);
        cam.target(player);
    }

    public void update() {
        Vector2f.setWorldVar(map.x, map.y);
        player.update();
        // skeleton.update();
        cam.update();
    }

    public void input(KeyHandler key) {
        player.input(key);
    }

    public void render(Graphics2D g) {
        System.out.println("da");
        tileManager.render(g);
        player.render(g);
        skeleton.render(g);
        cam.render(g);
        ui.render(g);
    }
}
