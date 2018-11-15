package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controller.Controller;

public class mainFrame extends JFrame implements Observer{
	private static final int WINDOW_WIDTH = 1024; // size of the window when opens
	private static final int WINDOW_HEIGHT = 768;
	
	
	private  JPanel mainPanel; // the main panel
	private  JPanel statusPanel; // the sun points shown in the statusPanel
	private zombiePanel buildPanel; // Zombie panel that launches the zombies
	private gamePanel main; // the main game panel that has grid

	private JFrame frame; // main frame

	
	public mainFrame(){
	
		//Initializing the panels
		mainPanel = new JPanel();	//initialize	
		statusPanel = new JPanel();
		buildPanel = new zombiePanel();
		main = new gamePanel();
		
		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout()); //set layout
		
		
		
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
	
	public void addAction(Controller c){
		buildPanel.addAction(c); // add controller
	}
	
	public JButton[] getZombies() {
		return buildPanel.getZombies(); // get zombies
	}
	
	
}
