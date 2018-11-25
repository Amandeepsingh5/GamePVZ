package model;

import java.io.Serializable;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class Level implements Cloneable, Serializable{
	//The dimensions of the level
	public static final int M_Y = 6;
	public static final int M_X = 12;

	private ArrayList<Character> CharacterList;
	private ArrayList<Character> comingZombiesList;
	//grid may be redundant. All the positional information in it is also stored in CharacterList.
	private int level;

	public Level(int level) {
		this.level = level;
		CharacterList = new ArrayList<Character>();
		comingZombiesList = new ArrayList<Character>();

		for(int x = 0; x < (5 + level); x++){
			getcomingZombiesList().add(new BasicZombie(level)); 			//add some basic zombies
		}
		for(int x = 0; x < (level); x++){
			getcomingZombiesList().add(new PoleZombie(level)); 			//add some pole-vault zombies
		}
		for(int x = 0; x < (level+2); x++){
			getcomingZombiesList().add(new ExplosiveZombie(level)); 	//add some exploding zombies
		}
	}

	/**
	 * Returns the list of all the Characters
	 * @return CharacterList -a list of all the Characters
	 */
	public ArrayList<Character> getCharacterList() {
		return CharacterList;
	}

	/**
	 * Gets all Characters that are currently alive. We don't remove dead Characters, just sort of ignore them.
	 * @return all Characters that are in play and alive
	 */
	public ArrayList<Character> getLivingCharacters(){
		ArrayList<Character> liveOnes = new ArrayList<Character>();
		for(Character a: CharacterList){
			if(a.isAlive()){
				liveOnes.add(a);
			}
		}
		return liveOnes;
	}

	/**
	 * Returns the incoming zombies for the level
	 * @return comingZombiesList the comingZombiesList to set
	 */
	public ArrayList<Character> getcomingZombiesList() {
		return comingZombiesList;
	}

	/**
	 * Creates the incoming zombies for the level
	 * @param comingZombiesList the comingZombiesList to set
	 */
	public void setcomingZombiesList(ArrayList<Character> comingZombiesList) {
		this.comingZombiesList = comingZombiesList;
	}
	/**
	 * Checks if there is a Character at the given coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if there is a Character at the given coordinates
	 */
	public boolean CharacterAt(int x, int y){

		for(Character a: CharacterList){

			if(a.isAt(x, y) && a.isAlive()){

				return true;
			}
		}
		return false;
	}

	/**
	 * Checks the coordinates for an alive Zombie
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if there is an alive zombie at the coordinate
	 */
	public boolean loc_zombie(int x, int y){
		for(Character a: CharacterList){
			if(a.isAt(x, y)){
				if(!a.isPlant() && a.isAlive()){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Adds a new Character to the level at a certain position. Position is stored in the Character, and in the grid.
	 * Character is also enrolled in the CharacterList
	 * @param newCharacter- the new Character
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the newCharacter has been set in the x, y coordinate and added to the character list
	 */
	public boolean addChar(Character newCharacter, int x, int y){
		return(newCharacter.setXY(x, y) && CharacterList.add(newCharacter));
	}

	/**
	 * Searches the grid for a plant Character at a position.
	 * Because this information is also stored in Characters, a search of the CharacterList would also work
	 * @param x coordinate
	 * @param y coordinate
	 * @return true is there is an alive plant at the coordinates
	 */
	public boolean plantAt(int x, int y){
		for(Character a: CharacterList){
			if(a.isAt(x,y)){
				if(a.isPlant() && a.isAlive()){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns an ArrayList of all the Characters at the coordinates
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
	 * 	Returns the character at a given coordinate	
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
	 * @return the maxY
	 */
	public int getMaxY() {
		return M_Y;
	}

	/**
	 * @return the maxX
	 */
	public int getMaxX() {
		return M_X;
	}

	/**
	 * Checks if the coordinates are within the bounds of the level
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the coordinates are within the bounds of the level
	 */
	public boolean fieldDimension(int x, int y){
		return(x >= 0 && x < M_X && y >= 0 && y < M_Y);
	}


	/**
	 * Clones everything about the Level
	 * @return clone of the Level
	 */
	public Object clone() throws CloneNotSupportedException{
		Level clone = (Level)super.clone();
		clone.comingZombiesList = new ArrayList<Character>();
		clone.CharacterList = new ArrayList<Character>();
		for(Character a: comingZombiesList){
			clone.comingZombiesList.add((Character) a.clone());
		}
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