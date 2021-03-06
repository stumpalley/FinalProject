import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

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
        // set start to curr pos
        Location curr = frame.getCurrLocation();
        //maze.setStart(curr.getX(), curr.getY());



        Solver solver = new Solver(maze);
        solver.solve();

        // disable all buttons
        for (int i = 0; i < frame.getMaze().getWidth(); i++) {
            for (int j = 0; j < frame.getMaze().getHeight(); j++) {
                mazeButtons[i][j].setEnabled(false);
            }
        }

        // check sol
        if (!solver.checkLast()) {
            JOptionPane.showMessageDialog(frame,

                "NO SOLUTION FOUND! "
                        + "YOU GOT STUCK IN A LOOP! Please restart the puzzle." ,
                "Solution Instructions",
                JOptionPane.PLAIN_MESSAGE);

            return;
        }

        // create the steps
        int step = 1;
        State s = solver.getFinalState();
        boolean[][] lblAdded = new boolean[100][100];
        while (s.getParent() != null) {
            Location loc = s.getLocation();
            mazeButtons[loc.getX()][loc.getY()].setBackground(Color.white);
            String dog = mazeButtons[loc.getX()][loc.getY()].getText();
            if (!lblAdded[loc.getX()][loc.getY()]){
                JLabel label = new JLabel("" + step, SwingConstants.RIGHT);
                label.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 16));
                mazeButtons[loc.getX()][loc.getY()].add(label);
                lblAdded[loc.getX()][loc.getY()] = true;

            }
            else if (lblAdded[loc.getX()][loc.getY()]){
                JLabel label = new JLabel(mazeButtons[loc.getX()][loc.getY()].getText()+"           " + step, SwingConstants.RIGHT);
                label.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 16));
                label.setHorizontalTextPosition(JLabel.RIGHT);;
                label.setVerticalTextPosition(JLabel.TOP);
                mazeButtons[loc.getX()][loc.getY()].add(label);

            }
           
            mazeButtons[loc.getX()][loc.getY()].setFont(new Font("Serif", Font.PLAIN, 18));
            step++;
            s = s.getParent();
        }
        String dog = mazeButtons[maze.getStartX()][maze.getStartY()].getText();
        JLabel label = new JLabel("" + step);
        label.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 16));
        mazeButtons[maze.getStartX()][maze.getStartY()].add(label);
        // mazeButtons[maze.getStartX()][maze.getStartY()].setFont(new Font("Serif",
        // Font.PLAIN, 18));
        mazeButtons[maze.getStartX()][maze.getStartY()].setBackground(Color.yellow);
        frame.setSolution();

        ImageIcon icon = new ImageIcon("garfunkle.jpg");
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg);
        JOptionPane.showMessageDialog(frame,

                "Remember this solution well!!!!! Follow the numbers starting from " + (step)
                        + " and count down until the end!",
                "Solution Instructions",
                JOptionPane.INFORMATION_MESSAGE,
                icon);

        frame.repaint();

    }
}
