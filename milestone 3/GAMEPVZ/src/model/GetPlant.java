package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GetPlant implements Cloneable, Serializable{
	private int level;

	public GetPlant(int level){
		this.level = level;
	}
	
	/**
	 * Checks if string matches a plant name and if the are enough sun points
	 * @param string - a string that defines what type of plant it is
	 * @param sunpoints - the current amount of sun points
	 * @return requested Plant if it exists else returns null
	 */
	public Plant getPlant(String string, int sunpoints) {
		//should use an enum instead of a string...
		Plant plant = null;
		
		if(string.equals("sunflower")){
			plant = new SunFlower(level);
		}
		
		else if (string.equals("shooter")){
			plant = new PeaShooter(level);
		}
		else if(string.equals("snowshooter")){
			plant = new SnowShooter(level);
		}
		
		else if(string.equals("walnut")){
			plant = new Walnut(level);
		}
		else{
			return null;
		}
		// Check if there are enough sunpoints for the plant
		if(plant.getprice() > sunpoints){
			return null;
		}
		else{
			return plant;
		}
	}

	public Object clone() throws CloneNotSupportedException{
		GetPlant clone = (GetPlant)super.clone();
		clone.level = this.level;
		return clone;
	}
}
