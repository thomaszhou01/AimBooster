import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel implements ActionListener{
	
	public int radius;
	public int jPanelLength;
	public int jPanelHeight;
	private int xValue;
	private int yValue;
	private int count;
	private int clicks;
	private int hits;
	private int lives;


	private ArrayList<Target> targets = new ArrayList<Target>();
	private Random random = new Random();

	//constructor
	public Game() {
		super();
		jPanelLength = 900;
		jPanelHeight = 800;
        this.setBounds(50, 100, jPanelLength,jPanelHeight);    

        count = 0;
        clicks = 0;
        hits = 0;
        lives = 10;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
				clicks++;
			}
		});	
		setDoubleBuffered(true);
	}
	
	//paintcomponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		count++;
		//adds only one circle
		if(count%200 == 0 ||count == 1) {
			randomCircle();
		}
		
		
		g.drawString(hitPercent()+"%", 10, 10);
		g.drawString(hits+"/"+clicks, 10, 20);
		g.drawString(lives+"", 10, 30);

		//creates target if there are any
		if(targets.size()>0) {
			//creates targets
			for(int i = 0; i<targets.size(); i++) {
				targets.get(i).circleSize();
				
				g.drawImage(targets.get(i).getImage(), (int)targets.get(i).getLocX(), (int)targets.get(i).getLocY(), (int)targets.get(i).getDiameter(), (int)targets.get(i).getDiameter(), this);
				targets.get(i).setMouseLoc(xValue, yValue);
				
				//removes circles
				removeCircle(i);	
			}
			
			for(int i = 0; i<targets.size(); i++) {
				if(targets.size()>0 && targets.get(i).insideCircle()) {
					targets.remove(i);
					xValue = -100;
					yValue = -100;
					hits++;
				}
			}
		}

		g.fillOval(xValue, yValue, 2, 2);
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	//create random circles
	public void randomCircle() {

		int randX = random.nextInt(jPanelLength-2*Target.getMaxRadius())+Target.getMaxRadius();
		int randY = random.nextInt(jPanelHeight-2*Target.getMaxRadius())+Target.getMaxRadius();
        targets.add(new Target(randX, randY));
		
	}
	
	public void removeCircle(int i) {
		if(targets.get(i).getDiameter()==0) {
			targets.remove(i);
			lives--;
		}
	}
	
	public double hitPercent() {
		double hitPercent = Math.round((hits/(double)clicks)*100.0);
		
		return hitPercent;
	}
	
	public int getLives() {
		return lives;
	}
	public void actionPerformed(ActionEvent e) {
	}
}
