import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Wall {
	private int x;
	private int y;
	private int deltaX;
	private int deltaY;
	private boolean visible = true;
	private Color color = Color.red;
	private Picture picture = null;
	private ModelDisplay modelDisplay = null;
	private Pen pen = new Pen();

	public Wall(ModelDisplay display, int x, int y, int deltaX, int deltaY) {
		this.x = x;
		this.y = y;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		modelDisplay = display;
		display.addModel(this);
	}
	public Wall(Picture picture) {
		x = 50;
		y = 50;
		deltaX = 150;
		deltaY = 0;
		this.picture = picture;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDeltaX() {
		return deltaX;
	}
	public int getDeltaY() {
		return deltaY;
	}

	public Color getColor() {
		return color;
	}
	public synchronized void paintComponent(Graphics g) {
		// cast to 2d object
		Graphics2D g2 = (Graphics2D) g;

		// if the robot is visible
		if (visible) {
			// save the current tranform
			AffineTransform oldTransform = g2.getTransform();
			// draw the shell
			g2.setColor(color);
			g2.drawLine(x,y, deltaX + x, deltaY + y);

			// reset the tranformation matrix
			g2.setTransform(oldTransform);
		}

		//  draw the pen
		pen.paintComponent(g);
	}

	public double[] getSlopeAndY() {
		double[] nums = new double[2];
		if(deltaX!=0) {
			nums[0] = (double)deltaY/(double)deltaX;
			System.out.println(nums[0]);
			nums[1] = y-nums[0]*x;
			return nums;
		}
		return null;
	}
}
