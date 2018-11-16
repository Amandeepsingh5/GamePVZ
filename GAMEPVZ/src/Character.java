package model;

import java.io.Serializable;

public abstract class Character implements Cloneable, Serializable {

	// Status of the Character if it is dead or alive
		public boolean health;
		// Current Health of the Character
		public int currentHealth;
		// Maximum health of the Character
		public int maximumHealth;
		// The string/graphical representation of the Character
		public String string;
		// The level of the Character based on the level of the game
		public int level;		
		// True if current health is less than 40% of max health
		public boolean damaged;
		
		public boolean isplant;
		// The graphical representation of the Character
		public String picture;
	
	protected int x;
	protected int y;
	
	/**
	 * Constructor for class Character, usually only used by sub classes
	 * @param maxHealth
	 * @param level
	 * @param string
	 */
	public Character(int maxHealth,
			int level, String string, boolean isplant, String picture){
		super();
		this.health = true;
		this.currentHealth = maxHealth;
		this.maximumHealth = maxHealth;
		this.string = string;
		this.level = level;
		this.isplant = isplant;
		this.damaged = false;
		this.picture = picture;
	}
	/**
	 * This method defines the activity that any given plant can do during the game
	 * @return
	 */
	 abstract public int action(Level grid);
	 
	
	
	/**
	 * @return current Health
	 */
	public int getCurrHealth() {
		return currentHealth;
	}
	/**
	 * @return Maximum Health
	 */
	public int getMaxHealth() {
		return maximumHealth;
	}
	/**
	 * Reduces the currHealth of the Character by integer amount specified in damage
	 * @param damage
	 * @return currentHealth
	 */
	public int takeDamage(int damage) {
		currentHealth = currentHealth - damage;
		if (currentHealth < (maximumHealth * 0.4) && !this.damaged){
			this.damaged = true;
		}
		if (currentHealth <= 0) {
			die();
		}
		return currentHealth;
	}
	
	/**
	 * Die method for the Character, changes the status of the Character to false
	 */
	private void die() {
		health = false;
		currentHealth = 0;
		//TODO remove from board
	}
	

	/**
	 * @return status that is true if its alive, otherwise false if its dead
	 */
	public boolean isAlive() {
		return health;
	}
	
	/**
	 * @return Sprite representation of the Character
	 */
	
	/**
	 * @return the sprite
	 */
	public String toString(){
		return string;
	}
	
	public String getPicture() {
		return picture;
	}
	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(String sprite) {
		this.picture = picture;
	}
	/**
	 * @return Friendly allegience of Character. True for plants, false for zombies
	 */
	public boolean isFriendly(){
		return isplant;
	}
	/**
	 * @return True if current health is less than 40% of max health, false otherwise
	 */
	public boolean isCracked() {
		return damaged;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean setXY(int x, int y){
		this.x = x;
		this.y = y;
		return true;
	}
	
	public boolean isAt(int x, int y){
		return (this.x == x & this.y == y);
	}
	
	public Object clone()throws CloneNotSupportedException{
		Character clone = (Character)super.clone();
		clone.health = this.health;
		clone.isplant = this.isplant;
		clone.damaged = this.damaged;
		clone.currentHealth = this.currentHealth;
		clone.maximumHealth = this.maximumHealth;
		clone.level = this.level;
		clone.picture = new String(this.picture);
		clone.string = new String(this.string);
		clone.x = this.x;
		clone.y = this.y;
		return clone;
	}
}
