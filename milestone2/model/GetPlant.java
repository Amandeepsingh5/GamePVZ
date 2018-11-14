package model;

import java.io.Serializable;


@SuppressWarnings("unused")
public class GetPlant {
	private int level;
	
	public GetPlant(int level){
		this.level = level;
	}
	
	/**
	 * Checks if string matches a plant name and if the are enough sun points
	 * @param string - a string that defines what type of plant it is
	 * @param suns - the current amount of sun points
	 * @return requested Plant if it exists else returns null
	 */
	public Plant getPlant(String string, int suns) {				//should use an enum instead of a string...
		Plant plant = null;
		if(string.equals("sunflower")){
			plant = new SunFlower(level);
		}
		
		else if (string.equals("shooter")){
			plant = new PeaShooter(level);
		}
		
		else{
			return null;
		}
		// Check if there are enough suns for the plant
		if(plant.price() > suns){
			return null;
		}
		else{
			return plant;
		}
	}
}

	