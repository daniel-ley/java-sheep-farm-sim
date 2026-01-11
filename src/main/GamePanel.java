package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // Screen settings
    final int orginalTitleSize = 16; // 16x16 tile for objects
    final int scale = 3; // scale - to account for modern resolutions

    public final int tileSize = orginalTitleSize * scale; // scaled tile size

    public final int maxScreenColumns = 16; // screen width in tiles
    public final int maxScreenRows = 12; // screen height in tiles

    public final int screenWidth = maxScreenColumns * tileSize; // screen width in px
    public final int screenHeight = maxScreenRows * tileSize; // screen height in px

    int fps = 60;

    Color grassColor = new Color(63, 155, 11);
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(grassColor);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            } else {
                try { // because Java!!
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) { // Override JPanel default method
        super.paintComponent(g); // super = parent ie JPanel - caling JP Method
        Graphics2D g2d = (Graphics2D) g; // convert to Graphics2D
        tileM.draw(g2d);
        player.draw(g2d);
        g2d.dispose();
    }

}
