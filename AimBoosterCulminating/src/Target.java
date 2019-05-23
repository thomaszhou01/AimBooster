import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Target extends Game{	
	private int xValue=1000;
	private int yValue=1000;
	private int radius;
	private double fromCenterDist;
	private String hit = " ";
	private static int CIRCLEDIAMETER;
	private boolean not200 = true;

	
	public Target() {
		CIRCLEDIAMETER = 0;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
			}
		});
		
	}
	
	
	//changes circle size
	public void circleSize() {
		radius = CIRCLEDIAMETER/2;
		if(CIRCLEDIAMETER<= 200 && not200) {
			CIRCLEDIAMETER += 1;
			if(CIRCLEDIAMETER==200) {
				not200 = false;
			}
			
		}
		else {
			CIRCLEDIAMETER -= 1;
			if(CIRCLEDIAMETER == 0) {
				not200 = true;
			}
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		circleSize();
		insideCircle();
		g.drawOval(300/2-CIRCLEDIAMETER/2, 300/2-CIRCLEDIAMETER/2, CIRCLEDIAMETER, CIRCLEDIAMETER);
		g.fillOval(xValue, yValue, 10, 10);
		g.drawString(radius+"", 50, 80);
		g.drawString(hit, 50, 100);
		g.drawString(fromCenterDist+"", 50, 120);
		repaint();

	}
	
	public void insideCircle() {
		fromCenterDist = Math.sqrt((Math.pow(xValue-500/2, 2)+Math.pow(yValue-500/2, 2)));
		if (fromCenterDist <= radius) {
			hit = "You hit";
		}
	}	
}
