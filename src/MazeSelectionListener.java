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
        }
		
	}

    public Maze getSelect() {
        return selection;
    }
}
