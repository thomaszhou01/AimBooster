import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class FrameEnclose extends JFrame implements ActionListener{
    static MainMenu menu;
    static JTextField textfield1, textfield2, textfield3, textArea;
    
    Container c = getContentPane();

    public FrameEnclose(String a) {
        super(a);
        c.setLayout(null);

        JButton b1 = new JButton("idk what to put here");
        b1.setBounds(150, 400, 300, 100);
        b1.setBackground(Color.yellow);
        JButton b2 = new JButton("Start");
        b2.setBounds(500, 400, 300, 100);
        b2.setBackground(Color.yellow);
        c.add(b1);
        c.add(b2);

        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("File");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiClose = new JMenuItem("Close");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        JMenu jmOptions = new JMenu("Options");
        JMenu jMenu = new JMenu("A");
        JMenuItem b = new JMenuItem("B");
        JMenuItem c = new JMenuItem("C");
        JMenuItem d = new JMenuItem("D");
        jMenu.add(b);
        jMenu.add(c);
        jMenu.add(d);
        jmOptions.add(a);

        JMenu e = new JMenu("E");
        e.add(new JMenuItem("F"));
        e.add(new JMenuItem("G"));
        jmOptions.add(e);

        jmb.add(jmOptions);

        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiExit.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        jmiAbout.addActionListener(this);

        this.setJMenuBar(jmb);
    }

    public void actionPerformed(ActionEvent e) {

        FrameEnclose test = new FrameEnclose("Instructions");
        JTextArea textArea = new JTextArea(
            "Become the next fps GOD" +
            "CLick the head 4head 360 no scope" +
            "420 mlg amazing aim practice click targets" +
            "if they dissapear thomas very bean big"
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        test.setSize(1000, 1000);
        test.setLocationRelativeTo(null);
        test.setResizable(false);
        test.setVisible(true);
        this.add(textArea);
        
        String comStr = e.getActionCommand();
    }

}