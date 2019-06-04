import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel implements ActionListener{
	
	public int radius;
	public int jPanelLength;
	public int jPanelHeight;
	private int xValue;
	private int yValue;
	private int count;
	private final int maxLives;
	private int clicks;
	private int hits;
	private int lives;
	private double hitPercent;

	private ArrayList<Target> targets = new ArrayList<Target>();
	private Random random = new Random();
	private static Image back;

	
	//constructor
	public Game() {
		super();
		//assign default values
		jPanelLength = 900;
		jPanelHeight = 600;

        count = 0;
        clicks = 0;
        hits = 0;
        maxLives = 3;
        lives = maxLives;

        back = new ImageIcon("src/Images/gameBack.png").getImage();
        //add mouse listener
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
				//from https://stackoverflow.com/questions/3383887/how-to-record-the-number-of-mouse-clicks
				clicks++;
			}
		});	
		setDoubleBuffered(true);
        this.setBounds(50, 100, jPanelLength,jPanelHeight);
	}
	
	//paintcomponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, this);
		
		//count to determine when to add circle
		count++;
		//adds only one circle
		if(count%75 == 0) {
			randomCircle();
		}
		
		//creates target if there are elements in array
		if(targets.size()>0) {
			//creates targets
			for(int i = 0; i<targets.size(); i++) {
				targets.get(i).circleSize();
				
				//from https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
				g.drawImage(targets.get(i).getImage(), (int)targets.get(i).getLocX(), (int)targets.get(i).getLocY(), (int)targets.get(i).getDiameter(), (int)targets.get(i).getDiameter(), this);
				targets.get(i).setMouseLoc(xValue, yValue);
				
				//removes circles
				removeCircle(i);	
			}
			
			//removes hit circles
			for(int i = targets.size()-1; i>=0 ; i--) {
				if(targets.size()>0 && targets.get(i).insideCircle()) {
					play("src/Sounds/pop.wav");
					xValue = -100;
					yValue = -100;
					targets.remove(i);
					hits++;
					break;
				}
			}
			
			xValue = -100;
			yValue = -100;
		}		
		//keep framerate constant 
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	//create random circles
	public void randomCircle() {

		//from https://stackoverflow.com/questions/32534601/java-getting-a-random-number-from-100-to-999
		int randX = random.nextInt(jPanelLength);
		int randY = random.nextInt(jPanelHeight);
        targets.add(new Target(randX, randY));
		
	}
	
	public void removeCircle(int i) {
		//removes circle if its 0
		if(targets.get(i).getDiameter()==0) {
			targets.remove(i);
			lives--;
			play("src/Sounds/miss.wav");
		}
	}
	
	public double hitPercent() {
		//displays hit percent
		hitPercent = Math.round((hits/(double)clicks)*1000.0)/10.0;
		return hitPercent;
	}
	
	public int getLives() {
		return lives;
	}
	
	public int getHits() {
		return hits;
	}
	
	public int getClicks() {
		return clicks;
	}
	
	public void resetGame() {
		//resets game
		count = 0;
        clicks = 0;
        hits = 0;
        lives = maxLives;
        targets.clear();
	}
	
	//from https://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
	public static void play(String fileLoc) {
		try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(fileLoc)));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}
