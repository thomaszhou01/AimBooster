import java.awt.Graphics;

public class FlickGame extends Game{
	
	private int max;
	
	public FlickGame() {
		super();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//count to determine when to add circle
		max = Target.getMaxCircle();

		count++;
		//adds only one circle
		if(count%(speed*4) == 0) {
			randomCircle(max);
			randomCircle(max);
		}
		
		//creates target if there are elements in array
		if(targets.size()>0) {
			//creates targets
			for(int i = 0; i<targets.size(); i++) {
				targets.get(i).circleSize();
				//from https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
				g.drawImage(targets.get(i).getImage(), (int)targets.get(i).getLocX(), (int)targets.get(i).getLocY(), (int)targets.get(i).getDiameter(), (int)targets.get(i).getDiameter(), this);
				targets.get(i).setMouseLoc(xValue, yValue);
				
				//removes circles
				removeCircle(i);	
			}
			
			//removes hit circles
			for(int i = targets.size()-1; i>=0 ; i--) {
				if(targets.size()>0 && targets.get(i).insideCircle()&&clicked) {
					play("src/Sounds/pop.wav");
					//get target hit place
					inner = targets.get(i).getInner();
					middle = targets.get(i).getMiddle();
					outer = targets.get(i).getOuter();
					
					//reset cursor 

					xValue = -Target.getMaxCircle();
					yValue = -Target.getMaxCircle();
					hits++;
					targets.remove(i);
					clicked = false;
					break;
				}
			}

		}			
		//reset cursor 
		xValue = -Target.getMaxCircle();
		yValue = -Target.getMaxCircle();
		
	
	}
}
