package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controller.Controller;

@SuppressWarnings({ "unused", "serial" })
public class mainFrame extends JFrame implements Observer{
	private static final int WINDOW_WIDTH = 1024;
	private static final int WINDOW_HEIGHT = 768;
	
	
	private  JPanel mainPanel;
	private  JPanel statusPanel;
	private zombiePanel buildPanel;
	private gamePanel main;

	private JFrame frame;
	
	private boolean builderMode;			//maybe pointless?
	
	public mainFrame(){
	
		//Initializing the panels
		mainPanel = new JPanel();		
		statusPanel = new JPanel();
		buildPanel = new zombiePanel();
		main = new gamePanel();
		
		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout());
		
		
		
		//adding panels to the main pane
		mainPanel.add(statusPanel, BorderLayout.SOUTH);
		frame = new JFrame("Plants Vs Zombies");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		main.update(o, arg);
		
	}
	
	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
		buildPanel.addAction(c);
	}
	
	/**
	 *  Returns the zombies available .
	 * @return JButton[] -returns zombie
	 */
	public JButton[] getZombies() {
		return buildPanel.getZombies();
	}
	
	
}
