import javax.swing.JPanel;
import java.awt.*;


public class StartPanel extends JPanel {


	//
	// JPanels are useful as components to draw on
	//
/* 

	private Color col;
	private Color col2; */

	public StartPanel() {
		// set size, otherwise Java will assume 0 x 0 and component may disappear
		setPreferredSize(new Dimension(600,600));
		/* col2 = makeRandomColor(); */

	}
/* 

	public void randomSet() {

		col = makeRandomColor();

	} */
	/*
	 * This method is called whenever java wants to draw the panel
	 * CHange this to change the appearance of the panel
	 * 
	 */
	public void paintComponent(Graphics g) {
/* 
		col = makeRandomColor();        
		g.setColor(col);
		g.fillOval(-5, 107, 125, 125);
		g.drawString("Your First CS112 GUI Program",50,50);
		col2 = makeRandomColor();
		g.setColor(col2);

		
		g.fillOval(30,150,60,50); */
		g.setColor(Color.white);
		int[]whiteX = new int[]{48,87,45,37,112,65};
		int[]whiteY = new int[]{109,179,179,193,193,109};
        for (int i=0; i<whiteX.length; i++) {
            whiteX[i] = whiteX[i] * 3 + 70;
            whiteY[i] = whiteY[i]* 3  - 120;
          }
		g.fillPolygon(whiteX,whiteY,6);
		g.setColor(Color.black);
		int[] blackX = new int[]{112,37,58,50,10,105};
		int[]blackY = new int[]{193,193,155,139,210,210};
        for (int i=0; i<blackX.length; i++) {
            blackX[i] = blackX[i]*3 + 70;
            blackY[i] = blackY[i]*3 - 120;
          }
    	g.fillPolygon(blackX,blackY,6);
      	g.setColor(Color.GRAY);
		int[]grayX = new int[]{10,50,70,87,48,2};
		int[]grayY = new int[]{210,140,180,180,110,195};
        for (int i=0; i<whiteX.length; i++) {
            grayX[i] = grayX[i]*3 + 70;
            grayY[i] = grayY[i]*3 -120;
          }
      	g.fillPolygon(grayX,grayY,6);

	}

	// Math.random() returns a number between 0 and 1

	/* private Color makeRandomColor() {
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);

		Color col = new Color(red,green,blue);
		return col;
	} */

}
