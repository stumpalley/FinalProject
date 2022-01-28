import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;
import java.awt.*;

public class UndoListener implements ActionListener {
    private Stack<Location> locations;
    private JButton[][] mazeButtons;
    private MazeFrame frame;

    public UndoListener(MazeFrame fr) {
        locations = fr.getStack();
        mazeButtons = fr.getMazeButtons();
        frame = fr;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < frame.getMaze().getWidth(); i++) {
            for (int j = 0; j < frame.getMaze().getHeight(); j++) {
                mazeButtons[i][j].setEnabled(false);
            }
        }

        if (locations.isEmpty()) {
            JOptionPane.showMessageDialog(frame,

                "No more steps to undo." ,
                "Error",
                JOptionPane.PLAIN_MESSAGE);
            return;
        }

        Location curr = locations.pop();
        if (locations.isEmpty()) {
            JOptionPane.showMessageDialog(frame,

                "No more steps to undo." ,
                "Error",
                JOptionPane.PLAIN_MESSAGE);
            return;
        }
        Location l = locations.pop();

        mazeButtons[l.getX()][l.getY()].setEnabled(true);
        mazeButtons[l.getX()][l.getY()].setBackground(Color.yellow);

        int x = curr.getX(); int y=curr.getY();
        if(frame.getMaze().getType() == 1) {
            if (x % 2 == 0) {
                if (y % 2 == 0) {
                    mazeButtons[x][y].setBackground(new Color(144,238,144));
                }
                else {
                    mazeButtons[x][y].setBackground(new Color(135,206,235));
                }
            }
            else if (x % 2 == 1) {
                if (y % 2 == 1) {
                    mazeButtons[x][y].setBackground(new Color(144,238,144));
                }
                else {
                    mazeButtons[x][y].setBackground(new Color(135,206,235));
                }
            }
        }

        else {
            mazeButtons[curr.getX()][curr.getY()].setBackground(new Color(255,255,246));
        }

        frame.addToStack(l);
        frame.setLocation(l);
    }
}
