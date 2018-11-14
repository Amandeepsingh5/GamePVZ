package view;

import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;
import controller.Controller;

@SuppressWarnings("unused")
public class PlantPanel {
	private static final String sunflowerpic="images/sunflower.png";
	private static final String peaShooter="images/Peashooter.png";
	private static final String grass="images/grass3b.gif";						
	private JPanel sunFlowerPanel;
	private JButton[] plants;
	private JButton skipTurn;


	public PlantPanel() {
		plants = (new JButton[3]);
		sunFlowerPanel = (new JPanel());
		getSunFlowerPanel().setLayout(new FlowLayout());
		for (int i=0; i<2; i++){

			plants[i] = new JButton();
			getSunFlowerPanel().add(plants[i]);
		}
		skipTurn = new JButton(""); 

		skipTurn.setEnabled(true);

	}

	/**
	 * Adds the actionlistener controller c to the GUI components.
	 * @param c -c is the controller object that is assigned to listen to this object instances GUI components.
	 */
	public void addAction(Controller c){
		skipTurn.addActionListener(c);

		for (int k=0; k<2; k++){
			getPlants()[k].addActionListener(c);
		}
	}

	/**
	 * Return skipTurn button.
	 * @return JButton - returns a button
	 */
	public JButton getSkipTurn() {
		return skipTurn;
	}

	/**
	 * Return getSunFlowerPanel panel.
	 * @return JPanel - returns a panel
	 */
	public JPanel getSunFlowerPanel() {
		return sunFlowerPanel;
	}

	/**
	 * Updates the display that shows the available plants depending on the level
	 * @param o The observable that will be used to check the level
	 */
	public void update(Observable o){
		if(((Model)o).getCurrLevel().getLevel() == 1){			
			getPlants()[0].setIcon(new ImageIcon(sunflowerpic));
			getPlants()[1].setIcon(new ImageIcon(peaShooter));

		}
		skipTurn.setEnabled(true);
	}

	/**
	 *  Returns the plants available to choose from.
	 * @return JButton[] -returns plant
	 */
	public JButton[] getPlants() {
		return plants;
	}




}