import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;

public class SelectionFrame extends JFrame {
    
	public Container ct = getContentPane();

    public SelectionFrame() {

        // Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ct.setBackground(Color.white);
        ct.setLayout(new FlowLayout());

        // Title Panel
        JPanel tp1 = new JPanel();
        tp1.setBackground(Color.white);
        JLabel tpLbl1 = new JLabel("Welcome to Alex Yan's Maze Game");
        tp1.setLocation(400,200);;
        tpLbl1.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,40));

        tp1.add(tpLbl1);
        ct.add(tp1,JPanel.CENTER_ALIGNMENT);


        // create start panel
        JPanel mP = new JPanel();
        mP.setBackground(Color.white);
        mP.setLayout(new FlowLayout());
        // add start panel to content pane
        ct.add(mP);

        
        // add start panel graphics
        StartPanel startPanel = new StartPanel();
        mP.add(startPanel);

        // create mazeSelectionPanel
        JPanel mSP = new JPanel();
        mSP.setBackground(Color.white);
        mSP.setLayout(new FlowLayout());

        JButton selectionButton = new JButton("Maze Selection");

        mSP.add(selectionButton);

        ct.add(mSP);

        SelectionPanel sp = new SelectionPanel(selectionButton, this);

        selectionButton.addActionListener(sp);

        // Title Panel
        JPanel tp = new JPanel();
        tp.setBackground(Color.white);

        JLabel tpLbl = new JLabel("These Mazes Will Bend Your Mind!!!!!");
        tpLbl.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,40));

        tp.add(tpLbl);
        ct.add(tp,JPanel.CENTER_ALIGNMENT);
    }
}
