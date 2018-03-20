import java.awt.*;
import java.awt.geom.AffineTransform;
public class Obstacle{
	private int xPos;
	private int yPos;
	private int width;
	private int length;
	private Color color = Color.BLACK;
	private Pen pen = new Pen();
	private boolean visible = true;
	private Picture picture = null;
	private ModelDisplay modelDisplay = null;
	private Color infoColor = Color.BLACK;
	private boolean showInfo = false;
	public Obstacle(Picture picture) {
		this.picture = picture;
		xPos = 20;
		yPos = 30;
		width = 20;
		length = 25;
	}
	public Obstacle(ModelDisplay display) {
		modelDisplay = display;
		xPos = 20;
		yPos = 30;
		width = 20;
		length = 25;
		display.addModel(this);
	}
	public Obstacle(int xPos, int yPos, int width, int length, Picture picture) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.length = length;
		this.picture = picture;
	}
	
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public int getWidth() {
		return width;
	}
	public int getLength() {
		return length;
	}
	public Color getColor() {
		return color;
	}
	public synchronized void updateDisplay() {
        // check that x and y are at least 0
        if (xPos < 0) {
            xPos = 0;
        }
        if (yPos < 0) {
            yPos = 0;
        }

        // if picture
        if (picture != null) {
            if (xPos >= picture.getWidth()) {
                xPos = picture.getWidth() - 1;
            }
            if (yPos >= picture.getHeight()) {
                yPos = picture.getHeight() - 1;
            }
            Graphics g = picture.getGraphics();
            paintComponent(g);
        } else if (modelDisplay != null) {
            if (xPos >= modelDisplay.getWidth()) {
                xPos = modelDisplay.getWidth() - 1;
            }
            if (yPos >= modelDisplay.getHeight()) {
                yPos = modelDisplay.getHeight() - 1;
            }
            modelDisplay.modelChanged();
        }
    }
	public synchronized void paintComponent(Graphics g) {
        // cast to 2d object
        Graphics2D g2 = (Graphics2D) g;

        // if the robot is visible
        if (visible ) {
            // save the current tranform
            AffineTransform oldTransform = g2.getTransform();


            // draw the shell
            g2.setColor(color);
            g2.fillRect(xPos,yPos, width + xPos, length + yPos);
            // draw the info string if the flag is true
            if (showInfo ) {
                drawInfoString(g2);
            }

            // reset the tranformation matrix
            g2.setTransform(oldTransform);
        }

        //  draw the pen
        pen.paintComponent(g);
    }

    /**
     * Method to draw the information string
     * @param g the graphics context
     */
    public synchronized void drawInfoString(Graphics g) {
        g.setColor(infoColor );
        g.drawString(this.toString(), xPos + (int)(width / 2), yPos);
    }
}