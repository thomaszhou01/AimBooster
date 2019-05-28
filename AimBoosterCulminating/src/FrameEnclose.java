import java.awt.*;
import javax.swing.*;


public class FrameEnclose extends JFrame{
	
	Game game;
	Container c = getContentPane();

	
	public FrameEnclose(String a){
		super(a);
		c.setBackground(Color.gray);
		c.setLayout(null);
		game = new Game();
		c.add(game);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(game.getLives() == 0) {
			c.remove(game);
		}
		repaint();
	}
	
}
