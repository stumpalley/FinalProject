import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MazeSelectionListener implements ActionListener {
    private Maze selection;

    public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

        if (action.equals("Maze 1")) {
            selection = new Maze1(7,7);
        }
		
	}
}
