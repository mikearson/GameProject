package com.mikael.game;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;

import com.mikael.game.States.GameStateManager;
import com.mikael.game.util.KeyHandler;

public class GamePanel extends JPanel implements Runnable {

    public static int width;
    public static int height;
    public static int oldFrameCount;

    private Thread thread;
    private Boolean running = false;

    private Graphics2D g;
    private BufferedImage image;
    private KeyHandler keyhandler;
    private GameStateManager gameStateManager;

    public GamePanel(int width, int height) {

        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus(); // INPUT
    }

    public void addNotify() {
        // for input keyboard and mouse. check if thread is made and if its not its
        // going to make one
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    private void init() {
        running = true;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();

        keyhandler = new KeyHandler(this);

        gameStateManager = new GameStateManager();
    }

    public void run() {
        init();

        final double GAME_HERTZ = 60.0;
        final double TBU = 1_000_000_000 / GAME_HERTZ; // Time Before Update

        final int MUBR = 5; // Must Update Before Render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60;
        final double TIBR = 1_000_000_000 / TARGET_FPS; // Total Time Before Render

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1_000_000_000);
        oldFrameCount = 0;

        while (running) {
            double now = System.nanoTime();
            int updateCount = 0;
            while (((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update();
                input(keyhandler);
                lastUpdateTime += TBU;
                updateCount++;
            }

            if (now - lastUpdateTime > TBU) {
                lastUpdateTime = now - TBU;
            }

            input(keyhandler);
            update();
            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1_000_000_000);

            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < TIBR && now - lastUpdateTime < TBU) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("ERROR: yielding thread");
                }
                now = System.nanoTime();
            }
        }
    }

    public void update() {
        gameStateManager.update();
    }

    public void input(KeyHandler key) {
        gameStateManager.input(key);
    }

    public void render() {
        if (g != null) {
            g.setColor(Color.blue);
            g.fillRect(0, 0, width, height);
            gameStateManager.render(g);
        }

    }

    public void draw() {
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
    }
}