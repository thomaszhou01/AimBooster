// Thomas Zhou, Andy Wang
// June 10, 2019
// Game class for aimbooster
// ICS3U7 Mr. Anthony

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
	public static int speed;
	public static double hitPercent;

	public int maxLives = 5;
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
        speed = 50;
        clicked = false;
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
		
		//set panel settings
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.black));
        this.setBounds(50, 100, jPanelLength,jPanelHeight);
	}
	
	/* method paintComponent()
	 * called automatically and paints graphics
	 * pre: class extends JPanel
	 * post: draws the background of the game. Delays every frame by 10 milliseconds
	 */
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
		
		//gets hit percentage
		hitPercent();

	}
	
	/* method randomCircle()
	 * called by children of Game. Sets location of circles
	 * pre: called by children of Game
	 * post: creates new target object and assigns random x and y values to new object. adds target to targets arraylist
	 */
	public void randomCircle(int x) {

		//from https://stackoverflow.com/questions/32534601/java-getting-a-random-number-from-100-to-999
		int randX = random.nextInt(jPanelLength);
		int randY = random.nextInt(jPanelHeight);
        targets.add(new Target(randX, randY, x));
		
	}
	
	/* method removeCircle()
	 * called by children of Game. removes circles from array and removes lives
	 * pre: called by children of Game
	 * post: element of array removed. lives lowered
	 */
	public void removeCircle(int i) {
		//removes circle if its 0
		if(targets.get(i).getDiameter()<=0) {
			targets.remove(i);
			lives--;
			play("src/Sounds/miss.wav");
		}
	}
	
	/* method hitPercent()
	 * called paintComponent and calculates hit percentage
	 * pre: called in paintComponent
	 * post: hitPercent is calculated 
	 */
	public void hitPercent() {
		//displays hit percent
		hitPercent = Math.round((hits/(double)clicks)*1000.0)/10.0;
	}
	
	/* method getHitPercent()
	 * returns hitPercent
	 * pre: called by class
	 * post: returns double hitPercent
	 */
	public double getHitPercent() {
		return hitPercent;
	}
	
	/* method getLives()
	 * returns lives
	 * pre: called by class
	 * post: returns int lives
	 */
	public int getLives() {
		return lives;
	}
	
	/* method getHits()
	 * returns hits
	 * pre: called by class
	 * post: returns int hits
	 */
	public int getHits() {
		return hits;
	}
	
	/* method getClicks()
	 * returns clicks
	 * pre: called by class
	 * post: returns int clicks
	 */
	public int getClicks() {
		return clicks;
	}
	
	/* method getInner()
	 * returns number of hits in center of target
	 * pre: called by class
	 * post: returns int inner
	 */
	public int getInner() {
		return inner;
	}
	
	/* method getMiddle()
	 * returns number of hits in middle ring of target
	 * pre: called by class
	 * post: returns int middle
	 */
	public int getMiddle() {
		return middle;
	}
	
	/* method getOuter()
	 * returns number of hits in outer ring of target
	 * pre: called by class
	 * post: returns int outer
	 */
	public int getOuter() {
		return outer;
	}
	
	/* method setLives()
	 * changes number of lives
	 * pre: int lives
	 * post: changes maxlives and sets lives
	 */
	public void setLives(int life) {
		maxLives = life;
		lives = maxLives;
	}
	
	/* method setSpeed()
	 * sets speed of target generation
	 * pre: int speeed
	 * post: speed changes
	 */
	public void setSpeed(int speeed) {
		speed = speeed;
	}
	
	/* method resetGame()
	 * resets variables
	 * pre: called by class
	 * post: resets all variables to defaults
	 */
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
	
	/* method play()
	 * plays music
	 * pre: string file location
	 * post: music played
	 */
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
