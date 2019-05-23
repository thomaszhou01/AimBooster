import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{
	
	public int radius;

	
	private int tickrate = 16;
	private int x;
	public static int MENULENGTH;
	public static int MENUWIDTH;
	private JLabel title = new JLabel("Aim Booster");

	
	public MainMenu() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(200, 200);


	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(0, 0, radius, 40);
		g.fillOval(400, 400, 40, 40);

	}
	
	
	public void actionPerformed(ActionEvent e) {
	}
}
