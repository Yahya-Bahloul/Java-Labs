package models.pieces;

import main.GamePanel;
import models.Piece;


public class King extends Piece {

    public King(int col, int row, int color) {
        super(col, row, color);
        this.setImage();
    }

    private void setImage(){
        if(color == GamePanel.WHITE){
            this.setImageFromPath("/pieces/w-king");
        } else {
            this.setImageFromPath("/pieces/b-king");
        }
    }

}
