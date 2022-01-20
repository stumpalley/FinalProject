import java.awt.*;


public class SelectionFrameRun {

	public static void main(String[] args) {

		SelectionFrame frame = new SelectionFrame();
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(new Dimension(1000,800));
		frame.repaint();

		// this method must finish and return before GUI 
		// handling begins
	}

}
