import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
public class PlayListener implements ActionListener{
    private MazeFrame mazeFrame;
    private JButton[][] mazeButtons;
    private int posX, posY;
    private Location loc;
    private ArrayList<TransitionInterface> transitions;
    private int[] coord = new int[2];
    private Location currLocation;

    public PlayListener(MazeFrame m, int x, int y) {
        mazeFrame = m;
        posX = x;
        posY = y;
        coord[0] = posX;
        coord[1] = posY;
        loc = mazeFrame.getMaze().getLocationAt(posX, posY);
        mazeButtons = mazeFrame.getMazeButtons();
    }

    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < mazeFrame.getMaze().getWidth(); i++) {
            for (int j = 0; j < mazeFrame.getMaze().getHeight(); j++) {
                mazeButtons[i][j].setEnabled(false);
            }
        }

        mazeFrame.getStack().push(mazeFrame.getMaze().getLocationAt(posX, posY));
        mazeButtons[mazeFrame.getCurrLocation().getX()][mazeFrame.getCurrLocation().getY()].setBackground(Color.gray); 
        mazeFrame.setLocation(mazeFrame.getMaze().getLocationAt(posX, posY));
        mazeButtons[posX][posY].setBackground(Color.yellow);

        loc.generateTransitions();
        transitions = loc.getTransitions();

        for (TransitionInterface i : transitions) {
            mazeButtons[i.getNextLocation().getX()][i.getNextLocation().getY()].setEnabled(true);
            mazeButtons[i.getNextLocation().getX()][i.getNextLocation().getY()].setForeground(mazeFrame.getMaze().getCurrLocColor(i.getNextLocation().getX(), i.getNextLocation().getY()));
        }
        if(loc.getInfo().getStatus() == 2) {
            mazeFrame.setWin();
            mazeButtons[posX][posY].setEnabled(false);
        }
        mazeFrame.setPlays(1);
        mazeFrame.repaint();
    }
}
