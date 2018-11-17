package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Cloneable, Serializable {
	private String choice; 
	private GetPlant plant;
	public int sunPoints;
	public int sunflowerPoints;

	public Player(int level) {
		plant = new GetPlant(level); 
		sunPoints = 10; 
		sunflowerPoints = 5;
		choice = null;
	}

	/**
	 * Update the sunPoints when a sunFlower is dropped
	 */
	void update(){
		sunPoints = sunflowerPoints + sunPoints;
	}

	/**
	 * Return the plant
	 * @return GetPlant -returns the plant
	 */
	public GetPlant getplant() {
		return plant;
	}

	/**
	 * Return sun points
	 * @return int -returns the sun points
	 */
	public int getSolarPower() {
		return sunPoints;
	}

	/**
	 * Sets the type of plant and returns the plant
	 * @param type - a string that specifies the type of plant
	 * @return Plant -returns plant
	 */
	public Plant getPlant(String type){
		Plant p= plant.getPlant(type, sunflowerPoints);
		return p;
	}

	/**
	 * Return the choice the player makes
	 * @return String -returns the choice
	 */
	public String getChoice() {
		return choice;
	}

	/**
	 * Sets the choice to the parameter 
	 * @param choice - the choice the player makes
	 */
	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Object clone() throws CloneNotSupportedException{
		Player clone = (Player)super.clone();
		if(choice == null){


			clone.choice = null;
		}
		else{
			clone.choice = new String(this.choice);
		}

		clone.sunPoints= this.sunPoints;
		clone.sunflowerPoints = this.sunflowerPoints;
		return clone;
	}
}