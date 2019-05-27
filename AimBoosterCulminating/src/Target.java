import java.awt.Image;

import javax.swing.ImageIcon;

public class Target{	
	
	private static int maxCircleSize;
	private double diameter;
	private double radius;
	private int xValue;
	private int yValue;
	private int mouseX;
	private int mouseY;
	private double fromCenterDist;
	private boolean not200;
	private Image image;
	
	

	
	public Target(int x, int y, int diameter) {
		not200 = true;
		xValue = x;
		yValue = y;
		maxCircleSize = 200;
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
		
		if(diameter<= maxCircleSize && not200) {
			diameter += 0.5;
			if(diameter==maxCircleSize) {
				not200 = false;
			}
		}
		else if(diameter<0) {
			diameter = 0.5;
			not200 = true;
		}
		else {
			diameter -= 0.5;
			if(diameter == 0) {
				not200 = true;
			}
		}
		radius = diameter/2;
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
	public boolean insideCircle() {
		if (fromCenterDist <= radius) {
			return true;
		}
		else {
			return false;
		}
	}
}
