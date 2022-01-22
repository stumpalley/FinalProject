import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
public class MazePanel extends JPanel{
    private Color color;

    public MazePanel(Color col){
        setPreferredSize(new Dimension(100,100));
        color = col;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        
        g.fillRect(50, 50, 600, 200);
    }
}
