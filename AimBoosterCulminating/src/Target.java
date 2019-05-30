import java.awt.Image;

import javax.swing.ImageIcon;

public class Target{	
	
	private static int maxCircleSize;
	private static int maxCircleRadius;
	private static double circleExpandRate;
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
	
	

	
	public Target(int x, int y) {
		not200 = true;
		xValue = x;
		yValue = y;
		circleExpandRate = 0.5;
		maxCircleSize = 200;
		maxCircleRadius = maxCircleSize/2;
		diameter = 0;
		image = new ImageIcon("src/Images/target.png").getImage();

	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return xValue;
	}
	
	public int getY() {
		return yValue;
	}
	
	public static int getMaxRadius() {
		return maxCircleRadius;
	}
	public double getDiameter() {
		return diameter;
	}
	
	public double getLocX() {
		return (xValue-diameter/2);
	}
	
	public double getLocY() {
		return (yValue-diameter/2);
	}
	
	public void setMouseLoc(int x, int y) {
		mouseX  = x;
		mouseY = y;
	}
	
	//changes circle size
	public double circleSize() {
		//determine circle's size
		if(diameter<= maxCircleSize && not200) {
			diameter += circleExpandRate;
			if(diameter>=maxCircleSize && diameter<=maxCircleSize+1 && not200) {
				not200 = false;
			}
		}
		else if(diameter<0) {
			diameter = 0;
			not200 = true;
		}
		else {
			diameter -= circleExpandRate;
			if(diameter == 0) {
				not200 = true;
			}
		}
		radius = diameter/2;
		
		//from https://stackoverflow.com/questions/22269951/using-listeners-and-mouse-pointer-location-to-check-if-pointer-is-inside-of-a-ci
		fromCenterDist = Math.sqrt((Math.pow(mouseX-xValue, 2)+Math.pow(mouseY-yValue, 2)));
		return diameter;
	}	
	
	public boolean getNot200() {
		return not200;
	}
	
	public double getCenterDist() {
		return fromCenterDist;

	}
	
	public double getRadius() {
		return radius;
	}
	
	//checks if click is inside the circle
	public boolean insideCircle() {
		if (fromCenterDist <= radius) {
			return true;
		}
		else {
			return false;
		}
	}
}
