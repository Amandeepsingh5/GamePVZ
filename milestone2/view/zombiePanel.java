package view;

import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;
import controller.Controller;

@SuppressWarnings("unused")
public class zombiePanel {
	private static final String picture = "images/damagedExplosiveZombie.png";

	private JPanel panel;
	private JButton[] zombies;


	public zombiePanel() {
		zombies = (new JButton[3]);
		panel = (new JPanel());
		getZombiePanel().setLayout(new FlowLayout());
		for (int i=0; i<3; i++){
			zombies[i] = new JButton();
			getZombiePanel().add(zombies[i]);
		}

	}

	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){

		for (int k=0; k<3; k++){
			zombies[k].addActionListener(c);
		}
	}

	/**
	 * Return getZombiePanel panel.
	 * @return JPanel - returns a panel
	 */
	public JPanel getZombiePanel() {
		return panel;
	}

	/**
	 * Updates the zombie type that will appear depending on level
	 * @param o The observable that will be used to check the level
	 */
	public void update(Observable o){
		//if(((Model)o).getCurrLevel().getLevel() == 1){			
		zombies[0].setIcon(new ImageIcon(picture));

		//}
	}

	/**
	 *  Returns the zombies available 
	 * @return JButton[] -returns zombies
	 */
	public JButton[] getZombies() {
		return zombies;
	}


}
