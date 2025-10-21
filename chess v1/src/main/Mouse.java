package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private boolean clicked;
    private int x,y;
    private PiecesHandler piecesHandler;

    public Mouse(PiecesHandler piecesHandler){
        this.piecesHandler = piecesHandler;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        clicked =true;
        setX(e.getX());
        setY(e.getY());
        piecesHandler.checkForPossibleMovements(x,y);
    }

    @Override
    public void mousePressed(MouseEvent e){
        clicked =true;
    }
}
