package view;

import java.awt.BorderLayout;
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



public class View extends JFrame implements Observer {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	
	
	private  JPanel mainPanel;
	private  JPanel statusPanel;
	
	private PlantPanel sunFlowerPanel;
	

	private JLabel money;

	
	static private final String newline = "\n";
	
	JFileChooser fc;
	
	private MenuBar MenuBar;
	
	private mainPanel gridPanel;
	//private ZombieSelectPanel buildPanel;
	//private BuildGamePanel workingView;

	private JFrame frame;
	
	private boolean builderMode;			
	
	public View(){
		money =  new JLabel("Sun Power = 0");
		
		//Initializing the panels
		mainPanel = new JPanel();		
		sunFlowerPanel = new PlantPanel();
	
		gridPanel = new mainPanel();		
		statusPanel = new JPanel();
		//buildPanel = new ZombieSelectPanel();
		//workingView = new BuildGamePanel();
		statusPanel.add(money);
		fc = new JFileChooser();
		mainPanel.setLayout(new BorderLayout(40,5));
		statusPanel.setLayout(new FlowLayout());
		
		//adding panels to the main pane
		mainPanel.add(gridPanel.getGridPanel(), BorderLayout.CENTER);
		mainPanel.add(sunFlowerPanel.getSunFlowerPanel(), BorderLayout.WEST);
			mainPanel.add(statusPanel, BorderLayout.SOUTH);

		MenuBar = new MenuBar();
		
		frame = new JFrame("PlantsVsZombies");
		frame.setJMenuBar(MenuBar.getMenuBar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		
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
			money.setText("Sun Power = " + ((Model)o).getsunPoints());
			//initialize the first level view
			sunFlowerPanel.update(o);
			gridPanel.update(o);
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
		MenuBar.addAction(c);	   
		gridPanel.addAction(c);		
		
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
		return MenuBar.getStartingGame();
	}
	/**
	 * Return closeGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getExitGame()
	{
		return MenuBar.getClosingGame();
	}
	
	public JMenuItem getNewLevel(){
		return MenuBar.getNewLevel();
	}
	
	/**
	 * Returns the game grid.
	 * @return JButton[][] -Returns a JButton 
	 */
	public JButton[][] getGridList()
	{
		return gridPanel.getB();
	}
	/**
	 *  Returns the plants available to choose from.
	 * @return plants -returns plant list
	 */
	public JButton[] getPlantsList()
	{
		return sunFlowerPanel.getPlants();
	}
	
	
	public JButton getUndo(){
		return sunFlowerPanel.getUndoButton();
	}
	
	public JButton getRedo(){
		return sunFlowerPanel.getRedoButton();
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
		mainPanel.add(gridPanel.getGridPanel(), BorderLayout.CENTER);
		mainPanel.add(sunFlowerPanel.getSunFlowerPanel(), BorderLayout.SOUTH);
	
		mainPanel.add(statusPanel, BorderLayout.NORTH);
		
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
		//mainPanel.add(workingView.getGridPanel(), BorderLayout.NORTH);
		
	}

	public File actionOpenFile()
	{



        //Handle open button action.
            int returnVal = fc.showOpenDialog(View.this);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                return file;
                //This is where a real application would open the file.
            } 
        //Handle save button action.
			return null;
        
	}
	public File actionSaveFile()
	{
            int returnVal = fc.showSaveDialog(View.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                return file;
                //This is where a real application would save the file.
              
            }
        
		return null;
		
	}

	
	public boolean isBuilderMode(){
		return builderMode;
	}


}

