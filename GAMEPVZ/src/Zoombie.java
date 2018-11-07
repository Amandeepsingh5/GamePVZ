import java.util.*;

/**
 * This class creates different type of zoombies
 * 
 * @author zoha mehdi
 *
 */
public class Zoombie implements GameEntity {
	
	private String description; //Type of zoombie
	private int health; //Zoombie health
	private int lawn_distance; //distance Zoombie has to cover to get the house 
	
	private ArrayList<String> zoombieArr = new ArrayList<>(); //Stores zoombies
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
	/**]
	 * gets a zoombies health
	 * @return
	 */
	public int getHeath() {
		
		return health;
	}
	

	public void takeDamage(int attack) {
		health -= attack;
		
	}
	
	public Action gameFunction(){
		return null;
	}
	
	
	
	
	
	
	
}
