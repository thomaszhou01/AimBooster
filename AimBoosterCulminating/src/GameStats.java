import java.awt.*;
import javax.swing.*;


public class GameStats extends JPanel{
	
	private Game game;
	private int hits;
	private int clicks;
	private int lives;
	private int inner;
	private int middle;
	private int outer;
	
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
		g.drawString("Lives: "+lives, 50, 30);
		g.drawString("Targets Hit "+hits+"/"+clicks, 180, 30);
		g.drawString("Inner Hit: "+inner+"/"+hits, 370, 30);
		g.drawString("Middle Hit: "+middle+"/"+hits, 550, 30);
		g.drawString("Outer Hit: "+outer+"/"+hits, 730, 30);

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
	
	public void getInner(int newIn) {
		inner = newIn;
	}
	public void getMiddle(int newMid) {
		middle = newMid;
	}
	public void getOuter(int newOut) {
		outer = newOut;
	}
}
