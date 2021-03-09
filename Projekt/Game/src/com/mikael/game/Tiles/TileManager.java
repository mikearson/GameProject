package com.mikael.game.Tiles;

import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.Camera;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TileManager {

    public Camera camera;
    public static ArrayList<TileMap> tileManager;

    public TileManager(String path, Camera camera) {
        tileManager = new ArrayList<TileMap>();

        addTileMap(path, 64, 64, camera);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight, Camera camera) {
        this.camera = camera;
        // String imagePath;
        String temp;

        int width = 0;
        int height = 0;
        int layers = 0;
        Sprite sprite;

        String[] data = new String[3];

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("layer");
            Node node; // = list.item(0);
            Element eElement;// = (Element) node;

            sprite = new Sprite("com/mikael/game/States/Overworld.png", 16, 16);

            layers = list.getLength();

            for (int i = 0; i <= layers; i++) {
                node = list.item(i);
                eElement = (Element) node;
                if (i <= 0 || i == 2) {
                    width = Integer.parseInt(eElement.getAttribute("width"));
                    height = Integer.parseInt(eElement.getAttribute("height"));
                }
                if (eElement != null) {
                    data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();
                }

                if (i == 0) { // Background
                    tileManager.add(new TileMapBackground(data[i], sprite, width, height, blockWidth, blockHeight));
                } else if (i == 1) { // object
                    tileManager.add(new TileMapObj(data[i], sprite, width, height, blockWidth, blockHeight));
                    // } else if(i == 2) { // usable
                    // tileManager.add(new TileMapUsable(data[i], sprite, width, height, blockWidth,
                    // blockHeight));
                }
                camera.setLimit(width * blockWidth + 64, height * blockHeight);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("CAN NOT READ TILEMAP");
        }

    }

    public void render(Graphics2D g) {
        if (camera == null)
            return;

        for (int i = 0; i < tileManager.size(); i++) {
            tileManager.get(i).render(g, camera.getBounds());
        }
    }
}
