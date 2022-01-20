import javax.swing.JPanel;
import java.awt.*;
public class GenerateMaze extends JPanel{
    private Maze maze;

    public GenerateMaze (Maze selection) {
        setPreferredSize(new Dimension(800,800));
        maze = selection;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        int[] x ={4, 104, 104, 4};
        int[] y ={4, 4, 104, 104};
        g.fillPolygon(x, y,4);
    }
}
