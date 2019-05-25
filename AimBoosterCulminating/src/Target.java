import java.awt.Image;

import javax.swing.ImageIcon;

public class Target{	
	private int diameter;
	private int radius;
	private int xValue;
	private int yValue;
	private int mouseX;
	private int mouseY;
	private boolean not200;
	private Image image;
	
	

	
	public Target(int x, int y, int diameter) {
		not200 = true;
		xValue = x;
		yValue = y;
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
	
	
	public int getDiameter() {
		return diameter;
	}
	
	public int getLocX() {
		return (xValue-diameter/2);
	}
	
	public int getLocY() {
		return (yValue-diameter/2);
	}
	
	public void setMouseLoc(int x, int y) {
		mouseX  = x;
		mouseY = y;
	}
	//changes circle size
	public int circleSize() {
		//figure out way for not200 to be be here
		if(diameter<= 200 && not200) {
			diameter += 1;
			if(diameter==200) {
				not200 = false;
			}
		}
		else if(diameter<0) {
			diameter = 0;
			not200 = true;
		}
		else {
			diameter -= 1;
			if(diameter == 0) {
				not200 = true;
			}
		}
		
		return diameter;
	}	
	
	public boolean getNot200() {
		return not200;
	}
	public boolean insideCircle(int x, int y, int mouseX, int mouseY, int diameter) {
		double fromCenterDist;
		radius = diameter/2;
		
		fromCenterDist = Math.sqrt((Math.pow(mouseX-x/2, 2)+Math.pow(mouseY-y/2, 2)));
		if (fromCenterDist <= radius) {
			return true;
		}
		else {
			return false;
		}
	}
}
