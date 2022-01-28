import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.*;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.Font;


public class MazeFrame extends JFrame {
    private Container ct = getContentPane();
    private Maze maze;
    private JPanel text = new JPanel();
    private JLabel label = new JLabel("Keep Playing");
    private Location currentLocation;
    private int plays = 0;
    private Stack<Location> locations = new Stack<Location>();
    
    private JButton[][] mazeButtons;

    public MazeFrame(Maze selection) {
        maze = selection;
        currentLocation = maze.getLocationAt(maze.getStartX(), maze.getStartY());

        // Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ct.setBackground(Color.white);
        ct.setLayout(new FlowLayout());

        JPanel mazeJPanel = new JPanel();
        mazeJPanel.setBackground(Color.white);

        mazeJPanel.setLayout(new GridLayout(maze.getWidth(),maze.getHeight()));

        ct.add(mazeJPanel);
        mazeButtons = maze.createButton();
        for (int i = 0; i < maze.getHeight(); i++){
            for (int j = 0; j < maze.getWidth(); j++) {
                mazeJPanel.add(mazeButtons[i][j]);
                
                PlayListener l = new PlayListener(this, i, j);
                mazeButtons[i][j].addActionListener(l);
            }
            
        }

        // create mazeSelectionPanel and solution button
        JPanel mSP = new JPanel();
        mSP.setBackground(Color.white);
        mSP.setLayout(new FlowLayout());
        mSP.add(label);

        JButton solutionButton = new JButton("Show Solution");

        mSP.add(solutionButton);

        JButton selectionButton = new JButton("Maze Selection");

        mSP.add(selectionButton);


        ct.add(mSP);

        SolutionListener sl = new SolutionListener(maze, this);

        solutionButton.addActionListener(sl);

        SelectionPanel sp = new SelectionPanel(selectionButton, this);

        selectionButton.addActionListener(sp);

        // create UNDO button
        JButton hintButton = new JButton("Hint");
        mSP.add(hintButton);

        HintListener hl = new HintListener(this);
        hintButton.addActionListener(hl);

        JButton undoButton = new JButton("Undo");
        mSP.add(undoButton);

        UndoListener ul = new UndoListener(this);
        undoButton.addActionListener(ul);

        // create How to Play Button
        JButton howToPlay = new JButton("How to Play");
        mSP.add(howToPlay);

        HowToListener htl = new HowToListener(this);
        howToPlay.addActionListener(htl);


    }

    public JButton[][] getMazeButtons() {
        return mazeButtons;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setWin() {
        label.setText("You win!");
/* 
        URL url = ct.getClass().getResource("src\\wingif.gif");
        Icon myImgIcon2 = new ImageIcon(url);  */
        Box panel2 = Box.createVerticalBox();
        ImageIcon img = new ImageIcon("src\\winner.jpg");
        JLabel imageLb2 = new JLabel(img);
        JLabel textLb2 = new JLabel("<html>YOU WIN!!!!!!!<br/>Now open another maze!</html>");
        textLb2.setFont(new Font("Hiragino Mincho Pro", Font.PLAIN, 30));
        textLb2.setHorizontalAlignment(SwingConstants.CENTER);
        textLb2.setVerticalAlignment(SwingConstants.CENTER);
        panel2.add(imageLb2, JLabel.CENTER_ALIGNMENT);
        panel2.add(textLb2, JLabel.CENTER);
        //component.add(imageLbl, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(ct,
            panel2, "How to Play",
            JOptionPane.PLAIN_MESSAGE);
    }

    public void setSolution() {
        label.setText("Remember this solution!");
    }

    public void setLocation(Location l) {
        currentLocation = l;
    }

    public Location getCurrLocation() {
        return currentLocation;
    }

    public void setPlays(int i) {
        plays += i;
    }

    public int getPlays() {
        return plays;
    }

    public Stack<Location> getStack() {
        return locations;
    }

    public void addToStack(Location l) {
        locations.add(l);
    }
}
