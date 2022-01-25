import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class MazeSelectionListener extends JFrame implements ActionListener {
    private Maze selection;
    private JFrame frame;

    public MazeSelectionListener(JFrame fr) {
        frame = fr;
    }

    public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
        frame.dispose();
        if (action.equals("Maze 1")) {
            
            selection = new Maze1();
            selection.init();
            MazeFrame frame = new MazeFrame(selection);
            frame.pack();
            frame.setVisible(true);
            
		    frame.setSize(new Dimension(1000,800));
            frame.repaint();

            JOptionPane.showMessageDialog(frame,
                
                "Starting on the red tile, the number of steps you are allowed to take is written on each tile and you can only move horizontally or vertically." + "\n" +"The tiles that you are allowed to move to will light up automatically.",
                "Maze Instructions",
                JOptionPane.PLAIN_MESSAGE);
        }

        if (action.equals("Maze 2")) {
            
            selection = new Maze2();
            selection.init();
            MazeFrame frame = new MazeFrame(selection);
            frame.pack();
            frame.setVisible(true);
            
		    frame.setSize(new Dimension(1000,1000));
            frame.repaint();

            JOptionPane.showMessageDialog(frame,
                
                "Starting on the top left corner, you must reach the square marked 'GOAL'\nYou can move along the direction of the arrow to"+
                " any of the squares with an OPPOSITE color arrow, \nthen following the direction of that arrow. You must alternate between red and blue arrows.\n"+
                "Your current square is marked with yellow, and squares that you have already visited are gray.",
                "Maze Instructions",
                JOptionPane.PLAIN_MESSAGE);
        }
		
	}

    public Maze getSelect() {
        return selection;
    }
}
