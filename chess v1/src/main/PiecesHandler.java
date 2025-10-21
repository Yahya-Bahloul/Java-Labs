package main;

import models.Piece;
import models.pieces.*;

import java.awt.*;
import java.util.ArrayList;

public class PiecesHandler {

    private static ArrayList<Piece> pieces = new ArrayList<>();

    private int currentPlayer;

    public PiecesHandler(int currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Piece> getPieces(){
        return pieces;
    }

    public void add(Piece piece){
        pieces.add(piece);
    }

    public void initPieces(){
        pieces.add(new Rook(0,0, GamePanel.WHITE));
        pieces.add(new Knight(1,0, GamePanel.WHITE));
        pieces.add(new Bishop(2,0, GamePanel.WHITE));
        pieces.add(new Queen(3,0, GamePanel.WHITE));
        pieces.add(new King(4,0, GamePanel.WHITE));
        pieces.add(new Bishop(5,0, GamePanel.WHITE));
        pieces.add(new Knight(6,0, GamePanel.WHITE));
        pieces.add(new Rook(7,0, GamePanel.WHITE));
        pieces.add(new Pawn(0,1, GamePanel.WHITE));
        pieces.add(new Pawn(1,1, GamePanel.WHITE));
        pieces.add(new Pawn(2,1, GamePanel.WHITE));
        pieces.add(new Pawn(3,1, GamePanel.WHITE));
        pieces.add(new Pawn(4,1, GamePanel.WHITE));
        pieces.add(new Pawn(5,1, GamePanel.WHITE));
        pieces.add(new Pawn(6,1, GamePanel.WHITE));
        pieces.add(new Pawn(7,1, GamePanel.WHITE));

        pieces.add(new Rook(0,7, GamePanel.BLACK));
        pieces.add(new Knight(1,7, GamePanel.BLACK));
        pieces.add(new Bishop(2,7, GamePanel.BLACK));
        pieces.add(new Queen(3,7, GamePanel.BLACK));
        pieces.add(new King(4,7, GamePanel.BLACK));
        pieces.add(new Bishop(5,7, GamePanel.BLACK));
        pieces.add(new Knight(6,7, GamePanel.BLACK));
        pieces.add(new Rook(7,7, GamePanel.BLACK));
        pieces.add(new Pawn(0,6, GamePanel.BLACK));
        pieces.add(new Pawn(1,6, GamePanel.BLACK));
        pieces.add(new Pawn(2,6, GamePanel.BLACK));
        pieces.add(new Pawn(3,6, GamePanel.BLACK));
        pieces.add(new Pawn(4,6, GamePanel.BLACK));
        pieces.add(new Pawn(5,6, GamePanel.BLACK));
        pieces.add(new Pawn(6,6, GamePanel.BLACK));
        pieces.add(new Pawn(7,6, GamePanel.BLACK));
    }

    public void draw(Graphics2D g2){
        for(Piece p: pieces){
            p.draw(g2);
        }
    }

    public Piece isPiecePresent(int x, int y){
        for(Piece p: pieces){
            if(p.matchPos(x,y)){
                return p;
            }
        }
        return null;
    }

    public void checkForPossibleMovements(int x, int y){
        unselectAll();
        Piece piece = isPiecePresent(x,y);
        if(piece == null){ // || piece.color != currentPlayer
            return;
        }
        piece.calculatePossibleMovements();
        piece.setSelected(true);
    }

    private void unselectAll(){
        for(Piece p: pieces){
            p.setSelected(false);
            p.resetPossibleMovements();
        }
    }

}
