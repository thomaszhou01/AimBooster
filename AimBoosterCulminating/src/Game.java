import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game extends JPanel implements ActionListener{
	
	public int radius;

	private int xValue;
	private int yValue;
	private int diameter;
	private boolean not200;
	private String hit = " ";
	private Image image;

	Target target = new Target();

	public Game() {
		super();
		diameter = 0;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
			}
		});	
		
		target.insideCircle(xValue, yValue);
		image = new ImageIcon("bin/target.png").getImage();
		image = image.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		diameter = target.circleSize();
		circleSize();
		g.fillOval(0, 0, diameter, diameter);
		g.fillOval(400, 400, 40, 40);
		g.drawImage(image, diameter, diameter, this);

	}
	
	
	public void circleSize() {
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
				hit = "";
			}
		}
		

	}
	public void actionPerformed(ActionEvent e) {
	}
}
