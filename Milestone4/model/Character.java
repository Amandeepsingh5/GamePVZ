package model;

import java.io.Serializable;


@SuppressWarnings("serial")
public abstract class Character implements Cloneable, Serializable {

	// health of the Characterif it is dead or alive
	protected boolean health;
	// Current Health of the Actor
	protected int currentHealth;
	// Maximum health of the Actor
	protected int maximumHealth;
	// The string/graphical representation of the Actor
	protected String string;
	// The level of the Characterbased on the level of the game
	protected int level;		
	// True if the Characteris allied with the player
	protected boolean isPlant;	//TODO see if this can be removed
	// True if current health is less than 40% of max health
	protected boolean cracked;
	// The graphical representation of the Actor
	protected String sprite;
	
	protected int x;
	protected int y;
	
	/**
	 * Constructor for class Actor, usually only used by sub classes
	 * @param maximumHealth
	 * @param level
	 * @param string
	 */
	public Character(int maximumHealth,
			int level, String string, boolean isPlant, String sprite){
		super();
		this.health = true;
		this.currentHealth = maximumHealth;
		this.maximumHealth = maximumHealth;
		this.string = string;
		this.level = level;
		this.isPlant = isPlant;
		this.cracked = false;
		this.sprite = sprite;
	}
	/**
	 * This method defines the activity that any given plant can do during the game
	 * @return
	 */
	 abstract public int action(Level grid);
	 
	
	
	/**
	 * Returns current Health
	 * @return int
	 */
	public int getcurrentHealth() {
		return currentHealth;
	}
	/**
	 * Returns Maximum Health
	 * @return int
	 */
	public int getmaximumHealth() {
		return maximumHealth;
	}
	/**
	 * Reduces the currentHealth of the Character by integer amount specified in damage
	 * @param damage - is the taken by Character
	 * @return currentHealth
	 */
	public int takeDamage(int damage) {
		
		currentHealth = currentHealth - damage;
		
		if (currentHealth < (maximumHealth * 0.4) && !this.cracked){
			this.cracked = true;
		}
		if (currentHealth <= 0) {
			die();
		}
		return currentHealth;
	}
	
	/**
	 * Die method for the actor, changes the health of the Characterto false
	 */
	private void die() {
		health = false;
		currentHealth = 0;
		//TODO remove from board
	}
	

	/**
	 * @return health that is true if its alive, otherwise false if its dead
	 */
	public boolean isAlive() {
		return health;
	}
	
	/**
	 * @return Sprite representation of the actor
	 */
	public String toString(){
		return string;
	}
	/**
	 * @return the sprite
	 */
	public String getSprite() {
		return sprite;
	}
	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
	/**
	 * @return isPlant allegience of actor. True for plants, false for zombies
	 */
	public boolean isPlant(){
		return isPlant;
	}
	/**
	 * @return True if current health is less than 40% of max health, false otherwise
	 */
	public boolean isCracked() {
		return cracked;
	}
	
	/**
	 * @return x coordinate
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * @return y coordinate
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Sets the x, y coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the x,y coordinates have been set
	 */
	public boolean setXY(int x, int y){
		this.x = x;
		this.y = y;
		return true;
	}
	
	/**
	 * Checks the x, y coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the x,y coordinates is at a certain x,y coordinate
	 */
	public boolean isAt(int x, int y){
		
		return (this.x == x & this.y == y);
	}
	
	/**
	 * Clones everything about a Character
	 * @return clone of the Character
	 */
	public Object clone()throws CloneNotSupportedException{
		Character clone = (Character)super.clone();
		clone.health = this.health;
		clone.isPlant = this.isPlant;
		clone.cracked = this.cracked;
		clone.currentHealth = this.currentHealth;
		clone.maximumHealth = this.maximumHealth;
		clone.level = this.level;
		clone.sprite = new String(this.sprite);
		clone.string = new String(this.string);
		clone.x = this.x;
		clone.y = this.y;
		return clone;
	}
}