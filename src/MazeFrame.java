import java.awt.*;

import javax.swing.*;


public class MazeFrame extends JFrame {
    private Container ct = getContentPane();
    private Maze maze;
    private JPanel text = new JPanel();
    private JLabel label = new JLabel("Keep Playing");
    
    private JButton[][] mazeButtons;

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
        mazeButtons = maze.createButton();
        for (int i = 0; i < maze.getHeight(); i++){
            for (int j = 0; j < maze.getWidth(); j++) {
                mazeJPanel.add(mazeButtons[i][j]);
                
                PlayListener l = new PlayListener(this, i, j);
                mazeButtons[i][j].addActionListener(l);
            }
            
        }

        // create mazeSelectionPanel
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



    }

    public JButton[][] getMazeButtons() {
        return mazeButtons;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setWin() {
        label.setText("You win!");
    }

    public void setSolution() {
        label.setText("Remember this solution!");
    }
}
