package view;

import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;
import controller.Controller;


@SuppressWarnings("unused")
public class ZombiePanel {
	private static final String Picture = "images/damagedExplosiveZombie.png";
	private static final String Healthy = "images/HealthyExplosiveZombie.jpg";
	private static final String Pole = "images/PoleZombie.jpg";
	private JPanel graveyardPanel;
	private JButton[] zombies;
	private JButton undoButton;

	/**
	 * Initializes the The ZobiPanel by setting up the The panel layout and buttons
	 */
	public ZombiePanel() {
		zombies = (new JButton[3]);
		graveyardPanel = (new JPanel());
		getZombiePanel().setLayout(new FlowLayout());
		for (int i=0; i<3; i++){
			zombies[i] = new JButton();
			getZombiePanel().add(zombies[i]);
		}
		undoButton = new JButton("Undo");
		getZombiePanel().add(undoButton);
	}
	
	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
	    undoButton.addActionListener(c);
		for (int k=0; k<3; k++){
			zombies[k].addActionListener(c);
		}
	}

	/**
	 * Returns the graveyardPanel panel
	 * @return JPanel -Returns a JPanel 
	 */
	public JPanel getZombiePanel() {
		return graveyardPanel;
	}
	
	/**
	 * This method updates the ZombiePanel for the image of the zombie
	 * @param o -o is the object that this class instance is observing. 
	 */
	public void update(Observable o){
		//if(((Model)o).getCurrLevel().getLevel() == 1){			
			zombies[0].setIcon(new ImageIcon(Picture));
			zombies[1].setIcon(new ImageIcon(Healthy));
			zombies[2].setIcon(new ImageIcon(Pole));
		//}
	}

	/**
	 * Returns the zombies button.
	 * @return JButton[] -Returns a JButton 
	 */
	public JButton[] Zombies() {
		return zombies;
	}

	/**
	 * Return undoButton button.
	 * @return JButton - returns a button
	 */
	public JButton getUndoButton() {
		return undoButton;
	}
}
