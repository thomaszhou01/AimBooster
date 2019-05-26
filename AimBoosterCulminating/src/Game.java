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
	private int count;

	private ArrayList<Target> targets = new ArrayList<Target>();


	//constructor
	public Game() {
		super();
		jPanelLength = 900;
		jPanelHeight = 800;
        this.setBounds(50, 100, jPanelLength,jPanelHeight);    

        count = 0;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
			}
		});	
		setDoubleBuffered(true);
	}
	
	//paintcomponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		count++;
		//adds only one circle
		if(count%300 == 0 ||count == 1) {
			randomCircle();
		}
		
		//effects this
		g.drawString(xValue+"", 200, 200);
		g.drawString(yValue+"", 200, 220);

		//creates target if there are any
		if(targets.size()>0) {
			//creates targets
			for(int i = 0; i<targets.size(); i++) {
				targets.get(i).circleSize();
				
				g.drawImage(targets.get(i).getImage(), (int)targets.get(i).getLocX(), (int)targets.get(i).getLocY(), (int)targets.get(i).getDiameter(), (int)targets.get(i).getDiameter(), this);
				
				targets.get(i).setMouseLoc(xValue, yValue);
				
				removeCircle(i);

				if(targets.get(i).insideCircle()) {
					targets.remove(i);
				}
			}
		}

		g.fillOval(xValue-2, yValue-2, 4, 4);
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	//create random circles
	public void randomCircle() {

		int randX = (int)(Math.random()*jPanelLength);
		int randY = (int)(Math.random()*jPanelHeight);
        targets.add(new Target(randX, randY, 0));
		
	}
	
	public void removeCircle(int i) {
		if(targets.get(i).getDiameter()==0) {
			targets.remove(i);

		}
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}
