package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Controller;

public class MenuBar {
	
	private JMenu mainMenu;
	private JMenuBar menuBar;
	//JMenuItems
	private JMenuItem startingGame;
	private JMenuItem closingGame;
	
	private JMenuItem saveGame;
	private JMenuItem loadGame;
	
	private JMenuItem newLevel;

	
	/**
	 * Initializes the The MenuBar by creating the Menu, Menu bar and Menu items
	 */
    public MenuBar() {

			menuBar= new JMenuBar();
			mainMenu = new JMenu("File");		
			//menuItems
			startingGame = new JMenuItem("New");
			closingGame = new JMenuItem("Exit");
			newLevel = new JMenuItem("New Level");
			
			saveGame = new JMenuItem("Save");
			loadGame = new JMenuItem("Load");
			
			mainMenu.add(newLevel);
			mainMenu.add(startingGame);
			mainMenu.add(closingGame);
			mainMenu.add(saveGame);
			mainMenu.add(loadGame);
			
			menuBar.add(mainMenu);
	}
	
    /**
  	 * Adds the actionlistener controller c to the GUI components.
  	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
  	 */
	public void addAction(Controller c){
		startingGame.addActionListener(c);
		closingGame.addActionListener(c);
		saveGame.addActionListener(c);
		loadGame.addActionListener(c);
		newLevel.addActionListener(c);
		
		
	}
	
	/**
	 * Return startingGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getStartingGame(){
		return startingGame;
	}
	
	/**
	 * Return closingGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getClosingGame(){
		return closingGame;
	}
	
	public JMenuItem getLoadGame(){
		return loadGame;
	}
	public JMenuItem getSaveGame(){
		return saveGame;

	}
	public JMenuItem getNewLevel(){
		return newLevel;
	}
	/**
	 * Return menubar JMenuBar.
	 * @return JMenuBar -returns a JMenuBar
	 */
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
}