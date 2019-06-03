import java.awt.*;
import javax.swing.*;


public class GameStats extends JPanel{
	
	private Game game;
	private double hitPercent;
	private int hits;
	private int clicks;
	private int lives;
	
	public GameStats() {
		game = new Game();
		
		this.setBackground(Color.lightGray);
		setDoubleBuffered(true);
		this.setBounds(50, 50, game.jPanelLength, 50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Times", Font.PLAIN, 20));
		//displays the stats of current game
		g.drawString("Accuracy: "+hitPercent+"%", 50, 30);
		g.drawString("Targets Hit "+hits+"/"+clicks, 250, 30);
		g.drawString("Lives: "+lives, 450, 30);


	}
	
	public void getHitPercent(double hitPer) {
		hitPercent = hitPer;
	}
	
	public void getHits(int newHits) {
		hits = newHits;
	}
	
	public void getClicks(int newClicks) {
		clicks = newClicks;
	}
	
	public void getLives(int newLives) {
		lives = newLives;
	}
	
}
