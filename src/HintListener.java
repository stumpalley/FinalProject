import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;

/*

    ACTUALLY UNDOS LAST MOVE
*/


public class HintListener implements ActionListener {
    private MazeFrame frame;
    private Maze maze;
    
    private JButton[][] mazeButtons;


    public HintListener(MazeFrame fr) {
        frame = fr;
        maze = frame.getMaze();
        mazeButtons = frame.getMazeButtons();
        
    }

    public void actionPerformed(ActionEvent e) {
        // set start to curr pos
        Location curr = frame.getCurrLocation();
        //maze.setStart(curr.getX(), curr.getY());



        Solver solver = new Solver(maze);
        solver.solve();

        for (int i = 0; i < frame.getMaze().getWidth(); i++) {
            for (int j = 0; j < frame.getMaze().getHeight(); j++) {
                mazeButtons[i][j].setEnabled(false);
            }
        }

         // check sol
         /* if (!solver.checkLast()) {
            JOptionPane.showMessageDialog(frame,

                "NO SOLUTION FOUND! "
                        + "YOU GOT STUCK IN A LOOP! Please restart the puzzle." ,
                "Solution Instructions",
                JOptionPane.PLAIN_MESSAGE);

            return;
        } */

        State s = solver.getFinalState();
        State next = s;
        int plays = frame.getPlays();
        for (int i = 0; i < solver.getSteps() - plays + 1; i++) {
            next = s;
            s=s.getParent();
        }

        mazeButtons[next.getLocation().getX()][next.getLocation().getY()].setEnabled(true);
        int currX = frame.getCurrLocation().getX(); int currY = frame.getCurrLocation().getY();
        mazeButtons[next.getLocation().getX()][next.getLocation().getY()].setBackground(Color.yellow);

    }
}
