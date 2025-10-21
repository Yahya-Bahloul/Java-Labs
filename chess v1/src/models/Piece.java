package models;

import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Piece {

    public BufferedImage image;
    public Position position;
    public int color;
    public boolean selected;
    protected List<PossibleMovement> possibleMovements;

    public Piece(int col, int row, int color) {
        this.position = new Position(col, row);
        this.color = color;
        possibleMovements = new ArrayList<>();
        this.selected = false;
    }

    public int getX() {
        return this.getCol() * Board.SQUARE_SIZE;
    }

    public int getY() {
            return this.getRow() * Board.SQUARE_SIZE; }

    public int getCol() {
        return this.position.getCol();
    }

    public void setCol(int col) {
        this.position.setCol(col);
    }

    public int getRow() {
        return this.position.getRow();
    }

    public void setRow(int row) {
        this.position.setRow(row);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setImageFromPath(String imagePath){
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath+ ".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        setImage(image);
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, getX(), getY(), Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
        if(selected){
            drawPossibleMovements(g2);
        }
    }

    public boolean matchPos(int x, int y){
        return  getX() <= x && getX()+ Board.SQUARE_SIZE > x && getY() <= y && getY()+ Board.SQUARE_SIZE > y;
    }

    public void calculatePossibleMovements(){
        //this.possibleMovements.add(new PossibleMovement(new Position(4,4)));
    }

    public void drawPossibleMovements(Graphics2D g2){
        for(PossibleMovement pv: possibleMovements){
            pv.draw(g2);
        }
    }

    public void resetPossibleMovements(){
        this.possibleMovements = new ArrayList<>();
    }
}
