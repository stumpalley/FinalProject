
import java.awt.Color;
import javax.swing.*;

public abstract class Maze {
    private int mazeHeight;
    private int mazeWidth;
    private int numDirections;
    private int type = 0;
    private int[] start = new int[2];
    private int[] goal = new int[2];
    private int loopNumber = 1;

    public Maze(int height, int width) {
        mazeHeight = height;
        mazeWidth = width;
    }

    public abstract int getValue(int x, int y);
    
    public abstract void init() throws Exception;

    public abstract int[][] getBoard();

    public abstract int getBoardDataAt(int x, int y);

    public abstract JButton[][] createButton();

    public abstract Information getInfoAt(int x, int y);
    
    public abstract Location getLocationAt(int x, int y);

    public abstract Color getCurrLocColor(int x, int y);

    public abstract int getNumDirections();

    public int getGoalX() {
        return goal[0];
    }

    public int getGoalY(){
        return goal[1];
    }

    public int getStartX() {
        return start[0];
    }

    public int getStartY() { 
        return start[1];
    }

    public void setStart(int x, int y) {
        start[0] = x;
        start[1] = y;
    }

    public void setGoal(int x, int y) {
        goal[0] = x;
        goal[1] = y;
    }

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

    public int getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(int i) {
        loopNumber = i;
    }

    
}
