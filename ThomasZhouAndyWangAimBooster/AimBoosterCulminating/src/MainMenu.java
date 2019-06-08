import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{
	
	private JComboBox c = new JComboBox();
	private String[] options = { "1", "2", "3","4"};
	
	public static int MENULENGTH;
	public static int MENUWIDTH;
	JApplet app = new JApplet();
	
	public MainMenu() {
		super();
		this.setLayout(null);
		
		for (int i = 0; i < 4; i++)
		    c.addItem(options[i]);
		app.add(c);
		
		this.add(app);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(100, 50, 800, 650);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	
	
	public void actionPerformed(ActionEvent e) {
	}
}
