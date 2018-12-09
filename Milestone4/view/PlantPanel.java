package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;
import controller.Controller;


@SuppressWarnings("unused")
public class PlantPanel {
	// The image files for the game
	private static final String sunflowerpic="images/sunflower.png";
	private static final String peaShooter="images/peashooter.png";
	
	private static final String walnut = "images/walnut.png";
	private static final String snowShooter = "images/peashooterFreeze.jpg";
	
	private JPanel sunFlowerPanel;
	
	//the buttons that will be used by the Controller
	private JButton[] plants;
	private JButton skipTurn;
	private JButton undoButton;
	private JButton redoButton;

	/**
	 * Initializes the The PlantPanel by setting up the The panel layout and buttons
	 */
	public PlantPanel() {
		plants = (new JButton[5]);
		sunFlowerPanel = (new JPanel());
		getSunFlowerPanel().setLayout(new GridLayout(0,1));
		
		for (int i=0; i<4; i++){
			plants[i] = new JButton();
			getSunFlowerPanel().add(plants[i]);
		}
		
		skipTurn = new JButton("Skip Turn");
		undoButton = new JButton("Undo");
		redoButton = new JButton("Redo");
	//	skipTurn.setEnabled(true);
		getSunFlowerPanel().add(skipTurn);
		getSunFlowerPanel().add(undoButton);
		getSunFlowerPanel().add(redoButton);
	}
	
	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
	    skipTurn.addActionListener(c);
	    undoButton.addActionListener(c);
	    redoButton.addActionListener(c);
		for (int k=0; k<4; k++){
			getPlants()[k].addActionListener(c);
		}
	}
	
	/**
	 * Returns skipTurn button.
	 * @return JButton - returns a button
	 */
	public JButton getSkipTurn() {
		return skipTurn;
	}

	/**
	 * Returns getSunFlowerPanel panel.
	 * @return JPanel - returns a panel
	 */
	public JPanel getSunFlowerPanel() {
		return sunFlowerPanel;
	}
	
	/**
	 * Updates the display that shows the available plants depending on the level, enables the undo and redo button
	 * depending if the Observable is able to undo and/or redo, if they can not the buttons a disabled
	 * @param o The observable that will be used to check the level and if there is a redo and/or undo button available
	 */
	public void update(Observable o){
		if(((Model)o).getCurrLevel().getLevel() == 1){			
			getPlants()[0].setIcon(new ImageIcon(sunflowerpic));
			getPlants()[1].setIcon(new ImageIcon(peaShooter));
			getPlants()[2].setIcon(new ImageIcon(snowShooter));
			getPlants()[3].setIcon(new ImageIcon(walnut));
		
		}
		skipTurn.setEnabled(true);
		if(((Model)o).canUndo()){
			undoButton.setEnabled(true);
		}
		else{
			undoButton.setEnabled(false);
		}
		
		if(((Model)o).canRedo()){
			redoButton.setEnabled(true);
		}
		else{
			redoButton.setEnabled(false);
		}
	}

	/**
	 * Returns plants button.
	 * @return JButton - returns a button
	 */
	public JButton[] getPlants() {
		return plants;
	}

	/**
	 * Returns undoButton button.
	 * @return JButton - returns a button
	 */
	public JButton getUndoButton() {
		return undoButton;
	}

	/**
	 * Returns redoButton button.
	 * @return JButton - returns a button
	 */
	public JButton getRedoButton() {
		return redoButton;
	}

	
}