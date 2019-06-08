import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel{
	
	public int jPanelLength;
	public int jPanelHeight;
	public int xValue;
	public int yValue;
	public boolean clicked;
	public static int count;
	public static int clicks;
	public static int hits;
	public static int lives;
	
	public static int inner;
	public static int middle;
	public static int outer;

	
	public static double hitPercent;

	public final int maxLives;
	public static ArrayList<Target> targets = new ArrayList<Target>();
	public Random random = new Random();
	public static Image back;

	
	//constructor
	public Game() {
		super();
		//assign default values
		jPanelLength = 900;
		jPanelHeight = 600;

        count = 0;
        clicks = 0;
        hits = 0;
        clicked = false;
        maxLives = 5;
        lives = maxLives;

        back = new ImageIcon("src/Images/gameBack.png").getImage();
        //add mouse listener
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
				//from https://stackoverflow.com/questions/3383887/how-to-record-the-number-of-mouse-clicks
				clicks++;
				clicked = true;

			}
		});	
        this.setBounds(50, 100, jPanelLength,jPanelHeight);
	}
	
	//paintcomponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, this);
		
		//keep framerate constant 
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch blocka
			e.printStackTrace();
		}
		hitPercent();

	}
	
	
	//create random circles
	public void randomCircle(int x) {

		//from https://stackoverflow.com/questions/32534601/java-getting-a-random-number-from-100-to-999
		int randX = random.nextInt(jPanelLength);
		int randY = random.nextInt(jPanelHeight);
        targets.add(new Target(randX, randY, x));
		
	}
	
	public void removeCircle(int i) {
		//removes circle if its 0
		if(targets.get(i).getDiameter()==0) {
			targets.remove(i);
			lives--;
			play("src/Sounds/miss.wav");
		}
	}
	
	public void hitPercent() {
		//displays hit percent
		hitPercent = Math.round((hits/(double)clicks)*1000.0)/10.0;
	}
	
	public double getHitPercent() {
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
	
	public int getInner() {
		return inner;
	}
	
	public int getMiddle() {
		return middle;
	}
	
	public int getOuter() {
		return outer;
	}
	
	public void resetGame() {
		//resets game
		count = 0;
        clicks = 0;
        hits = 0;
        inner = 0;
        middle = 0;
        outer = 0;
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
}
