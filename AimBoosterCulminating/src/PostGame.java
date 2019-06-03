import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PostGame extends JPanel implements ActionListener{
	
	private JButton again, quit;
	private JTextArea finalScore, accuracy, hit;	
	private Image image;
	private Game game;
	
	private double hitPercent;
	private int hits;
	private int clicks;
	
	public boolean playAgain, mainMenu;

	public PostGame() {
		
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		game = new Game();
		
		
		this.add(createText(finalScore, "Final Scores", new Font("Times", Font.BOLD, 50), 150, 20, 300, 80));
		this.add(createText(accuracy, "Accuracy:", new Font("Times", Font.ITALIC, 30), 50, 120, 150, 50));
		this.add(createText(hit, "Targets hit:", new Font("Times", Font.ITALIC, 30), 50, 220, 170, 50));
		
		//buttons on bottom
		again = new JButton("Play Again");
		again.setBounds(75, 500, 200, 50);
		again.setBackground(Color.orange);
		again.addActionListener(this);
        this.add(again);
        
        quit = new JButton("Main Menu");
        quit.setBounds(325, 500, 200, 50);
        quit.setBackground(Color.orange);
        quit.addActionListener(this);
        this.add(quit);
        
        
		image = new ImageIcon("src/Images/target.png").getImage();

        //bounds on frame
		setDoubleBuffered(true);
		this.setBounds(200, 75, 600, 600);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Times", Font.PLAIN, 30));
		
		g.drawImage(image, 300, 300, 100, 100, this);
		g.drawString(hitPercent+"", 200, 152);
		g.drawString(hits+"/"+clicks, 220, 250);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play Again")) {
			playAgain = true;
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			mainMenu = true;
		}
		
	}
	
	//creating textAreas
	public JTextArea createText(JTextArea a, String name, Font newFont, int boundX, int boundY, int x, int y) {
		a = new JTextArea(name);
		a.setFont(newFont);
		a.setBounds(boundX, boundY, x, y);
		a.setBackground(Color.lightGray);
		return a;
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
	
	public boolean getPlayAgain() {
		return playAgain;
	}
	
	public boolean getMain() {
		return mainMenu;
	}
	
	public void reset() {
		playAgain = false;
		mainMenu = false;
	}
}
