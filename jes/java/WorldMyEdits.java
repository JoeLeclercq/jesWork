import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class WorldMyEdits extends World {
	private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
	private ArrayList<Wall> wallList = new ArrayList<Wall>();
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
		Turtle turtle = null;
		Robot robot = null;
		Obstacle obstacle = null;
		Wall wall = null;
		g.setColor(this.background);

		// draw the background image
		g.drawImage(picture.getImage(), 0, 0, null);

		// loop drawing each turtle on the background image
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
		Iterator<Turtle> iterator = turtleList.iterator();
		while (iterator.hasNext()) {
			turtle = iterator.next();
			turtle.paintComponent(g);
		}
		Iterator<Robot> iterator2 = robotList.iterator();
		while (iterator2.hasNext()) {
			robot = iterator2.next();
			robot.paintComponent(g);
		}
	}
}
