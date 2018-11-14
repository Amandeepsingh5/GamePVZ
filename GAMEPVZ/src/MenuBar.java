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
	
	public void addAction(Controller c){
		startGame.addActionListener(c);
		closeGame.addActionListener(c);
		newLevel.addActionListener(c);
	}
	public JMenuItem getLoadGame(){
		return loadGame;
	}
	
	public JMenuItem getStartGame(){
		return startGame;
	}
	
	public JMenuItem getCloseGame(){
		return closeGame;
	}
	public JMenuItem getNewLevel(){
		return newLevel;
	}
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
}