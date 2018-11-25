package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controller.Controller;

@SuppressWarnings("serial")
public class mainFrame extends JFrame implements Observer{
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;


	private  JPanel mainPanel;
	private  JPanel statusPanel;

	private ZombiePanel buildPanel;

	private gamePanel main;

	private JFrame frame;

	@SuppressWarnings("unused")
	private boolean Mode;			//maybe pointless?

	public mainFrame(){

		//Initializing the panels
		mainPanel = new JPanel();		
		statusPanel = new JPanel();
		buildPanel = new ZombiePanel();
		main = new gamePanel();

		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout());

		//adding panels to the main pane
		mainPanel.add(statusPanel, BorderLayout.NORTH);
		frame = new JFrame("PlantsVSZombies");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);

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
	 * Returns the zombies button from the ZombiePanel class
	 * @return JButton[] -Returns a JButton 
	 */
	public JButton[] getZombies() {
		return buildPanel.Zombies();
	}

	/**
	 * Return undoButton button from the ZombiePanel class.
	 * @return JButton - returns a button
	 */
	public JButton Undo(){
		return buildPanel.getUndoButton();
	}
}
