package com.mikael.game;

import javax.swing.JFrame;

public class Window extends JFrame {

    public Window() {
        setTitle("Projekt Spel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIgnoreRepaint(true);
        setContentPane(new GamePanel(1280,720));
        pack(); //condense window
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
