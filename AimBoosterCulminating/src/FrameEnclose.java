// Thomas Zhou, Andy Wang
// June 10, 2019
// JFrame that contains various panels, images and buttons for game
// ICS3U7 Mr. Anthony

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class FrameEnclose extends JFrame implements ActionListener{
	public MainMenu menu;
	public Game game;
	public GameStats stats;
	public DefaultGame game1;
	public FlickGame game2;
	public PostGame post;
	
	private Clip clip;
	private int gameNum;
	private JButton b1, b2;
	private ImageLabel logo, text;
	private Container c = getContentPane();

	//constructor
    public FrameEnclose(String a) {
    	//initializing variables and setting layout of container
        super(a);
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        menu = new MainMenu();
        game = new Game();
        game1 = new DefaultGame();
        game2 = new FlickGame();
        stats = new GameStats();
        post = new PostGame();
        gameNum = 0;
        
        //buttons: options  
        b1 = new JButton("Game Options");
        b1.setBounds(150, 600, 300, 75);
        b1.setBackground(Color.orange);
        b1.addActionListener(this);
        c.add(b1);
        //Start
        b2 = new JButton("Play");
        b2.setBounds(550, 600, 300, 75);
        b2.setBackground(Color.orange);
        b2.addActionListener(this);
        c.add(b2);

        //top menu bar
        //from https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
        JMenuBar jmb = new JMenuBar();

        //file menubar with its items
        JMenu jmFile = new JMenu("Game");
        JMenuItem jmiOpen = new JMenuItem("Play");
        JMenuItem jmiClose = new JMenuItem("Close");
        JMenuItem jmiExit = new JMenuItem("Exit");
        //adding items to bar
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        //help menubar with items
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("How to Play");
        JMenuItem jmiAchieve = new JMenuItem("Achievements");
        //adding items to bar
        jmHelp.add(jmiAbout);
        jmHelp.add(jmiAchieve);
        jmb.add(jmHelp);

        //calling all buttons with actionListener
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);
        jmiAchieve.addActionListener(this);
        
        //from http://www.java2s.com/Code/JavaAPI/javax.swing/JLabelsetIconIconicon.htm
        //Adding images
        logo = new ImageLabel(new ImageIcon("src/Images/logo.png"));
        logo.setLocation(136, 40);
        text = new ImageLabel(new ImageIcon("src/Images/text.png"));
        text.setLocation(356, 60);
        this.add(logo);
        this.add(text);
        
        //add menubar
        this.setJMenuBar(jmb);
    	play("src/Sounds/back.wav");
    }
    
    /* method actionPerformed()
	 * called automatically by ActionListener
	 * pre: an element with an ActionListener is used
	 * post: either removes/adds panels to jFrame or changes variables 
	 */
    //assigning button functions
    public void actionPerformed(ActionEvent e) {
    	
    	//determines what menubar and buttons do
        if(e.getActionCommand().equals("Exit")) {
        	System.exit(1);
        }
        //start actions: remove buttons, remove logos, add game, add stats bar, resets values
        else if(e.getActionCommand().equals("Play")) {
        	c.remove(b1);
        	c.remove(b2);
        	game.resetGame();
			Target.reset();
			post.reset();
        	c.add(stats);
        	
        	
        	//set game options
        	game.setLives(menu.getLife());
        	game.setSpeed(menu.getSpeed());
        	Target.setCircleExpand(menu.getGen());
        	Target.setMaxCircle(menu.getTargetSize());
        	gameNum = menu.getMode();

        	//setsGame
        	if(gameNum == 0) {
            	c.add(game1);
        	}
        	else if(gameNum == 1) {
        		c.add(game2);
        	}
			
        	//remove elements
			c.remove(post);
			c.remove(menu);
        	this.remove(logo);
        	this.remove(text);
        }
        //close game, close game and stats, open buttons 
        else if(e.getActionCommand().equals("Close")) {
        	c.add(b1);
        	c.add(b2);
        	this.add(logo);
        	this.add(text);
        	if(gameNum == 0) {
            	c.remove(game1);
        	}
        	else if(gameNum == 1) {
        		c.remove(game2);
        	}        	
        	
        	//reset
        	post.reset();
        	game.resetGame();
        	
        	c.remove(stats);        	
        	c.remove(post);

        }
        
        //Open Options
        else if(e.getActionCommand().equals("Game Options")) {
        	c.remove(b1);
        	c.remove(b2);		
        	this.remove(logo);
        	this.remove(text);
        	c.add(menu);
        }
        else if(e.getActionCommand().equals("How to Play")) {
        	JOptionPane.showMessageDialog(c, "Aim Booster is a game designed to improve you mouse accuracy for FPS games."
        			+ "\n- Upon hitting play, targets will randomly spawn on the playing area. "
        			+ "\n- You must click the targets before they disappear. \n- If you miss a target, a life will be taken off."
        			+ "\n- You can change the speed of target generation, the expand rate of targets, the size of the targets, and lives in the options menu.", 
        			"How to Play", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getActionCommand().equals("Achievements")) {
        	JOptionPane.showMessageDialog(c, "Every game, players are able to earn achievements."
        			+ "\n25-50 points: Bronze Medal\n50-100 points: Silver Medal\n100-200: Gold Medal"
        			+ "\n200+ points: Ultimate Medal\n100% Accuracy: Accuracy medal", "Achievement System", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    /* method paint()
	 * called automatically and paints graphics
	 * pre: class extends JFrame
	 * post: changes variables or removes/adds panels
	 */
    //paint graphics
    public void paint(Graphics g) {
		super.paint(g);
		
		//stops game if player lives is 0
		if(game.getLives() == 0) {
			c.add(post);
			//removes correct game
			if(gameNum == 0) {
            	c.remove(game1);
        	}
        	else if(gameNum == 1) {
        		c.remove(game2);
        	}
			//removes screens
			c.remove(stats);
        	//get data for post game
        	post.getHitPercent(game.getHitPercent());
        	post.getHits(game.getHits());
        	post.getClicks(game.getClicks());
        	post.getInner(game.getInner());
    		post.getMiddle(game.getMiddle());
    		post.getOuter(game.getOuter());
		}
		
		//postGame window control
		//replays game if use clicks button
		if(post.getPlayAgain()) {
			game.resetGame();
			Target.reset();
			c.remove(post);
			//opens correct game
			if(gameNum == 0) {
            	c.add(game1);
        	}
        	else if(gameNum == 1) {
        		c.add(game2);
        	}
			c.add(stats);
			post.reset();
		}
		//returns to main if player clicks button
		else if(post.getMain()) {
			game.resetGame();
			c.remove(post);
			c.add(b1);
			c.add(b2);
			post.reset();
			this.add(logo);
        	this.add(text);
			
		}
		
		//options menu control
		//play game button
		if(menu.getPlay()) {
			game.resetGame();
			Target.reset();
			c.remove(menu);
			
			//set game options
        	game.setLives(menu.getLife());
        	game.setSpeed(menu.getSpeed());
        	Target.setCircleExpand(menu.getGen());
        	Target.setMaxCircle(menu.getTargetSize());
        	gameNum = menu.getMode();
        	
        	//adds game
			if(gameNum == 0) {
            	c.add(game1);
        	}
        	else if(gameNum == 1) {
        		c.add(game2);
        	}
			c.add(stats);
			menu.reset();
		}
		//main menu
		else if (menu.getMain()) {
			c.remove(menu);
			c.add(b1);
			c.add(b2);
			this.add(logo);
			this.add(text);
			menu.reset();
		}
		
		
		//get stats for the game bar
		stats.getHits(game.getHits());
		stats.getClicks(game.getClicks());
		stats.getLives(game.getLives());
		stats.getInner(game.getInner());
		stats.getMiddle(game.getMiddle());
		stats.getOuter(game.getOuter());
		repaint();
	}
    
    /* method play()
	 * called in constructor and plays background music
	 * pre: a string filepath is given
	 * post: music will be played on loop
	 */
    public void play(String fileLoc) {
		try
	    {
			clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(fileLoc)));
	        clip.start();
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
    
    public void stopMusic() {
    	clip.stop();
    }
    
}

//from http://www.java2s.com/Code/JavaAPI/javax.swing/JLabelsetIconIconicon.htm
class ImageLabel extends JLabel {
	//constructor
	public ImageLabel(String img) {
		this(new ImageIcon(img));
	}
	  
	//constructor
	public ImageLabel(ImageIcon icon) {
		setIcon(icon);
		// setMargin(new Insets(0,0,0,0));
		setIconTextGap(0);
	    // setBorderPainted(false);
	    setBorder(null);
	    setText(null);
	    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	}

}