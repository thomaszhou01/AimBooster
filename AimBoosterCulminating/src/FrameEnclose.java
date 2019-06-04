import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class FrameEnclose extends JFrame implements ActionListener{
	MainMenu menu;
    Game game;
    GameStats stats;
    PostGame post;
    
    JButton b1, b2;
    ImageLabel logo, text;
    Container c = getContentPane();

    public FrameEnclose(String a) {
        super(a);
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        game = new Game();
        stats = new GameStats();
        post = new PostGame();
        
        //buttons 
        b1 = new JButton("Options");
        b1.setBounds(150, 600, 300, 75);
        b1.setBackground(Color.orange);
        b1.addActionListener(this);
        c.add(b1);
        b2 = new JButton("Start");
        b2.setBounds(550, 600, 300, 75);
        b2.setBackground(Color.orange);
        b2.addActionListener(this);
        c.add(b2);

        //top menu bar
        //from https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
        JMenuBar jmb = new JMenuBar();

        //file menubar with its items
        JMenu jmFile = new JMenu("File");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiClose = new JMenuItem("Close");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);
        
        
        //help menubar with items
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        //calling all buttons with actionListener
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);
        
        //from http://www.java2s.com/Code/JavaAPI/javax.swing/JLabelsetIconIconicon.htm
        logo = new ImageLabel(new ImageIcon("src/Images/logo.png"));
        logo.setLocation(136, 40);
        text = new ImageLabel(new ImageIcon("src/Images/text.png"));
        text.setLocation(356, 60);
        this.add(logo);
        this.add(text);
        
        //add menubar
        this.setJMenuBar(jmb);
    }

    //assigning button functions
    public void actionPerformed(ActionEvent e) {
    	
    	//determines what menubar and buttons do
        if(e.getActionCommand().equals("Exit")) {
        	System.exit(1);
        }
        else if(e.getActionCommand().equals("Open") || e.getActionCommand().equals("Start")) {
        	c.remove(b1);
        	c.remove(b2);
        	game.resetGame();
        	c.add(game);
        	c.add(stats);
			c.remove(post);
			post.reset();
        	this.remove(logo);
        	this.remove(text);
        }
        else if(e.getActionCommand().equals("Close")) {
        	c.add(b1);
        	c.add(b2);
        	this.add(logo);
        	this.add(text);
        	c.remove(game);
        	c.remove(stats);
        	c.remove(post);

        }
    }
    
    //paint graphics
    public void paint(Graphics g) {
		super.paint(g);
		
		//get stats for the game bar
		stats.getHitPercent(game.hitPercent());
		stats.getHits(game.getHits());
		stats.getClicks(game.getClicks());
		stats.getLives(game.getLives());
		
		//stops game if player lives is 0
		if(game.getLives() == 0) {
			c.add(post);
			c.remove(game);
        	c.remove(stats);
        	
        	post.getHitPercent(game.hitPercent());
        	post.getHits(game.getHits());
        	post.getClicks(game.getClicks());
		}
		
		//replays game if use clicks button
		if(post.getPlayAgain()) {
			game.resetGame();
			c.remove(post);
			c.add(game);
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
		
		repaint();
	}
    
}

//from http://www.java2s.com/Code/JavaAPI/javax.swing/JLabelsetIconIconicon.htm
class ImageLabel extends JLabel {

	  public ImageLabel(String img) {
	    this(new ImageIcon(img));
	  }

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