import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PostGame extends JPanel implements ActionListener{
	
	private JButton again, quit;
	private JTextArea finalScore, accuracy, hit;	
	private Image image;
	private Game game;
	
	public boolean playAgain, mainMenu;

	public PostGame() {
		
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		game = new Game();
		
		finalScore = new JTextArea("Final Scores");
		finalScore.setFont(new Font("Times", Font.BOLD, 50));
		finalScore.setBounds(150, 20, 300, 80);
		finalScore.setBackground(Color.lightGray);
		this.add(finalScore);
		
		accuracy = new JTextArea("Accuracy:");
		accuracy.setFont(new Font("Times", Font.ITALIC, 30));
		accuracy.setBounds(50, 120, 150, 50);
		accuracy.setBackground(Color.lightGray);
		this.add(accuracy);
		
		hit = new JTextArea("Targets hit:");
		hit.setFont(new Font("Times", Font.ITALIC, 30));
		hit.setBounds(50, 220, 150, 50);
		hit.setBackground(Color.lightGray);
		this.add(hit);
		
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
		g.drawString(game.hitPercent()+"%", 200, 152);
		g.drawString(game.getHits()+"/"+game.getClicks(), 220, 250);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play Again")) {
			playAgain = true;
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			mainMenu = true;
		}
		
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
