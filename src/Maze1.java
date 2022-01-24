import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Maze1 extends Maze {
    private int[][] board = {{6, 3, 2, 4, 6, 2, 5},
                            {3, 5, 2, 4, 4, 4, 1},
                            {3, 3, 2 ,3 ,3 ,4 ,2},
                            {3 ,4 ,1, 2, 2 ,5 ,3},
                            {4 ,4, 4 ,2 ,3, 2, 4},
                            {2 ,5, 4, 2 ,3 ,2, 5},
                            {3, 5, 2, 1, 4, 4, 0}};
    private Location[][] locations = new Location[getHeight()][getWidth()];
    private Information[][] info = new Information[getHeight()][getWidth()];
    private int[][] directions = new int[4][2];

    public Maze1() {
        super(7, 7);
        setType(1);
        setGoal(6, 6);
        setStart(4, 4); // breaks after 1,0
    }

    public void init() {
        setNumDirections(4);
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

    public int getValue(int w, int h) {
        return board[w][h];
    }

    public Information getInfoAt(int x, int y) {
        return info[x][y];
    }

    public Location getLocationAt(int x, int y) {
        return locations[x][y];
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
        

        return buttons;
    } 
}
