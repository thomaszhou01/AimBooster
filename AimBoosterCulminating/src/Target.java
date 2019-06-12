// Thomas Zhou, Andy Wang
// June 10, 2019
// Target class. Used by game classes to create targets and to determine if user hits a target
// ICS3U7 Mr. Anthony

import java.awt.Image;
import javax.swing.ImageIcon;

public class Target{	
	
	private static int maxCircleSize;
	private static double circleExpandRate;
	private static int inner;
	private static int middle;
	private static int outer;
	
	private double diameter;
	private double radius;
	private int xValue;
	private int yValue;
	private int mouseX;
	private int mouseY;
	private double fromCenterDist;
	private boolean not200;
	
	//from https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
	private static Image image;
	
	//constructor
	public Target(int x, int y, int newDia) {
		not200 = true;
		xValue = x;
		yValue = y;
		diameter = newDia;
		image = new ImageIcon("src/Images/target.png").getImage();

	}
	
	/* method setCircleExpand()
	 * gets rate of circle expansion
	 * pre: int expand rate
	 * post: circleExpandRate is assigned an int value
	 */
	public static void setCircleExpand(int expand) {
		circleExpandRate = expand;
	}
	
	/* method setMaxCircle()
	 * gets max circle size
	 * pre: int maxCircle size
	 * post: maxCircleSize is assigned an int value
	 */
	public static void setMaxCircle(int circ) {
		maxCircleSize = circ;
	}
	
	/* method getImage()
	 * returns image of target
	 * pre: called by class
	 * post: image is returned
	 */
	public Image getImage() {
		return image;
	}
	
	/* method getX()
	 * returns x value of location
	 * pre: called by class
	 * post: xValue is returned
	 */
	public int getX() {
		return xValue;
	}
	
	/* method getY()
	 * returns y value of location
	 * pre: called by class
	 * post: yValue is returned
	 */
	public int getY() {
		return yValue;
	}
	
	/* method getDiameter()
	 * returns diameter of target
	 * pre: called by class
	 * post: diameter is returned
	 */
	public double getDiameter() {
		return diameter;
	}
	
	/* method setDiameter()
	 * sets the diameter
	 * pre: double dia
	 * post: diameter is set
	 */
	public void setDiameter(double dia) {
		diameter = dia;
	}
	
	/* method getLocX()
	 * returns centered x value for target 
	 * pre: called by class
	 * post: x location for target
	 */
	public double getLocX() {
		return (xValue-diameter/2);
	}
	
	/* method getLocY()
	 * returns centered y value for target 
	 * pre: called by class
	 * post: y location for target
	 */
	public double getLocY() {
		return (yValue-diameter/2);
	}
	
	/* method setMouseLoc()
	 * gets the mouse location
	 * pre: called by class
	 * post: x and y integer coordinates are assigned
	 */
	public void setMouseLoc(int x, int y) {
		mouseX  = x;
		mouseY = y;
	}
	
	/* method getMaxCircle()
	 * returns maximum target size
	 * pre: called by class
	 * post: returns int maxCircleSize
	 */
	public static int getMaxCircle() {
		return maxCircleSize;
	}
	
	/* method circleSize()
	 * increases target size to a certain maximum and decreases to 0
	 * pre: a target must use this variable
	 * post: diameter will be changed
	 */
	public double circleSize() {
		//determine circle's size
		if(diameter<= maxCircleSize && not200) {
			//size increase
			if(diameter>=(maxCircleSize-2) && diameter<=(maxCircleSize+2) && not200) {
				//boolean to stop increase
				not200 = false;
			}
			else {
				//increase size
				diameter += circleExpandRate;

			}
		}
		else {
			//size decrease
			diameter -= circleExpandRate;
		}
		radius = diameter/2;
		
		//from https://stackoverflow.com/questions/22269951/using-listeners-and-mouse-pointer-location-to-check-if-pointer-is-inside-of-a-ci
		//calculates distance mouse click is from the circle
		fromCenterDist = Math.sqrt((Math.pow(mouseX-xValue, 2)+Math.pow(mouseY-yValue, 2)));
		return diameter;
	}	
	
	/* method getCenterDist()
	 * returns distance mouse is from circle
	 * pre: called by class
	 * post: fromCenterDist is returned
	 */
	public double getCenterDist() {
		return fromCenterDist;
	}
	
	
	/* method getRadius()
	 * returns radius of target 
	 * pre: called by class
	 * post: radius returned
	 */
	public double getRadius() {
		return radius;
	}
	
	/* method getInner()
	 * returns number of clicks in inner part of target
	 * pre: called by class
	 * post: int inner
	 */
	public int getInner() {
		return inner;
	}
	
	/* method getMiddle()
	 * returns number of clicks in middle part of target
	 * pre: called by class
	 * post: int middle
	 */
	public int getMiddle() {
		return middle;
	}
	
	/* method getOuter()
	 * returns number of clicks in outer part of target
	 * pre: called by class
	 * post: int outer
	 */
	public int getOuter() {
		return outer;
	}
	
	/* method reset()
	 * resets inner, middle, and outer
	 * pre: called by class
	 * post: variables reset
	 */
	public static void reset() {
		inner = 0;
		middle = 0;
		outer = 0;
	}
	
	/* method insideCircle()
	 * checks if click is inside the target. Also checks which part in target is hit
	 * pre: called by class
	 * post: boolean
	 */
	public boolean insideCircle() {
		//checks where it hits 
		if (fromCenterDist <= radius*0.2) {
			inner++;
		}
		else if (fromCenterDist > radius*0.2 && fromCenterDist <= radius*0.6) {
			middle++;
		}
		else if (fromCenterDist > radius*0.6 && fromCenterDist <= radius) {
			outer++;
		}
		
		//checks if hit
		if (fromCenterDist <= radius) {
			return true;
			
		}
		else {
			return false;
		}
	}
}
