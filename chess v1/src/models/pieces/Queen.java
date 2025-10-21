package models.pieces;

import main.GamePanel;
import models.Piece;


public class Queen extends Piece {

    public Queen(int col, int row, int color) {
        super(col, row, color);
        this.setImage();
    }

    private void setImage(){
        if(color == GamePanel.WHITE){
            this.setImageFromPath("/pieces/w-queen");
        } else {
            this.setImageFromPath("/pieces/b-queen");
        }
    }

}
