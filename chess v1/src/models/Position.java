package models;

import main.Board;

public class Position {
    int col;
    int row;

    public Position(int col,int row){
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getX() {
        return this.getCol() * Board.SQUARE_SIZE;
    }

    public int getY() {
        return this.getRow() * Board.SQUARE_SIZE; }
}
