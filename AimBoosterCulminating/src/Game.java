import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class Game extends JPanel implements ActionListener{
	
	public int radius;
	public int jPanelLength;
	public int jPanelHeight;

	private int xValue;
	private int yValue;
	private int diameter;
	private int count;
	private boolean insideCircle;
	private int[][] circleLoc = new int[2][4];
	
	private ArrayList<Target> targets = new ArrayList<Target>();


	//constructor
	public Game() {
		super();
		jPanelLength = 900;
		jPanelHeight = 800;
        this.setBounds(50, 100, jPanelLength,jPanelHeight);    

        count = 0;
		diameter = 0;
		insideCircle = false;
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
			}
		});	
	}
	
	//paintcomponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		count++;
		if(count%500 == 0 || count == 1) {
			randomCircle();
		}
		
		//effects this
		
		removeCircle();
		
		for(int i = 0; i<targets.size(); i++) {
			targets.get(i).circleSize();
			g.drawImage(targets.get(i).getImage(), targets.get(i).getLocX(), targets.get(i).getLocY(), targets.get(i).getDiameter(), targets.get(i).getDiameter(), this);
		}
		
		g.fillOval(xValue-5, yValue-5, 10, 10);
	}
	
	
	//create random circles
	public void randomCircle() {

		int randX = (int)(Math.random()*jPanelLength);
		int randY = (int)(Math.random()*jPanelHeight);
        targets.add(new Target(randX, randY, 0));
		
	}
	
	public void removeCircle() {
		if(targets.size()>6) {
			targets.remove(0);

		}
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}
