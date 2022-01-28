import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;

public class Maze1 extends Maze {
    private int[][] board;
    private Location[][] locations = new Location[getHeight()][getWidth()];
    private Information[][] info = new Information[getHeight()][getWidth()];
    private int[][] directions = new int[4][2];
    private Color mainColor = Color.black;
    private int numDirections = 4;

    public Maze1() {
        super(7, 7);
        setType(1);
        setGoal(6, 6);
        setStart(0, 0); // breaks after 1,0
    }

    public void init() throws Exception {
        setNumDirections(4);

        Scanner sc = new Scanner(new BufferedReader(new FileReader("src\\Maze1.dat")));
        String[] dim = sc.nextLine().trim().split(" ");
        int height = Integer.parseInt(dim[0]);
        int width = Integer.parseInt(dim[1]);
        setHeight(height); setWidth(width);

        board = new int[height][width];

        while(sc.hasNextLine()) {
            for (int i = 0; i < height; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                }
            }
        }




        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                Information in = new Information(i,j,this);
                Location loc = new Location(i,j, in);
                locations[i][j] = loc;
                info[i][j] = in;
                
            }
        }

        // set status
        locations[3][6].setStatus(0);
        locations[6][6].setStatus(2);


    }

    public int[][] getBoard() {
        return board;
    }

    public int getBoardDataAt(int x, int y) {
        return board[x][y];
    }

    public int getValue(int w, int h) {
        return board[w][h];
    }

    public Information getInfoAt(int x, int y) {
        return info[x][y];
    }

    public Location getLocationAt(int x, int y) {
        return locations[x][y];
    }

    public Color getCurrLocColor(int x, int y) {
        return mainColor;
    }

    public int getNumDirections() {
        return numDirections;
    }

    public JButton[][] createButton() {
        int count = 0;
        JButton[][] buttons = new JButton[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); i++){
            for (int j = 0; j < getWidth(); j++) {
                JButton button = new JButton("" + locations[i][j].getInfo().getNumToMove());
                button.setOpaque(true);
                button.setPreferredSize(new Dimension(100,100));
                if (count == 0) {
                    button.setBackground(new Color(255,41,39));
                }
                else if (count % 2 == 0) {
                    button.setBackground(new Color(144,238,144));
                }
                else if (count % 2 == 1) {
                    button.setBackground(new Color(135,206,235));
                }
                button.setForeground(Color.black);
                buttons[i][j] = button;
                button.setEnabled(false);
                count++;

            }
            
        }

        buttons[getStartX()][getStartY()].setEnabled(true);
        buttons[getGoalX()][getGoalY()].setText("GOAL");

        return buttons;
    } 
}
