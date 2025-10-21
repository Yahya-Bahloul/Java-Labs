package models.pieces;

import main.GamePanel;
import models.Piece;


public class Bishop extends Piece {

    public Bishop(int col, int row, int color) {
        super(col, row, color);
        this.setImage();
    }

    private void setImage(){
        if(color == GamePanel.WHITE){
            this.setImageFromPath("/pieces/w-bishop");
        } else {
            this.setImageFromPath("/pieces/b-bishop");
        }
    }

}
