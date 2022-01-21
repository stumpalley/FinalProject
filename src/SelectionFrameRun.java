import java.awt.*;


public class SelectionFrameRun {
	private SelectionFrame frame = new SelectionFrame();

	public void init() {
		frame.pack();
		frame.setVisible(true);
		frame.setSize(new Dimension(1000,800));
		frame.repaint();
	}
	public static void main(String[] args) {
		SelectionFrameRun run = new SelectionFrameRun();
		run.init();
		
		
		

		// this method must finish and return before GUI 
		// handling begins
	}

	public SelectionFrame getSelectionFrame() {
		return frame;
	}
}
