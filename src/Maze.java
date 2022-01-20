import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;
import java.awt.*;

public class Maze {
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
}
