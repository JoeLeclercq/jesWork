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
	
	public Wall(ModelDisplay display) {
		x = 50;
		y = 50;
		deltaX = 150;
		deltaY = 0;
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
}
