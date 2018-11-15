package view;

import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;
import controller.Controller;


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
	
	public void addAction(Controller c){
	    skipTurn.addActionListener(c);
	  
		for (int k=0; k<2; k++){
			getPlants()[k].addActionListener(c);
		}
	}
	
	public JButton getSkipTurn() {
		return skipTurn;
	}

	public JPanel getSunFlowerPanel() {
		return sunFlowerPanel;
	}
	
	public void update(Observable o){
		if(((Model)o).getCurrLevel().getLevel() == 1){			
			getPlants()[0].setIcon(new ImageIcon(sunflowerpic));
			getPlants()[1].setIcon(new ImageIcon(peaShooter));
			
		}
		skipTurn.setEnabled(true);
		
		
		
	}

	public JButton[] getPlants() {
		return plants;
	}



	
}