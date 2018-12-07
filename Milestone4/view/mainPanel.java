package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Character;
import model.Level;
import model.Model;
import controller.Controller;


public class mainPanel {
	// the dimensions of the game field
	private static final int MAX_ROWS = 6;
	private static final int MAX_COLS = 12;
	private JPanel gridPanel;
	protected JButton[][] buttons;

	/**
	 * Initializes the The mainPanel by setting up the The panel layout and buttons
	 */
	public mainPanel() {
		buttons = new JButton[MAX_ROWS][MAX_COLS];
		gridPanel = (new JPanel());
		getGridPanel().setLayout(new GridLayout(MAX_ROWS,MAX_COLS));
		for(int x =0; x<MAX_ROWS; x++){
			for (int y=0; y<MAX_COLS; y++){
				buttons[x][y] = new JButton();
				buttons[x][y].setBackground(Color.green);
				buttons[x][y].setEnabled(false);
				getGridPanel().add(buttons[x][y]);
			}
		}
	}
	
	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
		for(int x =0; x<MAX_ROWS; x++){
			for (int y=0; y<MAX_COLS; y++){
				buttons[x][y].addActionListener(c);
			}
		}
	}
	
	/**
	 * This method updates the mainPanel depending on if the user's choice is valid and if valid, 
	 * updates the where the plant has been placed.
	 * @param o -o is the object that this class instance is observing. 
	 */
	void update(Observable o){
		Level gameState = ((Model)o).getCurrLevel();
		int x=0;
		int y=0;
		
		//check to see if the user chose a non-valid or skip button
		if (((Model)o).getChoice()==null){
			this.setGridButtons(false);
		}
		//check to see if the user has chosen a plant
		else if(((Model)o).getChoice() != null){
			this.setGridButtons(true);
		}
		//draw each actor in play
		for(Character a: gameState.getLivingCharacters()){
			x = a.getX();
			y = a.getY();	
			if(gameState.fieldDimension(x, y)){
				buttons[y][x].setIcon(new ImageIcon(a.getSprite()));
			}
		}
	}
	
	/**
	 * Sets the buttons enabled according to the given parameter.
	 * Also assigns the image to a null value, this will clear 
	 * the Game grid of the previous positions.
	 * @param bool -accepts a bool
	 */
	public void setGridButtons(boolean bool)
	{
		for(int x =0; x<MAX_ROWS; x++){
			for (int y=0; y<MAX_COLS; y++){
				buttons[x][y].setEnabled(bool);
				//set the button to nullto avoid 
				
				buttons[x][y].setIcon(null);
			}
		}
	}

	/**
	 * Returns the game grid panel.
	 * @return JPanel -Returns a JPanel 
	 */
	public JPanel getGridPanel() {
		return gridPanel;
	}
	
	/**
	 * Returns the buttons of the grid.
	 * @return JButton[][] -Returns a JButton 
	 */
	public JButton[][] getB(){
		return buttons;
	}
}