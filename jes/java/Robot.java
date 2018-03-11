
/**
 * Class that represents a robot which is similar to a Logo robot.
 * This class inherts from SimpleRobot and is for students
 * to add methods to.
 * <br>
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Robot extends SimpleRobot {
    ////////////////// constructors ///////////////////////

    /** Constructor that takes the x and y and a picture to
     * draw on
     * @param x the starting x position
     * @param y the starting y position
     * @param picture the picture to draw on
     */
    public Robot(int x, int y, Picture picture) {
        // let the parent constructor handle it
        super(x, y, picture);
    }

    /** Constructor that takes the x and y and a model
     * display to draw it on
     * @param x the starting x position
     * @param y the starting y position
     * @param modelDisplayer the thing that displays the model
     */
    public Robot(int x, int y, ModelDisplay modelDisplayer) {
        // let the parent constructor handle it
        super(x, y, modelDisplayer);
    }

    /** Constructor that takes the model display
     * @param modelDisplay the thing that displays the model
     */
    public Robot(ModelDisplay modelDisplay) {
        // let the parent constructor handle it
        super(modelDisplay);
    }

    /**
     * Constructor that takes a picture to draw on
     * @param p the picture to draw on
     */
    public Robot(Picture p) {
        // let the parent constructor handle it
        super(p);
    }

    /////////////////// methods ///////////////////////

} // end of class Robot, put all new methods before this