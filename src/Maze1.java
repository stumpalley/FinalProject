import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import javax.swing.*;

public class Maze1 extends Maze {
    private int[][] board = {{6, 3, 2, 4, 6, 2, 5},
                            {3, 5, 2, 4, 4, 4, 1},
                            {3, 3, 2 ,3 ,3 ,4 ,2},
                            {3 ,4 ,1, 2, 2 ,5 ,3},
                            {4 ,4, 4 ,2 ,3, 2, 4},
                            {2 ,5, 4, 2 ,3 ,2, 5},
                            {3, 5, 2, 1, 4, 4, 0}};
    private int startX;
    private int startY;
    private int goalX;
    private int goalY;

    public Maze1() {
        super(7, 7);
    }

    public void init() {
        
        /* Scanner reader = new Scanner("Maze.txt");

        // set dimensions
        int h, w;
        h = reader.nextInt(); w = reader.nextInt();
        setHeight(h); setWidth(w);

        // import board

        for (int i = 0; i < getWidth(); i++) {
            for (int  j = 0; j < getHeight(); j++) {
                board[i][j] = reader.nextInt();
            }
        }

        startX = reader.nextInt();
        startY = reader.nextInt();
        goalX = reader.nextInt();
        goalY = reader.nextInt();

        // set up possible squares */


    }

    public int[][] getBoard() {
        return board;
    }

    public int getDirection(int h, int w) {
        return board[h][w];
    }
/* 
    public JButton test(int h, int w) {
        JButton jb = 
    } */
}
