import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;

public class SelectionFrame extends JFrame {
    
	private Container ct = getContentPane();

    public SelectionFrame() {

        // Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ct.setBackground(Color.BLUE);
        ct.setLayout(new FlowLayout());

        // create start panel
        JPanel mP = new JPanel();
        mP.setBackground(Color.BLUE);
        mP.setLayout(new FlowLayout());
        // add start panel to content pane
        ct.add(mP);

        
        // add start panel graphics
        StartPanel startPanel = new StartPanel();
        mP.add(startPanel);

        // create mazeSelectionPanel
        JPanel mSP = new JPanel();
        mSP.setBackground(Color.BLUE);
        mSP.setLayout(new FlowLayout());

        JButton selectionButton = new JButton("Maze Selection");

        mSP.add(selectionButton);

        ct.add(mSP);

        MazeSelectionPanel sp = new MazeSelectionPanel(selectionButton);

        selectionButton.addActionListener(sp);
    }
}
