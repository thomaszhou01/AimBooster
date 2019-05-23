import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FrameEnclose extends JFrame{
	
	static MainMenu menu;
	
	public FrameEnclose(String a){
		super(a);
		Container c = getContentPane();
		menu = new MainMenu();
		c.add(menu);
	}
	
	
}
