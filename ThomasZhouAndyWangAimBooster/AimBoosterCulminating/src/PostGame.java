// Thomas Zhou, Andy Wang
// June 10, 2019
// Post game window after game. Displays stats 
// ICS3U7 Mr. Anthony

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PostGame extends JPanel implements ActionListener{
	
	private JButton again, quit;
	private JTextArea finalScore, accuracy, hit, inText, midText, outText, achieve;	
	
	private double hitPercent;
	private int hits;
	private int clicks;
	private int inner;
	private int middle;
	private int outer;
	private int achievement;
	
	private Image bronze, silver, gold, max, perfect;
	public boolean playAgain, mainMenu;

	//constructor
	public PostGame() {
		//set panel settings
		this.setLayout(null);		
		
		//create text 
		this.add(createText(finalScore, "Final Scores", new Font("Times", Font.BOLD, 50), 150, 20, 300, 80));
		this.add(createText(accuracy, "Accuracy:", new Font("Times", Font.ITALIC, 30), 50, 100, 150, 50));
		this.add(createText(hit, "Targets hit:", new Font("Times", Font.ITALIC, 30), 50, 170, 170, 50));
		this.add(createText(inText, "Inner hit:", new Font("Times", Font.ITALIC, 30), 50, 240, 170, 50));
		this.add(createText(midText, "Middle hit:", new Font("Times", Font.ITALIC, 30), 50, 310, 170, 50));
		this.add(createText(outText, "Outer hit:", new Font("Times", Font.ITALIC, 30), 50, 380, 170, 50));
		this.add(createText(achieve, "Achievements:", new Font("Times", Font.ITALIC, 30), 360, 100, 200, 50));

		
		//play again button
		again = new JButton("Play Again");
		again.setBounds(75, 500, 200, 50);
		again.setBackground(Color.orange);
		again.addActionListener(this);
        this.add(again);
        
        //main menu button
        quit = new JButton("Main Menu");
        quit.setBounds(325, 500, 200, 50);
        quit.setBackground(Color.orange);
        quit.addActionListener(this);
        this.add(quit);
        
        
		bronze = new ImageIcon("src/Images/medal4.png").getImage();
		silver = new ImageIcon("src/Images/medal3.png").getImage();
		gold = new ImageIcon("src/Images/medal2.png").getImage();
		max = new ImageIcon("src/Images/medal1.png").getImage();
		perfect = new ImageIcon("src/Images/perfect.png").getImage();

        
        //frame settings
		setDoubleBuffered(true);
		this.setBackground(Color.lightGray);
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.black));
		this.setBounds(200, 75, 600, 600);

	}
	
	/* method paintComponent()
	 * called automatically and creates stats for post game
	 * pre: class extends JPanel
	 * post: draws text
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Times", Font.PLAIN, 30));
		
		//draw the stats
		g.drawString(hitPercent+"%", 220, 132);
		g.drawString(hits+"/"+clicks, 220, 201);
		g.drawString(inner+"/"+hits, 220, 271);
		g.drawString(middle+"/"+hits, 220, 341);
		g.drawString(outer+"/"+hits, 220, 411);
		
		//displays the achievement
		switch(achievement) {
		case 1:
			g.drawImage(bronze, 410, 160, 100, 100, this);
			break;
		case 2:
			g.drawImage(silver, 395, 160, 120, 100, this);
			break;
		case 3:
			g.drawImage(gold, 410, 160, 100, 100, this);
			break;
		case 4:
			g.drawImage(max, 395, 160, 110, 100, this);
			break;
		}
		
		//add perfect score medal
		if(hitPercent==100) {
			g.drawImage(perfect, 360, 270, 200, 180, this);
		}

	}
	
	/* method actionPerformed()
	 * automatically called by ActionPerformed
	 * pre: an element with actionListener is used 
	 * post: changes variable values
	 */
	public void actionPerformed(ActionEvent e) {
		//enable buttons 
		if(e.getActionCommand().equals("Play Again")) {
			playAgain = true;
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			mainMenu = true;
		}
		
	}
	
	/* method JTextArea()
	 * called main and creates text
	 * pre: JText area name, string text to be displayed, font, int x and y boundary, int x and y location
	 * post: text will be created
	 */
	public JTextArea createText(JTextArea a, String name, Font newFont, int boundX, int boundY, int x, int y) {
		a = new JTextArea(name);
		a.setFont(newFont);
		a.setBounds(boundX, boundY, x, y);
		a.setBackground(Color.lightGray);
		return a;
	}
	
	/* method getHitPercent()
	 * assigns hitPercent a value
	 * pre: called by class
	 * post: hitPercent is set a value
	 */
	public void getHitPercent(double hitPer) {
		hitPercent = hitPer;
	}
	
	/* method getHits()
	 * assigns hits a new value
	 * pre: called by class
	 * post: hits is set a value
	 */
	public void getHits(int newHits) {
		hits = newHits;
		
		//set achievement number
		if(hits >=25 && hits<50) {
			achievement = 1;
		}
		else if(hits >=50 && hits<100) {
			achievement = 2;
		}
		else if(hits >=100 && hits<200) {
			achievement = 3;
		}
		else if(hits > 200) {
			achievement = 4;
		}
	}
	
	/* method getClicks()
	 * assigns clicks a value
	 * pre: called by class
	 * post: clicks is set a value
	 */
	public void getClicks(int newClicks) {
		clicks = newClicks;
	}

	/* method getInner()
	 * assigns inner a value
	 * pre: called by class
	 * post: inner is set a value
	 */
	public void getInner(int newIn) {
		inner = newIn;
	}
	
	/* method getMiddle()
	 * assigns middle a value
	 * pre: called by class
	 * post: middle is set a value
	 */
	public void getMiddle(int newMid) {
		middle = newMid;
	}
	
	/* method getOuter()
	 * assigns outer a value
	 * pre: called by class
	 * post: outer is set a value
	 */
	public void getOuter(int newOut) {
		outer = newOut;
	}
	
	/* method getPlayAgain()
	 * returns boolean playAgain
	 * pre: called by class
	 * post: playAgain returned
	 */
	public boolean getPlayAgain() {
		return playAgain;
	}
	
	/* method getMain()
	 * returns boolean mainMenu
	 * pre: called by class
	 * post: mainMenu returned
	 */
	public boolean getMain() {
		return mainMenu;
	}
	
	/* method reset()
	 * resets variables
	 * pre: called by class
	 * post: variables reset
	 */
	public void reset() {
		playAgain = false;
		mainMenu = false;
		achievement = 0;
	}
}
