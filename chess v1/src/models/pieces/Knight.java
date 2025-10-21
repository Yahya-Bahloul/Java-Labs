package models.pieces;

import main.GamePanel;
import models.Piece;


public class Knight extends Piece {

    public Knight(int col, int row, int color) {
        super(col, row, color);
        this.setImage();
    }

    private void setImage(){
        if(color == GamePanel.WHITE){
            this.setImageFromPath("/pieces/w-knight");
        } else {
            this.setImageFromPath("/pieces/b-knight");
        }
    }

}
