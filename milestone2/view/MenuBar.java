package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Controller;


public class MenuBar {
	private JMenu mainMenu;
	private JMenuBar menuBar;
	private JMenuItem startGame;
	private JMenuItem closeGame;

	private JMenuItem newLevel;
	

  
    private JMenuItem loadGame;
	
    public MenuBar() {

			menuBar= new JMenuBar();
			mainMenu = new JMenu("File");		
			//menuItems
			startGame = new JMenuItem("New");
			closeGame = new JMenuItem("Exit");
			newLevel = new JMenuItem("New Level");
			
			mainMenu.add(newLevel);

			 
			loadGame = new JMenuItem("Load");
			mainMenu.add(startGame);
			mainMenu.add(closeGame);
		
			menuBar.add(mainMenu);
	}
	
    /**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
		startGame.addActionListener(c);
		closeGame.addActionListener(c);
		newLevel.addActionListener(c);
	}
	
	/**
	 * Return LoadGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getLoadGame(){
		return loadGame;
	}
	/**
	 * Return startGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getStartGame(){
		return startGame;
	}
	
	/**
	 * Return closeGame JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
	public JMenuItem getCloseGame(){
		return closeGame;
	}
	
	/**
	 * Return NewLevel JMenuItem.
	 * @return JMenuItem -returns a JMenuItem
	 */
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