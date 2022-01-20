import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class MazeSelectionPanel implements ActionListener {
    private JButton changer;
    JPopupMenu menu;

    public MazeSelectionPanel(JButton selectionButton) {
        changer = selectionButton;

        // create popup menu
        menu = new JPopupMenu("Menu");

        JMenuItem one = new JMenuItem("Maze 1");
        menu.add(one);

        JMenuItem two = new JMenuItem("Maze 2");
        menu.add(two);

        JMenuItem three = new JMenuItem("Maze 3");
        menu.add(three);
    }

    public void actionPerformed(ActionEvent e) {
		
		menu.show(changer,changer.getWidth()/2,changer.getHeight()/2);
	}
    
}
