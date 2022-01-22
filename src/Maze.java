import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.util.concurrent.Flow;

import javax.swing.*;
import java.awt.*;

public abstract class Maze {
    private int mazeHeight;
    private int mazeWidth;

    public Maze(int height, int width) {
        mazeHeight = height;
        mazeWidth = width;
    }

    public int getHeight() {
        return mazeHeight;
    }

    public int getWidth() {
        return mazeWidth;
    }

    public void setHeight(int h) {
        mazeHeight = h;
    }

    public void setWidth(int w) {
        mazeWidth = w;
    }

    public abstract void init();

    public abstract int[][] getBoard();

    public abstract int getDirection(int h, int w);
}
