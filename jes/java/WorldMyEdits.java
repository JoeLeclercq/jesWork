import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorldMyEdits extends World {
	/** the list of robots in the world */
	protected List<Robot> robotList = new ArrayList<Robot>();
	/** the list of obstacles in the world */
	private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
	/** the list of walls in the world */
	private ArrayList<Wall> wallList = new ArrayList<Wall>();
	
	private Picture hiddenPic = null;
	
	public WorldMyEdits() {
		super();
		hiddenPic = new Picture(width, height);
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
		super.paintComponent(g);
		Iterator<Robot> iterator2 = robotList.iterator();
		while (iterator2.hasNext()) {
			robot = iterator2.next();
			robot.paintComponent(g);
		}
	}
	
	public ArrayList<Wall> getWalls(){
		return wallList;
	}
	
	public List<Robot> getRobotList() {
		return robotList;
	}
	
	public Iterator getRobotIterator() {
		return robotList.iterator();
	}
}
