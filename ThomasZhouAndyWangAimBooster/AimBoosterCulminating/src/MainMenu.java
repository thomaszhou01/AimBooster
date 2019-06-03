import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{
	
	public int radius;

	
	public static int MENULENGTH;
	public static int MENUWIDTH;

	
	public MainMenu() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(100, 100, 800, 800);
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	
	
	public void actionPerformed(ActionEvent e) {
	}
}
