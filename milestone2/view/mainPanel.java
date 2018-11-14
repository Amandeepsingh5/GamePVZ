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
	private static final int MROWS = 6;
	private static final int MCOLS = 12;
	private JPanel grid;
	protected JButton[][] buttons;
	
	
	
	public mainPanel() {
		
		buttons = new JButton[MROWS][MCOLS];
		
		grid = (new JPanel());
		getgrid().setLayout(new GridLayout(MROWS,MCOLS));
		for(int x =0; x<MROWS; x++){
		
			for (int y=0; y<MCOLS; y++){
				
				buttons[x][y] = new JButton();
				buttons[x][y].setBackground(Color.GREEN);
				
				
				buttons[x][y].setEnabled(false);
				getgrid().add(buttons[x][y]);
				
			}
		}
	}
	
	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void action(Controller c){
		for(int x =0; x<MROWS; x++){
			for (int y=0; y<MCOLS; y++){
				buttons[x][y].addActionListener(c);
			}
		}
	}
	
	void update(Observable o){
		Level status = ((Model)o).getCurrLevel();
		int x=0;
		int y=0;
		
		//check to see if the user chose a non-valid or skip button
		if (((Model)o).Choice()==null){
			this.gridButtons(false);
		}
		//check to see if the user has chosen a plant
		else if(((Model)o).Choice() != null){
			this.gridButtons(true);
		}
		//draw each Character in play
		for(Character a: status.getLivingCharacters()){
			x = a.getX();
			y = a.getY();	
			if(status.fieldDimension(x, y)){
				buttons[y][x].setIcon(new ImageIcon(a.getPicture()));
			}
		}
	}
	
	/**
	 * Sets the buttons enabled according to the given parameter.
	 * Also assigns the image to a null value, this will clear 
	 * the Game grid of the previous positions.
	 * @param bool -accepts a bool
	 */
	public void gridButtons(boolean b)
	{
		for(int x =0; x<MROWS; x++){
			for (int y=0; y<MCOLS; y++){
				buttons[x][y].setEnabled(b); 
				buttons[x][y].setIcon(null);
			}
		}
	}

	/**
	 * Returns the game grid panel.
	 * @return JPanel -Returns a JPanel 
	 */
	public JPanel getgrid() {
		
		return grid;
	}
	
	/**
	 * Returns the buttons of the grid.
	 * @return JButton[][] -Returns a JButton 
	 */
	public JButton[][] getB(){
		return buttons;
	}
}