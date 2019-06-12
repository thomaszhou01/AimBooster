// Thomas Zhou, Andy Wang
// June 10, 2019
// Stat bar at the top of the game. Displays stats realtime
// ICS3U7 Mr. Anthony

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
	
	//constructor
	public GameStats() {
		game = new Game();
		
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.black));
		this.setBackground(Color.lightGray);
		setDoubleBuffered(true);
		this.setBounds(50, 50, game.jPanelLength, 50);
	}
	
	/* method paintComponent()
	 * called automatically and paints the stats of game
	 * pre: class extends JPanel
	 * post: draws the stats of the game
	 */
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
	
	/* method getHits()
	 * gets number of target hits
	 * pre: int number of newHits
	 * post: hits is assigned an int value
	 */
	public void getHits(int newHits) {
		hits = newHits;
	}
	
	/* method getClicks()
	 * gets number of clicks
	 * pre: int number of newClicks
	 * post: clicks is assigned an int value
	 */
	public void getClicks(int newClicks) {
		clicks = newClicks;
	}
	
	/* method getLives()
	 * gets number of lives
	 * pre: int number of newLives
	 * post: lives is assigned an int value
	 */
	public void getLives(int newLives) {
		lives = newLives;
	}
	
	/* method getInner()
	 * gets number of hits in center of target
	 * pre: int number of center hits
	 * post: inner is assigned an int value
	 */
	public void getInner(int newIn) {
		inner = newIn;
	}
	
	/* method getMiddle()
	 * gets number of hits in middle area of target
	 * pre: int number of middle area hits
	 * post: outer is assigned an int value
	 */
	public void getMiddle(int newMid) {
		middle = newMid;
	}
	
	/* method getOuter()
	 * gets number of hits in outer area
	 * pre: int number of outer area hits
	 * post: outer is assigned an int value
	 */
	public void getOuter(int newOut) {
		outer = newOut;
	}
}
