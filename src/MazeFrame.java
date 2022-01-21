import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;


public class MazeFrame extends JFrame {
    private Container ct = getContentPane();
    private Maze maze;

    public MazeFrame(Maze selection) {
        maze = selection;
        // Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ct.setBackground(Color.white);
        ct.setLayout(new FlowLayout());

        JPanel mazeJPanel = new JPanel();
        mazeJPanel.setBackground(Color.white);

        mazeJPanel.setLayout(new GridLayout(maze.getWidth(),maze.getHeight()));
        ct.add(mazeJPanel);


        for (int i = 0; i < selection.getHeight()*selection.getWidth()/2; i++){
            MazePanel mazePanel = new MazePanel(Color.yellow);
            MazePanel mazePanel1 = new MazePanel(Color.blue);
            mazeJPanel.add(mazePanel);
            mazeJPanel.add(mazePanel1);
        }
    }
}
