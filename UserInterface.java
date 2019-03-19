import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
//import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003)
 */
public class UserInterface implements ActionListener
{
    private GameEngine engine;
    private JFrame myFrame;
    private JTextField entryField;
    private JTextArea log;
    private JLabel image;
    private JButton ButtonL;
    private JButton ButtonE;    
    private JButton ButtonQ;
    private JButton ButtonH;
    private JButton help;
    private JButton RBeamer;
    private JButton ButtonR;
    private JButton ButtonA;
    private JButton ButtonT;
    private JButton ButtonU;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(GameEngine gameEngine)
    {
        engine = gameEngine;
        createGUI();
    }

    /**
     * Print out some text into the text area.
     */
    public void print(String text)
    {
        log.append(text);
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println(String text)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Show an image file in the interface.
     */
    public void showImage(String imageName)
    {
        URL imageURL = this.getClass().getClassLoader().getResource(imageName);
        if(imageURL == null)
            System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            image.setIcon(icon);
            myFrame.pack();
        }
    }

    /**
     * Enable or disable input in the input field.
     */
    public void enable(boolean on)
    {
        entryField.setEditable(on);
        if(!on)
            entryField.getCaret().setBlinkRate(0);
    }

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        myFrame = new JFrame("Zork");
        entryField = new JTextField(70);

        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension(200, 200));
        listScroller.setMinimumSize(new Dimension(100,100));

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        image = new JLabel();
        
        ButtonL = new JButton("north");
        ButtonQ = new JButton("east");
        ButtonH = new JButton("south");
        ButtonE = new JButton("west");
        ButtonR = new JButton("north west");
        ButtonA = new JButton("south west");
        ButtonT = new JButton("north east");
        ButtonU = new JButton("south east");
        help = new JButton("help");
        RBeamer = new JButton("Quit");
        
        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entryField, BorderLayout.SOUTH);
        
        panel4.setLayout(new BorderLayout());
        panel4.add(ButtonT, BorderLayout.EAST);
        ButtonT.addActionListener(this);
        panel4.add(ButtonR, BorderLayout.WEST);
        ButtonR.addActionListener(this);
        
        panel5.setLayout(new BorderLayout());
        panel5.add(ButtonU, BorderLayout.EAST);
        ButtonU.addActionListener(this);
        panel5.add(ButtonA, BorderLayout.WEST);
        ButtonA.addActionListener(this);
        
        panel3.setLayout(new BorderLayout());
        panel3.add(panel4, BorderLayout.NORTH);
        panel3.add(panel5, BorderLayout.SOUTH);
        
        panel1.setLayout(new BorderLayout());
        panel1.add(ButtonL, BorderLayout.NORTH);
        ButtonL.addActionListener(this);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(ButtonQ, BorderLayout.WEST);
        ButtonQ.addActionListener(this);
        panel1.add(ButtonH, BorderLayout.SOUTH);
        ButtonH.addActionListener(this);
        panel1.add(ButtonE, BorderLayout.EAST);
        ButtonE.addActionListener(this);
        
        panel2.setLayout(new BorderLayout(20,50));
      ///  panel2.add(Horloge, BorderLayout.WEST);
        panel2.add(help, BorderLayout.EAST);
        help.addActionListener(this);
        panel2.add(RBeamer, BorderLayout.SOUTH);
        RBeamer.addActionListener(this);
        panel2.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.EAST);
        
        myFrame.getContentPane().add(panel, BorderLayout.CENTER);

        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        entryField.addActionListener(this);

        myFrame.pack();
        myFrame.setVisible(true);
        entryField.requestFocus();
    }

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(ActionEvent e) 
    {
    	if(e.getActionCommand().equals("west"))engine.interpretCommand("go west");
        else if(e.getActionCommand().equals("south"))engine.interpretCommand("go south");
        else if(e.getActionCommand().equals("east"))engine.interpretCommand("go east");
        else if(e.getActionCommand().equals("north"))engine.interpretCommand("go north");
        else if(e.getActionCommand().equals("north east"))engine.interpretCommand("go northeast");
        else if(e.getActionCommand().equals("north west"))engine.interpretCommand("go northWest");
        else if(e.getActionCommand().equals("south east"))engine.interpretCommand("go southeast");
        else if(e.getActionCommand().equals("south west"))engine.interpretCommand("go southwest");
        else if(e.getActionCommand().equals("help"))engine.interpretCommand("help");
        else if(e.getActionCommand().equals("Quit"))engine.interpretCommand("quit");
        else
        processCommand();
    }

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
//        boolean finished = false;
        String input = entryField.getText();
        entryField.setText("");

        engine.interpretCommand(input);
    }
}
