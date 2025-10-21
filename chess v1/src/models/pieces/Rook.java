package models.pieces;

import main.GamePanel;
import models.Piece;


public class Rook extends Piece {

    public Rook(int col, int row, int color) {
        super(col, row, color);
        this.setImage();
    }

    private void setImage(){
        if(color == GamePanel.WHITE){
            this.setImageFromPath("/pieces/w-rook");
        } else {
            this.setImageFromPath("/pieces/b-rook");
        }
    }

}
