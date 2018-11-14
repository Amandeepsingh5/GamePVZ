package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Model;
import controller.Controller;


@SuppressWarnings({ "serial", "unused" })
public class View extends JFrame implements Observer {
	private static final int WINDOW_WIDTH = 1024;
	private static final int WINDOW_HEIGHT = 768;
	private  JPanel mainPanel;
	private  JPanel statusPanel;
	private PlantPanel sunFlowerPanel;

	private JLabel money;

	@SuppressWarnings("unused")
	static private final String newline = "\n";
	
	private MenuBar mainMenu;
	
	private mainPanel grid;
	//private ZombieSelectPanel buildPanel;
	//private BuildmainPanel workingView;

	private JFrame frame;
	
	private boolean builderMode;			//maybe pointless?
	
	public View(){
		money =  new JLabel("Sun Power = 0");
		money.setForeground(Color.RED);
		
		//Initializing the panels
		mainPanel = new JPanel();	
		sunFlowerPanel = new PlantPanel();

		grid = new mainPanel();		
		statusPanel = new JPanel();
		//buildPanel = new ZombieSelectPanel();
		//workingView = new BuildmainPanel();
		statusPanel.add(money);
		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout());
		
		//adding panels to the main pane
		mainPanel.add(grid.getgrid(), BorderLayout.CENTER);
		mainPanel.add(sunFlowerPanel.getSunFlowerPanel(), BorderLayout.NORTH);
		
		mainPanel.add(statusPanel, BorderLayout.SOUTH);

		mainMenu = new MenuBar();
		
		frame = new JFrame("Plants Vs Zombies");
		frame.setJMenuBar(mainMenu.getMenuBar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		
	}
	/**
	 * This method updates the View with any changes that occurred in the Model.
	 * It will update the game grid and the money.
	 * @param o, arg -o is the object that this class instance is observing. 
	 * -arg is any arguments passed in
	 */
	@Override
	public void update(Observable o, Object arg) {		
		if(!builderMode){
			//update the sun money
			money.setText("Sun Power = " + ((Model)o).getSolarPower());
			//initialize the first level view
			sunFlowerPanel.update(o);
			grid.update(o);
		}
		else{
			//workingView.update(o);
		}
	}
	
	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
		mainMenu.addAction(c);	   
		grid.action(c);		
		
		sunFlowerPanel.addAction(c);
	}
	
	/**
	 * Return skipTurn button.
	 * @return JButton - returns a button
	 */
	public JButton getSkipTurn()
	{
		return sunFlowerPanel.getSkipTurn();
	}
	
	/**
	 * Return startGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getNewGame()
	{
		return mainMenu.getStartGame();
	}
	
	/**
	 * Return closeGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getExitGame()
	{
		return mainMenu.getCloseGame();
	}
	
	/**
	 * Return NewLevel JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getNewLevel(){
		return mainMenu.getNewLevel();
	}
	
	/**
	 * Returns the game grid.
	 * @return JButton[][] -Returns a JButton 
	 */
	public JButton[][] getGridList()
	{
		return grid.getB();
	}
	
	/**
	 *  Returns the plants available to choose from.
	 * @return JButton[] -returns plant list
	 */
	public JButton[] getPlantsList()
	{
		return sunFlowerPanel.getPlants();
	}
	
	/**
	 * Return LoadGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getLoadGame(){
		return mainMenu.getLoadGame();
	}
	
	/**
	 * Lays out the game for playing
	 */
	public void switchToPlayMode(){
		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout());
		mainPanel.removeAll();
		builderMode = false;
		//adding panels to the main pane
		mainPanel.add(grid.getgrid(), BorderLayout.CENTER);
		mainPanel.add(sunFlowerPanel.getSunFlowerPanel(), BorderLayout.NORTH);
		
		mainPanel.add(statusPanel, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Lays out the game for building levels
	 * call when using the level builder
	 */
	public void switchToBuildMode(){
		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout());
		mainPanel.removeAll();
		
		builderMode = true;
		//adding panels to the main pane
		//mainPanel.add(buildPanel.getGraveyardPanel(), BorderLayout.SOUTH);
		//mainPanel.add(workingView.getgrid(), BorderLayout.NORTH);
		
	}
	public boolean isBuilderMode(){
		return builderMode;
	}


}

