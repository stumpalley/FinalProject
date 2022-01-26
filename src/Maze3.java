import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Maze3 extends Maze {

    /*
        BOARD:
            1 = FLOWER
            2 = DIAMOND
            3 = STAR
            4 = PLUS
            0 = NULL
        
        BOARD COLOR:
            1 = YELLOW
            2 = RED
            3 = BLUE
            4 = GREEN
            0 = NULL
    */
    
    private Location[][] locations = new Location[getHeight()][getWidth()];
    private Information[][] info = new Information[getHeight()][getWidth()];
    
    private Color[] mainColor = {null, Color.yellow, Color.red, new Color(135,206,235), new Color(144,238,144)};

    private int[][] board = {{0,0,4,0,0,0},
                            {4,3,2,2,2,3},
                            {3,2,3,4,3,1},
                            {1,4,3,1,2,4},
                            {3,2,4,2,1,1},
                            {0,1,0,0,0,0}};

    private int[][] boardColor = {{0,0,4,0,0,0},
                                {2,2,1,3,2,1},
                                {1,1,2,4,4,4},
                                {2,2,4,3,1,1},
                                {4,2,1,1,4,3},
                                {0,1,0,0,0,0}};

    public Maze3() {
        super(6,6);
        setType(3);
        setGoal(0, 2);
        setStart(5, 1);
    }


    public void init() {
        setNumDirections(5);
        setLoopNumber(6);
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                Information in = new Information(i,j,this);
                Location loc = new Location(i,j, in);
                locations[i][j] = loc;
                info[i][j] = in;
                
            }
        }

        // set status
        locations[5][1].setStatus(0);
        locations[0][2].setStatus(2);
    }

    public JButton[][] createButton() {
        int count = 0;
        JButton[][] buttons = new JButton[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); i++){
            for (int j = 0; j < getWidth(); j++) {
                JButton button = new JButton();
                ImageIcon icon = new ImageIcon("src\\Maze3Icons\\"+board[i][j]+boardColor[i][j]+".png");
                button.setIcon(icon);
                button.setDisabledIcon(icon);
                button.setFont(new Font("Serif", Font.PLAIN, 50));
                button.setOpaque(true);
                button.setPreferredSize(new Dimension(100,100));
                button.setBackground(new Color(255,255,246));
                
                /* if (colors[boardColor[i][j]] == 0){
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
                } */

                buttons[i][j] = button;
                button.setEnabled(false);
                count++;

            }
            
        }

        buttons[getStartX()][getStartY()].setEnabled(true);
        buttons[getStartX()][getStartY()].setBackground(Color.yellow);
        buttons[getGoalX()][getGoalY()].setFont(new Font("Serif", Font.PLAIN, 16));
        buttons[getGoalX()][getGoalY()].setText("GOAL");

        return buttons;
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
        return 4;
    }

    public int getValue(int x, int y) {
        return board[x][y];
    }
}
