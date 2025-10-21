package models.pieces;

import main.GamePanel;
import models.Piece;
import models.Position;
import models.PossibleMovement;


public class Pawn extends Piece {

    private boolean firstMove;

    public Pawn(int col, int row, int color) {
        super(col, row, color);
        this.setImage();
        this.firstMove = true;
    }

    private void setImage(){
        if(color == GamePanel.WHITE){
            this.setImageFromPath("/pieces/w-pawn");
        } else {
            this.setImageFromPath("/pieces/b-pawn");
        }
    }

    @Override
    public void calculatePossibleMovements() {
        if(firstMove){
            //this.firstMove = false;
            this.possibleMovements.add(new PossibleMovement(new Position(getCol(),getRow()+2)));
        }
        this.possibleMovements.add(new PossibleMovement(new Position(getCol(),getRow()+1)));
    }

}
