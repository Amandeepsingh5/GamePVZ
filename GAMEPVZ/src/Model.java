package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Observable;

@SuppressWarnings({ "unused", "serial" })
public class Model extends Observable implements Serializable {

	public static final int M_ROWS = 6;
	public static final int M_COLS = 12;
	private Player presentPlayer;
	private Level currLevel;

	private CreateLevel Level;
	private int index=0;

	//private CreateLevel CreateLevel;

	/**
	 * 
	 * @param level determines the game level and difficulty of the game generated. only 1 level is implemented currently
	 * @throws CloneNotSupportedException 
	 */
	public Model(int level){
		presentPlayer = new Player(level);
		currLevel = new Level(level);
		//CreateLevel = new CreateLevel(level);

		this.setChanged();
	}


	/**
	 * simulates the game system, updates the model. Every moving part moves.
	 * @throws CloneNotSupportedException 
	 */
	public void update() throws CloneNotSupportedException{	
		Random rand = new Random();	

		for(Character a: currLevel.getCharacterList()){	
			if(a.isAlive()){
				if(a.action(currLevel) == 5){			//sunflowers will have act(){return 5} unless anyone can think of a better way to do this?
					presentPlayer.sunPoints+= 5;
				}
			}
		}
		if(rand.nextInt(100) > 50){
			plusZombie();
		}

		this.setChanged();
		notifyObservers();
	}


	/**
	 * Moves a zombie from the coming area onto the map. If there is no place to put a zombie, the zombie is returned.
	 * @return True if a zombie was added, false otherwise
	 */
	private boolean plusZombie(){				
		if(currLevel.getcomingZombiesList().size() > 0){
			Random rand = new Random();
			int y;
			int eof = currLevel.getcomingZombiesList().size() - 1;
			Character newZombie = currLevel.getcomingZombiesList().get(eof);
			currLevel.getcomingZombiesList().remove(newZombie);
			y = rand.nextInt(M_ROWS);
			currLevel.addChar(newZombie, M_COLS, y);
		}
		return false;						 	//all rows are blocked
	}


	/**
	 * Attempts to purchase a plant. Decreases solar reserves by the cost of the plant if successful.
	 * @param type the kind of plant to be purchased
	 * @return The newly purchased plant, or null if it is unaffordable
	 */
	private Plant buyPlant(String kind){
		Plant newPlant = presentPlayer.getPlant(kind);
		if(newPlant != null){
			presentPlayer.sunPoints -= newPlant.price();
			return newPlant;
		}
		else{
			return null;
		}
	}

	/**
	 * Puts a plant on the map, given a co-ordinate pair, and the name of a plant type.
	 * @param x destination co-ordinate for the plant
	 * @param y destination co-ordinate for the plant
	 * @param type the type of plant to be placed
	 * @return True if the plant was placed, false otherwise;
	 */
	public boolean placePlant(int xcoor, int ycoor, String kind){

		if(currLevel.fieldDimension(xcoor, ycoor)){

			if(!currLevel.CharacterAt(xcoor, ycoor)){

				Character newPlant = buyPlant(kind);			//this decreases your solarPower. we should split it into createPlant() and payForPlant() methods. 

				if (newPlant != null) {		//otherwise there will be times where we will want to refund the player if they screw up.
					return(currLevel.addChar(newPlant, xcoor, ycoor));
				}
			}
		}
		return false;		
	}

	/**
	 * Checks the game state for a win or a loss.
	 * Win if there are no zombies on the field, and no zombies coming.
	 * Loss if there is a zombie in the first column.
	 * @return -1 if the player lost, 1 if they won, 0 otherwise
	 */
	public int statusOfGame(){
		for(int y = 0; y <= M_ROWS; y++){

			if(currLevel.loc_Zombie(0, y)){ 

				return -1; 								//game loss if there is a zombie in the first column
			}
		}
		if(currLevel.getcomingZombiesList().isEmpty()){

			for(Character a: currLevel.getCharacterList()){

				if(!a.isFriendly() && a.isAlive()){								
					return 0;
				}
			}
			return 1;										//game win if there are no zombies on the field, and no zombies coming
		}
		return 0;
	}

	/**
	 * Primitive display method. A view system will be responsible for all of this in later versions.
	 */
	public void DisplayField(){
		for (int y = 0; y < M_ROWS; y++){

			for(int x = 0; x < M_COLS; x++){
				if(currLevel.CharacterAt(x, y)
						){
					currLevel.getCharacterAt(x, y).getPicture();
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	/**
	 * Returns the coming zombies in the current level
	 * @return ArrayList<Character> - the arraylist of characters
	 */
	public ArrayList<Character> getZombies(){
		return this.currLevel.getcomingZombiesList();
	}

	/**
	 * Return sun points of the present player
	 * @return int -returns the sun points
	 */
	public int getSolarPower() {
		int points=	presentPlayer.sunPoints;
		return points;
	}

	/**
	 * Return sunflower sun points of the present player
	 * @return int -returns the sunflower sun points
	 */
	public int getSolarRate() {
		int rate= presentPlayer.sunflowerPoints;
		return rate;
	}

	/**
	 * Returns the choice
	 * @return String - the string representation of the choice
	 */
	public String Choice()
	{
		return presentPlayer.getChoice();
	}

	/**
	 *  Sets the choice 
	 * @param choosen -the choice the user has choosen
	 */
	public void setChoice(String choose)
	{
		this.setChanged();

		presentPlayer.setChoice(choose);

		notifyObservers();
	}


	public Level getCurrLevel() {
		Level curr =currLevel;
		return curr;
	}



}