package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerimage();

    }

    public void setDefaultValues() {

        xPos = 100;
        yPos = 100;
        moveSpeed = 4;
        direction = "down";

    }

    public void getPlayerimage() {

        try {

            // up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            // up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            // down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            // down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            // left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            // left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            // right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            // right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Collie_right2.png"));            


        } catch(IOException e) {
            e.printStackTrace(); 
        }     

    }

    public void update() {

        if(keyH.upPressed == true ||
            keyH.downPressed == true ||
            keyH.leftPressed == true ||
            keyH.rightPressed == true) {

                if(keyH.upPressed == true) {
                    direction = "up";
                    yPos -= moveSpeed;
                }
                else if(keyH.downPressed == true) {
                    direction = "down";
                    yPos += moveSpeed;
                }
                else if(keyH.leftPressed == true) {
                    direction = "left";
                    xPos -= moveSpeed;
                }
                else if(keyH.rightPressed == true) {
                    direction = "right";
                    xPos += moveSpeed;
                }

                spriteCounter++;
                if(spriteCounter > 12) {
                    if(spriteNum == 1) {
                        spriteNum = 2;
                    }
                    else if(spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }

    }

    public void draw(Graphics2D g2d) {

        // g2d.setColor(Color.white);
        // g2d.fillRect(xPos, yPos, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction) {
        case "up":
            if(spriteNum == 1) {
                image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }    
            break;
        case "down":
            if(spriteNum == 1) {
                image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
            }    
            break;
        case "left":
            if(spriteNum == 1) {
                image = left1;
            }
            if(spriteNum == 2) {
                image = left2;
            }    
            break;
        case "right":
            if(spriteNum == 1) {
                image = right1;
            }
            if(spriteNum == 2) {
                image = right2;
            }    
            break;
        }

        g2d.drawImage(image, xPos, yPos, gp.tileSize, gp.tileSize, null);

    }

}
