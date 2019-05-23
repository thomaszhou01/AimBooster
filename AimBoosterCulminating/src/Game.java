import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game extends JPanel implements ActionListener{
	
	public int radius;
	public int jPanelLength;
	public int jPanelWidth;

	private int xValue;
	private int yValue;
	private int diameter;
	private boolean not200;
	private String hit = " ";
	private Image image;

	Target target = new Target();

	public Game() {
		super();
		jPanelLength = 900;
		jPanelWidth = 700;
        this.setBounds(50, 200, jPanelLength,jPanelWidth);    

		diameter = 0;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
			}
		});	
		
		target.insideCircle(xValue, yValue);
		image = new ImageIcon("bin/target.png").getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		diameter = target.circleSize();
		for(int i = 1; i<400; i=i+10) {
			g.drawOval(0, i, diameter, diameter);
		}
		g.fillOval(400, 400, 40, 40);
		g.drawImage(image, 0, 0, diameter, diameter, this);

	}
	
	
	public void actionPerformed(ActionEvent e) {
	}
}
