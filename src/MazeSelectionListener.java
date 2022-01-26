import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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


            URL url = this.getClass().getResource("/gif1.gif");
            Icon myImgIcon1 = new ImageIcon(url);
            Box panel1 = Box.createVerticalBox();
            JLabel imageLb1 = new JLabel(myImgIcon1);
            JLabel textLb1 = new JLabel("<html>Starting on the red tile, the number of steps you are allowed to take is written <br/>"
            +"on each tile and you can only move horizontally or vertically." + "<br/>" 
            +"Your current location after the first move will be shown as a yellow square.<br/>"
            +"Any squares that you have already visited will be gray.</html>");
            
            panel1.add(imageLb1, JLabel.CENTER_ALIGNMENT);
            panel1.add(textLb1, JLabel.CENTER_ALIGNMENT);
            //component.add(imageLbl, BorderLayout.CENTER);
            JOptionPane.showMessageDialog(frame,
                
                panel1, "How to Play",
                JOptionPane.PLAIN_MESSAGE);
        }

        else if (action.equals("Maze 2")) {
            
            selection = new Maze2();
            selection.init();
            MazeFrame frame = new MazeFrame(selection);
            frame.pack();
            frame.setVisible(true);
            
		    frame.setSize(new Dimension(1000,1000));
            frame.repaint();


            URL url = this.getClass().getResource("/gif2.gif");
            Icon myImgIcon2 = new ImageIcon(url);
            Box panel2 = Box.createVerticalBox();
            JLabel imageLb2 = new JLabel(myImgIcon2);
            JLabel textLb2 = new JLabel("<html>Starting on the top left corner, you must reach the square marked 'GOAL'<br/>You can move along the direction of the arrow to"+
            " any of the squares with an OPPOSITE color arrow, <br/>then following the direction of that arrow. You must alternate between red and blue arrows.<br/>"+
            "Your current square is marked with yellow, and squares that you have already visited are gray.</html>");
            
            panel2.add(imageLb2, JLabel.CENTER_ALIGNMENT);
            panel2.add(textLb2, JLabel.CENTER_ALIGNMENT);
            //component.add(imageLbl, BorderLayout.CENTER);
            JOptionPane.showMessageDialog(frame,
                
                panel2, "How to Play",
                JOptionPane.PLAIN_MESSAGE);
        }

        else if (action.equals("Maze 3")) {
            
            selection = new Maze3();
            selection.init();
            MazeFrame frame = new MazeFrame(selection);
            frame.pack();
            frame.setVisible(true);
            
		    frame.setSize(new Dimension(1000,800));
            frame.repaint();


            URL url = this.getClass().getResource("/gif3.gif");
            Icon myImgIcon2 = new ImageIcon(url);
            Box panel2 = Box.createVerticalBox();
            JLabel imageLb2 = new JLabel(myImgIcon2);
            JLabel textLb2 = new JLabel("<html>Starting on the yellow square, you must reach the square with the green 'plus sign' in the very top row.<br/>You begin facing forward, and you can move horizontally or vertically"+
            " for as many squares as you want. <br/>However, you can only end your move on a square of the same color or symbol as the square you started on. <br/>"+
            "Be careful! You can not move back in the direction you came!</html>");
            
            panel2.add(imageLb2, JLabel.CENTER_ALIGNMENT);
            panel2.add(textLb2, JLabel.CENTER_ALIGNMENT);
            //component.add(imageLbl, BorderLayout.CENTER);
            JOptionPane.showMessageDialog(frame,
                
                panel2, "How to Play",
                JOptionPane.PLAIN_MESSAGE);
        }
		
	}

    public Maze getSelect() {
        return selection;
    }
}
