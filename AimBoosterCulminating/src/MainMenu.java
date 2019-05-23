import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{
	
	Timer tock;

	private int tickrate = 16;
	private int x;
	public static int MENULENGTH;
	public static int MENUWIDTH;
	private JLabel title = new JLabel("Aim Booster");

	
	public MainMenu() {
		tock = new Timer(tickrate, this);
		tock.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	public void actionPerformed(ActionEvent e) {
	}
}
