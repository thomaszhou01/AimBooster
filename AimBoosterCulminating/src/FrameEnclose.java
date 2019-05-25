import java.awt.*;
import javax.swing.*;


public class FrameEnclose extends JFrame{
	
	Game menu;
	
	public FrameEnclose(String a){
		super(a);
		Container c = getContentPane();
		c.setBackground(Color.gray);
		c.setLayout(null);
		menu = new Game();
		c.add(menu);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		repaint();
	}
}
