package com.dev;

import com.tile.ConstantTile;
import com.token.Cardinal;

import java.util.Formatter;

public class BingoBoardPrinter {
    public static void print(ConstantTile<Cardinal> tile, boolean debug) {

        int direction = 1;
        boolean changeDirection = false;
        ConstantTile<Cardinal> up;
        ConstantTile<Cardinal> down;
        ConstantTile<Cardinal> left;
        ConstantTile<Cardinal> rigth;
        String[] board = new String[25];
        StringBuilder msg = new StringBuilder();
        Formatter formatter = new Formatter(msg);

        for(int i = 0; i < 25; i++) {
            msg.setLength(0);
            if(direction == 1)
                formatter.format("Id:%2d Val:%2d Mtch:%5s", (int) i/5 + (i%5)*5, Integer.parseInt(tile.getValueOfProperty("value")), tile.getValueOfProperty("isMatched"));
            else
                formatter.format("Id:%2d Val:%2d Mtch:%5s", (4 - i%5)*5 + (int) i/5, Integer.parseInt(tile.getValueOfProperty("value")), tile.getValueOfProperty("isMatched"));

            up = tile.getAdjacent(Cardinal.UP);
            down = tile.getAdjacent(Cardinal.DOWN);
            left = tile.getAdjacent(Cardinal.LEFT);
            rigth = tile.getAdjacent(Cardinal.RIGHT);

            if(debug) {
                System.out.println("Casilla " +  msg);
                if(up != null)
                    System.out.println(" Arriba: " + up.getValueOfProperty("value"));
                if(left != null)
                    System.out.println(" Izquierda: " + left.getValueOfProperty("value"));
                if(down != null)
                    System.out.println(" Abajo: " + down.getValueOfProperty("value"));
                if(rigth != null)
                    System.out.println(" Derecha: " + rigth.getValueOfProperty("value"));
            }else
                if(direction == 1)
                    board[i/5 + (i%5)*5] = String.valueOf(msg);
                else
                    board[(4 - i%5)*5 + (int) i/5] = String.valueOf(msg);

            if (direction == -1 && left == null || direction == 1 && rigth == null) {
                direction *= -1;
                changeDirection = true;
            }

            if(changeDirection) {
                changeDirection = false;
                tile = down;
            }
            else if (direction == 1)
                tile = rigth;
            else if (direction == -1)
                tile = left;
        }

        if(!debug) {
            System.out.flush();
            System.out.println("Tablero: ");
            for(int i = 0; i < 5; i++)
                System.out.format(" [%s] [%s] [%s] [%s] [%s] %n", board[i], board[5 + i], board[10 + i], board[15 + i], board[20 + i]);
        }
    }
}
