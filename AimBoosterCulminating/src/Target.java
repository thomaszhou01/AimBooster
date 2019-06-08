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
	
	

	
	public Target(int x, int y, int newDia) {
		not200 = true;
		xValue = x;
		yValue = y;
		diameter = newDia;
		image = new ImageIcon("src/Images/target.png").getImage();

	}
	
	public static void setCircleExpand(int expand) {
		circleExpandRate = expand;
	}
	public static void setMaxCircle(int circ) {
		maxCircleSize = circ;
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
	
	public boolean test() {
		return diameter>=(maxCircleSize-1);
	}
	//changes circle size
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
	
	public boolean getNot200() {
		return not200;
	}
	
	public double getCenterDist() {
		return fromCenterDist;

	}
	
	public double getRadius() {
		return radius;
	}
	
	public int getInner() {
		return inner;
	}
	
	public int getMiddle() {
		return middle;
	}
	
	public int getOuter() {
		return outer;
	}
	
	public static void reset() {
		inner = 0;
		middle = 0;
		outer = 0;
	}
	//checks if click is inside the circle
	public boolean insideCircle() {
		//checks where it hits 
		if (fromCenterDist <= radius*0.2) {
			inner++;
		}
		else if (fromCenterDist > radius*0.2 && fromCenterDist <= radius*0.8) {
			middle++;
		}
		else if (fromCenterDist > radius*0.8 && fromCenterDist <= radius) {
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
