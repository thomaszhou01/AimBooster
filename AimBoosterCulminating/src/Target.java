

public class Target{	
	private int diameter;
	private int radius;
	private boolean not200 = true;

	
	public Target() {
		diameter = 0;
		circleSize();
		
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getCircum() {
		return diameter;
	}
	//changes circle size
	public int circleSize() {
		radius = diameter/2;
		if(diameter<= 200 && not200) {
			diameter += 1;
			if(diameter==200) {
				not200 = false;
			}
			
		}
		else {
			diameter -= 1;
			if(diameter == 0) {
				not200 = true;
			}
		}
		return diameter;
	}	
	
	
	public boolean insideCircle(int x, int y) {
		double fromCenterDist;
		
		fromCenterDist = Math.sqrt((Math.pow(x-500/2, 2)+Math.pow(y-500/2, 2)));
		if (fromCenterDist <= radius) {
			return true;
		}
		else {
			return false;
		}
	}
}
