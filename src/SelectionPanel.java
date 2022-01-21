import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class SelectionPanel implements ActionListener {
    private JButton changer;
    JPopupMenu menu;
    private SelectionFrame frame;

    public SelectionPanel(JButton selectionButton, SelectionFrame fr) {
        changer = selectionButton;
        frame = fr;
        MazeSelectionListener listener = new MazeSelectionListener(frame);

        // create popup menu
        menu = new JPopupMenu("Menu");

        JMenuItem one = new JMenuItem("Maze 1");
        one.setActionCommand("Maze 1");
        one.addActionListener(listener);
        menu.add(one);

        JMenuItem two = new JMenuItem("Maze 2");
        two.addActionListener(listener);
        menu.add(two);

        JMenuItem three = new JMenuItem("Maze 3");
        three.addActionListener(listener);
        menu.add(three);
    }

    public void actionPerformed(ActionEvent e) {
		
		menu.show(changer,changer.getWidth()/2,changer.getHeight()/2);
	}
    
}
