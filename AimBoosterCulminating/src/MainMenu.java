import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{

    private JComboBox jb, jb1, jb2, jb3;
    private JTextArea options, textLives, textSpeed, textGen, textSize;
    private String[] lives = {"1","3","5","10"};
    private String[] speed = {"Slow","Moderate","Fast"};
    private String[] genSpeed = {"Slow","Moderate","Fast"};
    private String[] targetSize = {"Small","Medium","Large"};
    private JButton again, quit, set;
	private static Image image;
	
	private boolean play;
	private boolean main;
	private boolean settings;
	private int life;
	private int imgSize;
	private int gameSpeed;
	private int speedGen;

    
	public MainMenu() {
		super();
		this.setLayout(null);
		
		//makes combo boxes
		setJComboBox();
		
		//text create
		this.add(createText(options, "Game Options", new Font("Times", Font.BOLD, 50), 240, 20, 350, 80));
		this.add(createText(textLives, "Set Lives:", new Font("Times", Font.ITALIC, 30), 50, 120, 150, 50));
		this.add(createText(textSpeed, "Set Generate Speed:", new Font("Times", Font.ITALIC, 30), 50, 220, 300, 50));
		this.add(createText(textGen, "Set Expand Speed:", new Font("Times", Font.ITALIC, 30), 50, 320, 300, 50));
		this.add(createText(textSize, "Set Target Size:", new Font("Times", Font.ITALIC, 30), 50, 420, 220, 50));

		//Play again button
		again = new JButton("Play Again");
		again.setBounds(350, 550, 200, 50);
		again.setBackground(Color.orange);
		again.addActionListener(this);
        this.add(again);
        
        //main menu button
        quit = new JButton("Main Menu");
        quit.setBounds(550, 550, 200, 50);
        quit.setBackground(Color.orange);
        quit.addActionListener(this);
        this.add(quit);
        
        //set settings button
        set = new JButton("Set Settings");
        set.setBounds(50, 550, 200, 50);
        set.setBackground(Color.orange);
        set.addActionListener(this);
        this.add(set);
        
        //set variables
		image = new ImageIcon("src/Images/target.png").getImage();
		life = 3;
		imgSize = 100;
		gameSpeed = 50;
		speedGen = 2;
		
		//set jPanel information
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(100, 50, 800, 650);
	}
	
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
        
        //set bounds and actionListener
        jb.setBounds(400, 120, 100, 40); 
        jb1.setBounds(400, 220, 100, 40); 
        jb2.setBounds(400, 320, 100, 40); 
        jb3.setBounds(400, 420, 100, 40); 
        
        jb.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
       
    }
	
	public JTextArea createText(JTextArea a, String name, Font newFont, int boundX, int boundY, int x, int y) {
		a = new JTextArea(name);
		a.setFont(newFont);
		a.setBounds(boundX, boundY, x, y);
		a.setBackground(Color.lightGray);
		return a;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 650-imgSize/2, 270-imgSize/2, imgSize, imgSize, this);
	}
	
	public void reset() {
		play = false;
		main = false;
	}
	
	public int getSpeed() {
		return gameSpeed;
	}
	
	public int getGen() {
		return speedGen;
	}
	
	public int getTargetSize() {
		return imgSize;
	}
	
	public int getLife() {
		return life;
	}
	
	public boolean getPlay() {
		return play;
	}
	
	public boolean getMain() {
		return main;
	}
	
	public void actionPerformed(ActionEvent e) {
		String lives = (String) jb.getSelectedItem();
		String speed = (String) jb1.getSelectedItem();
		String genSpeed = (String) jb2.getSelectedItem();
		String size = (String) jb3.getSelectedItem();
		
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
		

		//buttons
		if(e.getActionCommand().equals("Play Again")) {
			play = true;
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			main = true;
		}
		else if(e.getActionCommand().equals("Set Settings")) {
			
		}	
	}
}
