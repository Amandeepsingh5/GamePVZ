import java.util.*;

import model.Character;
import model.Level;

/**
 * This class creates different type of Zombies
 * 
 * @author zoha mehdi
 *
 */
public class Zoombie {
	
	private String description; //Type of zombie
	private int health; //zombie health
	private int lawn_distance; //distance zombie has to cover to get the house 
	private ArrayList<String> zoombieArr = new ArrayList<>(); //Stores zombies
	private int attack;

	/**
	 * Creating zoombie
	 * @param decription - type of zoombie
	 * @param health - health assigned to each type of zoombie
	 */
	public Zoombie(String decription, int health, int attack) {
		this.description = description;
		this.health = health;
		this.attack = attack;
	}
	/**
	 * This method returns the Zomie Health
	 * @return
	 */
	public int getHeath() {
		return health;
	}
	
	public void decrementHealth(int attack) {
		health -= attack;	
	}
	
	public void attack(Zoombie zoombie, int health) {
		zoombie.decrementHealth(attack);
	}
protected abstract void attack(Character Character);
	 protected int move(Level grid) {
		
		 if(grid.fieldDimension(x-1, y)){
			if(grid.plantAt(this.x - 1, this.y)){
				return 0;
			}
			else {
				
				this.x = this.x -1;
				
				
				return 1;
			}
		 }
		 else{
			 return -1;
		 }
	}
	
	
	
	
	
	
	
	
}
