package models;

import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PossibleMovement {
    Position position;

    public PossibleMovement(Position position){
        this.position = position;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(getImageFromPath(), position.getX() + Board.SQUARE_SIZE/4 , position.getY() + Board.SQUARE_SIZE/4, Board.SQUARE_SIZE/2, Board.SQUARE_SIZE/2, null);
    }

    public BufferedImage getImageFromPath(){
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/movement/possible-movement" + ".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
