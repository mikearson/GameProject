package com.mikael.game.States;

import com.mikael.game.GamePanel;
import com.mikael.game.util.KeyHandler;
import com.mikael.game.util.Vector2f;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    public static Vector2f map;
    ArrayList<GameState> states;

   public GameStateManager() {
       map = new Vector2f(GamePanel.width, GamePanel.height);
       Vector2f.setWorldVar(map.x, map.y);
       states = new ArrayList<>();

       states.add(new PlayState(this));
   }

   public void update() {
       Vector2f.setWorldVar(map.x, map.y);
       for(int i = 0; i < states.size(); i++) {
           states.get(i).update();
       }
   }

    public void input(KeyHandler key) {
        for (int i = 0; i < states.size(); i++) {
            states.get(i).input(key);

        }
    }

    public void render(Graphics2D g) {
        for(int i = 0; i < states.size(); i++) {
            states.get(i).render(g);
        }
    }

}
