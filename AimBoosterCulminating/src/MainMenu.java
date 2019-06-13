// Thomas Zhou, Andy Wang
// June 10, 2019
// Options menu for the game. Users can choose to change size, expand speed, lives, and generation speed here
// ICS3U7 Mr. Anthony

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener{

    private JComboBox jb, jb1, jb2, jb3, jb4;
    private JTextArea options, textLives, textSpeed, textGen, textSize;
    private String[] lives = {"1","3","5","10"};
    private String[] speed = {"Slow","Moderate","Fast"};
    private String[] genSpeed = {"Slow","Moderate","Fast"};
    private String[] targetSize = {"Small","Medium","Large"};
    private String[] gameMode = {"Normal","Flick"};
    private JButton again, quit;
	private static Image image;
	
	private boolean play;
	private boolean main;
	private int life;
	private int imgSize;
	private int gameSpeed;
	private int speedGen;
	private int mode;

    //constructor
	public MainMenu() {
		super();
		this.setLayout(null);
		
		//makes combo boxes
		setJComboBox();
		
		//text create
		this.add(createText(options, "Game Options", new Font("Times", Font.BOLD, 50), 240, 20, 350, 80));
		this.add(createText(textLives, "Set Lives:", new Font("Times", Font.ITALIC, 30), 50, 100, 150, 50));
		this.add(createText(textSpeed, "Set Generate Speed:", new Font("Times", Font.ITALIC, 30), 50, 180, 300, 50));
		this.add(createText(textGen, "Set Expand Speed:", new Font("Times", Font.ITALIC, 30), 50, 260, 300, 50));
		this.add(createText(textSize, "Set Target Size:", new Font("Times", Font.ITALIC, 30), 50, 340, 220, 50));
		this.add(createText(textSize, "Set Game Mode:", new Font("Times", Font.ITALIC, 30), 50, 420, 250, 50));

		
		//Play again button
		again = new JButton("Play");
		again.setBounds(150, 550, 200, 50);
		again.setBackground(Color.orange);
		again.addActionListener(this);
        this.add(again);
        
        //main menu button
        quit = new JButton("Main Menu");
        quit.setBounds(450, 550, 200, 50);
        quit.setBackground(Color.orange);
        quit.addActionListener(this);
        this.add(quit);
        
        //set variables
		image = new ImageIcon("src/Images/target.png").getImage();
		//defaults for game
		life = 3;
		imgSize = 100;
		gameSpeed = 50;
		speedGen = 2;
		
		//set panel information
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.black));
		this.setBounds(100, 50, 800, 650);
	}
	
	/* method setJComboBox()
	 * called in constructor creates the comboBoxes
	 * pre: called in main
	 * post: combo boxes will be created
	 */
	//create boxes
	private void setJComboBox() {	
		//create boxes
		//lives box
        jb = new JComboBox(lives);
        jb.setFont(new Font("Times", Font.BOLD, 20));
        jb.setForeground(Color.RED);
        add(jb);
        
        //game speed box
        jb1 = new JComboBox(speed);
        jb1.setFont(new Font("Times", Font.BOLD, 20));
        jb1.setForeground(Color.RED);
        add(jb1);
        
        //target generate box
        jb2 = new JComboBox(genSpeed);
        jb2.setFont(new Font("Times", Font.BOLD, 20));
        jb2.setForeground(Color.RED);
        add(jb2);
        
        //target size box
        jb3 = new JComboBox(targetSize);
        jb3.setFont(new Font("Times", Font.BOLD, 20));
        jb3.setForeground(Color.RED);
        add(jb3);
        
        //target size box
        jb4 = new JComboBox(gameMode);
        jb4.setFont(new Font("Times", Font.BOLD, 20));
        jb4.setForeground(Color.RED);
        add(jb4);
        
        //set bounds and actionListener
        jb.setBounds(400, 100, 100, 40); 
        jb1.setBounds(400, 180, 100, 40); 
        jb2.setBounds(400, 260, 100, 40); 
        jb3.setBounds(400, 340, 100, 40); 
        jb4.setBounds(400, 420, 100, 40); 
        
        jb.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
       
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
	
	/* method paintComponent()
	 * called automatically and paints graphics
	 * pre: class extends JPanel
	 * post: draws the target
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 650-imgSize/2, 270-imgSize/2, imgSize, imgSize, this);
	}
	
	/* method reset()
	 * resets boolean values
	 * pre: nul
	 * post: resets variables
	 */
	public void reset() {
		play = false;
		main = false;
	}
	
	/* method getSpeed()
	 * returns speed of target generation chosen by user
	 * pre: nul
	 * post: returns int value for speed of game
	 */
	public int getSpeed() {
		return gameSpeed;
	}
	
	/* method getGen()
	 * returns target expansion rate chosen by user
	 * pre: nul
	 * post: returns int value for target expansion
	 */
	public int getGen() {
		return speedGen;
	}
	
	/* method getTargetSize()
	 * returns size of target chosen by user
	 * pre: nul
	 * post: returns int value of imgSize
	 */
	public int getTargetSize() {
		return imgSize;
	}
	
	/* method getLife()
	 * returns number of lives chosen by user
	 * pre: nul
	 * post: returns int value of lives
	 */
	public int getLife() {
		return life;
	}
	
	/* method getMode()
	 * returns gamemode
	 * pre: nul
	 * post: returns the gamemode number
	 */
	public int getMode() {
		return mode;
	}
	
	/* method getPlay()
	 * returns whether button for play has been pressed
	 * pre: nul
	 * post: returns boolean play
	 */
	public boolean getPlay() {
		return play;
	}
	
	/* method getMain()
	 * returns whether button for main has been pressed
	 * pre: nul
	 * post: returns boolean main
	 */
	public boolean getMain() {
		return main;
	}
	
	/* method actionPerformed()
	 * automatically called by ActionPerformed
	 * pre: an element with actionListener is used 
	 * post: changes variable values
	 */
	public void actionPerformed(ActionEvent e) {
		String lives = (String) jb.getSelectedItem();
		String speed = (String) jb1.getSelectedItem();
		String genSpeed = (String) jb2.getSelectedItem();
		String size = (String) jb3.getSelectedItem();
		String gmode = (String) jb4.getSelectedItem();

		
		//set lives
		life = Integer.parseInt(lives);
		
		//generate speed
		if(genSpeed.equals("Slow")) {
			speedGen = 1;
		}
		else if(genSpeed.equals("Moderate")) {
			speedGen = 2;
		}
		else if(genSpeed.equals("Fast")) {
			speedGen = 3;
		}
		
		//game speed
		if(speed.equals("Slow")) {
			gameSpeed = 70;
		}
		else if(speed.equals("Moderate")) {
			gameSpeed = 50;
		}
		else if(speed.equals("Fast")) {
			gameSpeed = 30;
		}
		
		//target size
		if(size.equals("Small")) {
			imgSize = 100;
		}
		else if(size.equals("Medium")) {
			imgSize = 150;
		}
		else if(size.equals("Large")) {
			imgSize = 200;
		}
		
		//gamemode
		if(gmode.equals("Normal")) {
			mode = 0;
		}
		else if(gmode.equals("Flick")) {
			mode = 1;
		}
		
		//buttons
		if(e.getActionCommand().equals("Play")) {
			play = true;
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			main = true;
		}
	}
}
