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
	private Image image;
	private int[][] circleLoc = new int[2][4];
	
	private ArrayList<Integer> circleX = new ArrayList<Integer>();
	private ArrayList<Integer> circleY = new ArrayList<Integer>();
	private ArrayList<Integer> circleDiameter = new ArrayList<Integer>();




	Target target = new Target();

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
		image = new ImageIcon("src/Images/target.png").getImage();
	}
	
	//paintcomponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		count++;
		if(count%200 == 0 || count == 1) {
			randomCircle();
		}
		
		
		diameter = target.circleSize(diameter);
		
		
		for(int i = 0; i<circleX.size(); i++) {
			g.drawImage(image, circleX.get(i)-diameter/2, circleY.get(i)-diameter/2, diameter, diameter, this);
		}
		
		for(int i = 0; i <circleLoc[0].length; i++) {
			insideCircle = target.insideCircle(circleLoc[0][i], circleLoc[1][i], xValue, yValue, diameter);
			if(insideCircle) {
				break;
			}
		}
		g.fillOval(xValue-5, yValue-5, 10, 10);
	}
	
	//create random circles
	public void randomCircle() {

		circleX.add((int)(Math.random()*jPanelLength));
		circleY.add((int)(Math.random()*jPanelHeight));
		circleDiameter.add(1);
		
	}
	
	public void removeCircle() {
		for(int i = 0; i<circleDiameter.size(); i++) {
			if(circleDiameter.get(i)==0) {
				circleDiameter.remove(i);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}
