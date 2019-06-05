import java.awt.Image;
import javax.swing.ImageIcon;

public class Target{	
	
	private static int maxCircleSize = 150;
	private static double circleExpandRate = 2;
	
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
	
	

	
	public Target(int x, int y, int newDia) {
		not200 = true;
		xValue = x;
		yValue = y;
		diameter = newDia;
		image = new ImageIcon("src/Images/target.png").getImage();

	}
	
	public static void setCircleExpand(double x) {
		circleExpandRate = circleExpandRate+x;
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
	
	public void setDiameter(double dia) {
		diameter = dia;
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
	
	public static int getMaxCircle() {
		return maxCircleSize;
	}
	
	//changes circle size
	public double circleSize() {
		//determine circle's size
		
		if(diameter<= maxCircleSize && not200) {
			if(diameter>=maxCircleSize && diameter<=(maxCircleSize+1) && not200) {
				not200 = false;
			}
			else {
				diameter += circleExpandRate;

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
