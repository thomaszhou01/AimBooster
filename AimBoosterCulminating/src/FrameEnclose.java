import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameEnclose extends JFrame implements ActionListener{
    static MainMenu menu;
    static Game game;
    
    JButton b1, b2;
    Container c = getContentPane();

    public FrameEnclose(String a) {
        super(a);
        c.setLayout(null);
        c.setBackground(Color.gray);
        game = new Game();
        
        //buttons 
        b1 = new JButton("Stuff");
        b1.setBounds(150, 400, 300, 100);
        b1.setBackground(Color.yellow);
        b2 = new JButton("Start");
        b2.setBounds(500, 400, 300, 100);
        b2.setBackground(Color.yellow);
        b1.addActionListener(this);
        b2.addActionListener(this);
        c.add(b1);
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

        //options menubar with its items
        JMenu jmOptions = new JMenu("Options");
        JMenu jMenu = new JMenu("A");
        JMenuItem b = new JMenuItem("B");
        JMenuItem c = new JMenuItem("C");
        JMenuItem d = new JMenuItem("D");
        jMenu.add(b);
        jMenu.add(c);
        jMenu.add(d);
        jmOptions.add(jMenu);
        
        JMenu e = new JMenu("E");
        e.add(new JMenuItem("F"));
        e.add(new JMenuItem("G"));
        jmOptions.add(e);
        jmb.add(jmOptions);

        //help menubar with items
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        //calling all buttons with actionListener
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiExit.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        jmiAbout.addActionListener(this);
        
        //add menubar
        this.setJMenuBar(jmb);
    }

    public void actionPerformed(ActionEvent e) {

    	//determines what menubar does 
        if(e.getActionCommand().equals("Exit")) {
        	System.exit(1);
        }
        else if(e.getActionCommand().equals("Open")) {
        	c.remove(b1);
        	c.remove(b2);
        	c.add(game);
        }
        else if(e.getActionCommand().equals("Close")) {
        	c.add(b1);
        	c.add(b2);
        	game.resetGame();
        	c.remove(game);
        }
        else if(e.getActionCommand().equals("Start")) {
        	c.remove(b1);
        	c.remove(b2);
        	game.resetGame();
        	c.add(game);
        }
    }
    
    public void paint(Graphics g) {
		super.paint(g);
		if(game.getLives() == 0) {
			c.remove(game);
		}
		repaint();
	}
    
}