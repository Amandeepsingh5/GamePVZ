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

	
	/**
	 * Initializes the The MenuBar by creating the Menu, Menu bar and Menu items
	 */
    public MenuBar() {

			menuBar= new JMenuBar();
			mainMenu = new JMenu("File");		
			//menuItems
			startingGame = new JMenuItem("New");
			closingGame = new JMenuItem("Exit");
			
			mainMenu.add(startingGame);
			mainMenu.add(closingGame);
			
			menuBar.add(mainMenu);
	}
	
    /**
  	 * Adds the actionlistener controller c to the GUI components.
  	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
  	 */
	public void addAction(Controller c){
		startingGame.addActionListener(c);
		closingGame.addActionListener(c);
		
		
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
	
	
	/**
	 * Return menubar JMenuBar.
	 * @return JMenuBar -returns a JMenuBar
	 */
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
}
