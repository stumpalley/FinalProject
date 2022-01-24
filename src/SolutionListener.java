import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SolutionListener implements ActionListener {

    private Maze maze;
    private JButton[][] mazeButtons;
    private MazeFrame frame;
    
    public SolutionListener(Maze m, MazeFrame fr) {
        maze = m;
        
        frame = fr;
        mazeButtons = frame.getMazeButtons();
    }

    public void actionPerformed(ActionEvent e) {
        Solver solver = new Solver(maze);
        solver.solve();

        // disable all buttons
        for (int i = 0; i < frame.getMaze().getWidth(); i++) {
            for (int j = 0; j < frame.getMaze().getHeight(); j++) {
                mazeButtons[i][j].setEnabled(false);
            }
        }

        // create the steps
        int step = 1;
        State s = solver.getFinalState();
        while(s.getParent() != null) {
            Location loc = s.getLocation();
            mazeButtons[loc.getX()][loc.getY()].setBackground(Color.white);
            mazeButtons[loc.getX()][loc.getY()].setText("" +step);
            step++;
            s = s.getParent();
        }
        
        frame.repaint();

    }
}
