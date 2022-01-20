import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;


public class MazeFrame extends JFrame {
    private Container ct = getContentPane();

    public MazeFrame() {
        // Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ct.setBackground(Color.white);
        ct.setLayout(new FlowLayout());

        JPanel maze = new JPanel();
    }
}
