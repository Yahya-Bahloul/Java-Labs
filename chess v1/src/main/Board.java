package main;

import java.awt.*;

public class Board {
    static  final int  MAX_ROW = 8;
    static  final int  MAX_COL = 8;
    public static  final int  SQUARE_SIZE = 100;

    public void draw(Graphics2D g2){
        boolean c = true;
        for(int row=0; row < MAX_ROW; row++){
            for(int col=0; col < MAX_COL; col++){
                Color color = c ? new Color(245, 245, 220) : new Color(127, 137, 95);
                c = !c;
                g2.setColor(color);

                g2.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
            c = !c;
        }
    }
}
