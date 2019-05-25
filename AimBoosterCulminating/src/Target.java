

public class Target{	
	private int diameter;
	private int radius;
	private boolean not200;

	
	public Target() {
		not200 = true;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getCircum() {
		return diameter;
	}
	//changes circle size
	public int circleSize(int newDiameter) {
		if(newDiameter<= 200 && not200) {
			newDiameter += 1;
			if(newDiameter==200) {
				not200 = false;
			}
			
		}
		else if(newDiameter<0) {
			newDiameter = 0;
			not200 = true;
		}
		else {
			newDiameter -= 1;
			if(newDiameter == 0) {
				not200 = true;
			}
		}
		
		return newDiameter;
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
