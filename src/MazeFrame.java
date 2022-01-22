import java.awt.*;

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

        int count = 0;
        for (int i = 0; i < maze.getHeight(); i++){
            for (int j = 0; j < maze.getWidth(); j++) {
                JButton button = new JButton("" + maze.getDirection(i,j));
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
                mazeJPanel.add(button);
                count++;
            }
            
        }

    }
}
