import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Maze2 extends Maze {
    /*
        1 - RIGHT = U+1F816
        2 - DOWN = U+1F817
        3 - UP = U+1F815
        4 - LEFT = U+1F814

        5 - UP RIGHT = U+2B08
        6 - UP LEFT = U+2B09
        7 - DOWN RIGHT = U+2B0A
        8 - DOWN LEFT = U+2B0B
    */
    private Location[][] locations = new Location[getHeight()][getWidth()];
    private Information[][] info = new Information[getHeight()][getWidth()];
    private String[] arrows = {"","\uD83E\uDC16","\uD83E\uDC17","\uD83E\uDC15","\uD83E\uDC14","\u2B08","\u2B09","\u2B0A","\u2B0B"};
    private int[] colors = {0,1,2};
    private Color[] mainColor = {Color.red, Color.blue};
    private int numDirections;
    private int[][] board = {{1,7,2,8,2,8,2,2},
                            {1,2,7,1,7,2,4,8},
                            {3,4,8,7,5,8,4,4},
                            {7,7,8,7,2,6,1,6},
                            {5,4,2,2,1,5,6,6},
                            {2,7,7,7,6,5,1,4},
                            {5,4,7,1,1,1,6,8},
                            {5,1,3,5,5,3,6,0}};
    private int[][] boardColor = {{0,0,1,1,0,0,0,0},
                                    {1,0,1,0,1,1,1,0},
                                    {0,1,1,0,0,1,1,0},
                                    {0,0,1,0,0,1,0,1},
                                    {1,0,0,1,1,1,1,0},
                                    {0,1,0,0,0,0,1,0},
                                    {0,1,1,0,0,1,1,0},
                                    {1,0,1,0,1,1,1,1}};

    public Maze2() {
        super(8,8);
        setType(2);
        setGoal(7, 7);
        setStart(0, 0);
    }

    public void init() {
        setNumDirections(1);
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
        locations[7][7].setStatus(2);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getBoardDataAt(int x, int y) {
        return boardColor[x][y];
    }

    public Information getInfoAt(int x, int y) {
        return info[x][y];
    }

    public Location getLocationAt(int x, int y) {
        return locations[x][y];
    }

    public Color getCurrLocColor(int x, int y) {
        return mainColor[boardColor[x][y]];
    }

    public int getNumDirections() {
        return 7;
    }

    /* public int getNumDirections(int x, int y) {
        findNumOnPath(x, y);
        return numDirections;
    } */

    /* private void findNumOnPath(int x, int y) {
        int[][] directions = new int[1][2];
        int direction = board[x][y];
        int h = x, w = y;
        numDirections = 0;
        switch (direction) {
            case 1: 
                directions[0][0] = 1;
                directions[0][1] = 0;
                break;
            case 2: 
                directions[0][0] = 0;
                directions[0][1] = -1;
                break;
            case 3: 
                directions[0][0] = 0;
                directions[0][1] = 1;
                break;
            case 4: 
                directions[0][0] = -1;
                directions[0][1] = 0;
                break;
            case 5: 
                directions[0][0] = 1;
                directions[0][1] = 1;
                break;
            case 6: 
                directions[0][0] = -1;
                directions[0][1] = 1;
                break;
            case 7: 
                directions[0][0] = 1;
                directions[0][1] = -1;
                break;
            case 8: 
                directions[0][0] = -1;
                directions[0][1] = -1;
                break;
        }

        while(true) {
            if (w>7 || h > 7 || w < 0 || h < 0) {
                break;
            }
            w+=directions[0][1];
            h+=directions[0][0];
            if (boardColor[x][y]!=boardColor[h][w]) {
                numDirections+=1;
            }
        }
    } */

    public JButton[][] createButton() {
        int count = 0;
        JButton[][] buttons = new JButton[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); i++){
            for (int j = 0; j < getWidth(); j++) {
                JButton button = new JButton(arrows[board[i][j]]);
                
                button.setFont(new Font("Serif", Font.PLAIN, 50));
                button.setOpaque(true);
                button.setPreferredSize(new Dimension(100,100));
                button.setBackground(new Color(255,253,208));
                
                if (colors[boardColor[i][j]] == 0){
                    button.setUI(new MetalButtonUI() {
                        protected Color getDisabledTextColor() {
                            return Color.RED;
                        }
                    });
                }

                else if (colors[boardColor[i][j]] == 1){
                    button.setUI(new MetalButtonUI() {
                        protected Color getDisabledTextColor() {
                            return Color.blue;
                        }
                    });
                }

                buttons[i][j] = button;
                button.setEnabled(false);
                count++;

            }
            
        }

        buttons[getStartX()][getStartY()].setEnabled(true);
        buttons[getStartX()][getStartY()].setForeground(Color.red);
        buttons[getStartX()][getStartY()].setBackground(new Color(144,238,144));
        buttons[getGoalX()][getGoalY()].setFont(new Font("Serif", Font.PLAIN, 16));
        buttons[getGoalX()][getGoalY()].setText("GOAL");

        return buttons;
    } 

    public int getValue(int x, int y) {
        return board[x][y];
    }
}
