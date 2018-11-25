package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Cloneable, Serializable {
	private String choice;
	private GetPlant plants;
	public int sunPoints;
	public int solarRate;

	public Player(int level) {
		plants = new GetPlant(level);
		sunPoints = 10;
		solarRate = 5;
		choice = null;
	}
	
	/**
	 * Update the sunPoints
	 */
	void update(){
		sunPoints += solarRate;
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

	/**
	 * Return the plant
	 * @return GetPlant -returns the plant
	 */
	public GetPlant getplants() {
		return plants;
	}

	/**
	 * Return sun points
	 * @return int -returns the sun points
	 */
	public int getsunPoints() {
		return sunPoints;
	}
	
	/**
	 * Sets the type of plant and returns the plant
	 * @param type - a string that specifies the type of plant
	 * @return Plant -returns plant
	 */
	public Plant getPlant(String type){
		return plants.getPlant(type, sunPoints);
	}
	
	/**
	 * Clones everything about the Player
	 * @return clone of the Player
	 */
	public Object clone() throws CloneNotSupportedException{
		Player clone = (Player)super.clone();
		if(choice != null){
			clone.choice = new String(this.choice);
		}
		else{
			clone.choice = null;
		}
		clone.plants = (GetPlant)plants.clone();
		clone.sunPoints = this.sunPoints;
		clone.solarRate = this.solarRate;
		return clone;
	}
}