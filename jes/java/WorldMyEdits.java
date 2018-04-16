import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class WorldMyEdits extends JComponent implements ModelDisplay {
	////////////////// fields ///////////////////////

	/** should automatically repaint when model changed */
	protected boolean autoRepaint = true;

	/** the background color for the world */
	protected Color background = Color.white;

	/** the width of the world */
	protected int width = 640;

	/** the height of the world */
	protected int height = 480;

	/** the list of turtles in the world */
	protected List<Turtle> turtleList = new ArrayList<Turtle>();

	/** the JFrame to show this world in */
	private JFrame frame = new JFrame("World");

	/** background picture */
	protected Picture picture = null;

	private static final long serialVersionUID = 7526471155622776147L;

	protected List<Robot> robotList = new ArrayList<Robot>();
	/** the list of obstacles in the world */
	private List<Obstacle> obstacleList = new ArrayList<Obstacle>();
	/** the list of walls in the world */
	private List<Wall> wallList = new ArrayList<Wall>();

	private Picture hiddenPic = null;

	public WorldMyEdits() {
		initWorld(true);
		hiddenPic = new Picture(width, height);
	}

	private void initWorld(boolean visibleFlag) {
		// set the preferred size
		this.setPreferredSize(new Dimension(width, height));

		// create the background picture
		picture = new Picture(width, height);

		// add this panel to the frame
		frame.getContentPane().add(this);

		// pack the frame
		frame.pack();

		// show this world
		frame.setVisible(visibleFlag);
	}

	public Graphics getGraphics() {
		return picture.createGraphics();
	}

	/**
	 * Method to clear the background picture
	 */
	public void clearBackground() {
		picture = new Picture(width, height);
	}

	/**
	 * Method to get the background picture
	 * @return the background picture
	 */
	public Picture getPicture() {
		return picture;
	}

	/**
	 * Method to set the background picture
	 * @param pict the background picture to use
	 */
	public void setPicture(Picture pict) {
		picture = pict;
	}

	public void addModel(Object model) {
		if(model instanceof Turtle) {
			turtleList.add((Turtle) model);
		}
		else if(model instanceof Robot){
			robotList.add((Robot) model);
		}
		else if (model instanceof Obstacle){
			obstacleList.add((Obstacle) model);
			hiddenPic.addRectFilled(((Obstacle)model).getColor(),((Obstacle) model).getXPos(),((Obstacle) model).getYPos(), ((Obstacle) model).getWidth(), ((Obstacle) model).getLength());
		}
		else {
			wallList.add((Wall) model);
			for(Robot robot: robotList) {
				robot.addWall((Wall) model);
			}
		}
		if (autoRepaint) {
			repaint();
		}
	}
	public synchronized void paintComponent(Graphics g) {
		Robot robot = null;
		Obstacle obstacle = null;
		Wall wall = null;
		g.setColor(this.background);

		// draw the background image
		g.drawImage(picture.getImage(), 0, 0, null);

		// loop drawing each object on the background image
		Iterator<Obstacle> iterator3 = obstacleList.iterator();
		while (iterator3.hasNext()) {
			obstacle = iterator3.next();
			obstacle.paintComponent(g);
		}
		Iterator<Wall> iterator4 = wallList.iterator();
		while (iterator4.hasNext()) {
			wall = iterator4.next();
			wall.paintComponent(g);
		}
		//super.paintComponent(g);
		Iterator<Robot> iterator2 = robotList.iterator();
		while (iterator2.hasNext()) {
			robot = iterator2.next();
			robot.paintComponent(g);
		}
	}

	/**
	 * Method to remove the passed object from the world
	 * @param model the model object to remove
	 */
	public void remove(Object model) {
		if(model instanceof Turtle) {
			turtleList.remove(model);
		}
		else if(model instanceof Robot){
			robotList.remove((Robot) model);
		}
		else if (model instanceof Obstacle){
			obstacleList.remove((Obstacle) model);
		}
		else {
			wallList.remove((Wall) model);
			for(Robot robot: robotList) {
				robot.removeWall((Wall) model);
			}
		}
	}

	/**
	 * Method to get the width in pixels
	 * @return the width in pixels
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Method to get the height in pixels
	 * @return the height in pixels
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Method that allows the model to notify the display
	 */
	public void modelChanged() {
		if (autoRepaint) {
			repaint();
		}
	}

	/**
	 * Method to set the automatically repaint flag
	 * @param value if true will auto repaint
	 */
	public void setAutoRepaint(boolean value) {
		autoRepaint = value;
	}

	/**
	 * Method to hide the frame
	 */
	public void hideFrame() {
		frame.setVisible(false);
	}

	/**
	 * Method to show the frame
	 */
	public void showFrame() {
		frame.setVisible(true);
	}

	/**
	 * Method to get the list of turtles in the world
	 * @return a list of turtles in the world
	 */
	public List getTurtleList() {
		return turtleList;
	}


	/**
	 * Method to get an iterator on the list of turtles
	 * @return an iterator for the list of turtles
	 */
	public Iterator getTurtleIterator() {
		return turtleList.iterator();
	}

	public List<Wall> getWallList(){
		return wallList;
	}

	public List<Robot> getRobotList() {
		return robotList;
	}

	public Picture getHidden(){
		return hiddenPic;
	}
	public Iterator<Robot> getRobotIterator() {
		return robotList.iterator();
	}
	public Iterator<Obstacle> getObstacleIterator() {
		return obstacleList.iterator();
	}
	public Iterator<Wall> getWallIterator() {
		return wallList.iterator();
	}
}
