package model;

import java.io.Serializable;


public class GetPlant {
	private int level;
	
	public GetPlant(int level){
		this.level = level;
	}
	
	/**
	 * 
	 * @param string
	 * @param suns
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

	