package model;

import java.io.Serializable;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Level implements Cloneable, Serializable{
	public static final int M_Y = 6;
	public static final int M_X = 12;

	private ArrayList<Character> CharacterList;

	private ArrayList<Character> comingZombiesList;
	//grid may be redundant. All the positional information in it is also stored in CharacterList.
	private int level;

	public ArrayList<Character> getCharacterList() {

		return CharacterList;
	}


	public Level(int level) {

		this.level = level;
		CharacterList = new ArrayList<Character>();
		comingZombiesList = new ArrayList<Character>();

		for(int x = 0; x < (5 + level); x++){

			getcomingZombiesList().add(new ExplosiveZombie(level)); 			//add some basic zombies

		}


	}


	/**
	 * Gets all Characters that are currently alive. We don't remove dead Characters, just sort of ignore them.
	 * @return all Characters that are in play and alive
	 */
	public ArrayList<Character> getLivingCharacters(){
		ArrayList<Character> alive = new ArrayList<Character>();
		for(Character a: CharacterList){

			if(!a.isAlive()){
			}
			else {alive.add(a);}
		}

		return alive;
	}

	public ArrayList<Character> getcomingZombiesList() {
		return comingZombiesList;
	}

	/**
	 * @param comingZombiesList the comingZombiesList to set
	 */
	public void setcomingZombiesList(ArrayList<Character> comingZombiesList) {
		this.comingZombiesList = comingZombiesList;
	}
	/**
	 * Checks if a character is at the coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if there is an Character at the given coordinates
	 */
	public boolean CharacterAt(int x, int y){
		for(Character a: CharacterList){
			if(a.isAt(x, y) && a.isAlive()){
				return true;
			}
		}
		return false;
	}
	
	public int getMaxY() {

		int max= 	M_Y;
		return max;
	}

	/**
	 * @return the maxX
	 */
	public int getMaxX() {
		int maxx = M_X;
		return maxx;
	}

	/**
	 * Checks if a zombie is at the coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if there is a zombie at the coordinate
	 */

	public boolean loc_Zombie(int x, int y){

		for(Character a: CharacterList){

			if(a.isAt(x, y)){

				if(  !a.isFriendly () && a.isAlive()){

					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Adds a new Character to the level at a certain position. Position is stored in the Character, and in the grid.
	 * Character is also enrolled in the CharacterList
	 * @param newCharacter
	 * @param x
	 * @param y
	 * @return
	 */


	/**
	 * Searches the grid for a plant Character at a position.
	 * Because this information is also stored in Characters, a search of the CharacterList would also work
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the plant is at the cooridinates and is alive, false otherwise
	 */
	public boolean plantAt(int x, int y){
		for(Character a: CharacterList){

			if(a.isAt(x,y)){

				if( a.isFriendly ()&& a.isAlive()){

					return true;
				}
			}
		}
		return false;
	}


	public boolean addChar(Character newChar, int x, int y){

		return(newChar.setXY(x, y) && CharacterList.add(newChar));
	}

	/**
	 * Returns a list of all the Characters at the coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return a list of all the Characters at the coordinates
	 */
	public ArrayList<Character> getCharactersAt(int x, int y){
		ArrayList<Character> returnList = new ArrayList<Character>();
		for(Character a: CharacterList){
			if(a.isAt(x,y) && a.isAlive()){
				returnList.add(a);
			}
		}
		return returnList;
	}

	/**
	 * Sets	the characters coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return the first Character found at the given coordinates
	 */
	public Character getCharacterAt(int x, int y){

		for(Character a: CharacterList){

			if(a.isAt(x,y)){

				return(a);

			}
		}
		return null;
	}


	/**
	 *  Sets the field dimensions
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the coordinates are within the bounds of the level
	 */
	public boolean fieldDimension(int x, int y){

		return(x >= 0 && x < M_X && y >= 0 && y < M_Y);
	}

	public Object clone() throws CloneNotSupportedException{

		Level clone = (Level)super.clone();

		clone.comingZombiesList = new ArrayList<Character>();
		for(Character a: comingZombiesList){
			clone.comingZombiesList.add((Character) a.clone());
		}
		clone.CharacterList = new ArrayList<Character>();
		for(Character a: CharacterList){
			clone.CharacterList.add((Character) a.clone());
		}

		clone.level = this.level;

		return clone;
	}

	public int getLevel() {
		return level;
	}
}