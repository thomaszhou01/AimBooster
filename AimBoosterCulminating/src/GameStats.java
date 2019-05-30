import java.awt.*;
import javax.swing.*;


public class GameStats extends JPanel{
	
	private Game game;
	
	public GameStats() {
		game = new Game();
		
		this.setBackground(Color.lightGray);
		this.setBounds(50, 50, game.jPanelLength, 50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Accuracy: "+game.hitPercent()+"%", 50, 20);
		g.drawString("Targets Hit "+game.getHits()+"/"+game.getClicks(), 200, 20);
		g.drawString("Lives: "+game.getLives(), 350, 20);


	}
}
