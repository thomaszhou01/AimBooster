// Thomas Zhou, Andy Wang
// June 10, 2019
// Main for aimbooster game
// ICS3U7 Mr. Anthony

import javax.swing.*;

public class AimBooster {
	
	//main
	public static void main(String[] args) {
		FrameEnclose frame = new FrameEnclose("Aim Booster");
		frame.setSize(1000, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
