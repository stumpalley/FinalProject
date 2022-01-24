

import javax.swing.*;

public abstract class Maze {
    private int mazeHeight;
    private int mazeWidth;
    private int numDirections;
    private int type = 0;

    public Maze(int height, int width) {
        mazeHeight = height;
        mazeWidth = width;
    }

    public abstract int getValue(int x, int y);
    
    public abstract void init();

    public abstract int[][] getBoard();

    public abstract JButton[][] createButton();

    public abstract Information getInfoAt(int x, int y);
    
    public abstract Location getLocationAt(int x, int y);

    public abstract int[] getGoal();

    public int getHeight() {
        return mazeHeight;
    }

    public int getType() {
        return type;
    }

    public void setType(int i) {
        type = i;
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
    
    public void setNumDirections(int i) {
        numDirections = i;
    }

    public int getNumDirections() {
        return numDirections;
    }
}
