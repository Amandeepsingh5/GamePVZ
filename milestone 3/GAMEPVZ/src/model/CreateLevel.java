package model;

import java.util.ArrayList;
import java.util.Observable;


public class CreateLevel extends Observable{

	private ArrayList<Character> zombies;
	private int _level;

	public CreateLevel(int level){
		this._level = level;
		zombies = new ArrayList<Character>();
	}

	/**
	 * Removes a zombie from the ArrayList by decresing the size
	 * then sets the change and notifies the observer
	 */
	public void takeZombie(){
		zombies.remove(zombies.size() - 1);
		this.setChanged();
		notifyObservers();
	}

	/**
	 * Checks the string if the appropriate zombie is being asked for and adds it
	 * @param string - the string that tells if it is a zombie or not
	 */
	public void putZombie(String string){
		MainZombie zombie = null;
		if(string.equals("BasicZombie")){
			zombie = new BasicZombie(_level);
		}
		else if (string.equals("explosivezombie")){
			zombie = new ExplosiveZombie(_level);
		}
		else if(string.equals("polezombie")){
			zombie = new PoleZombie(_level);
		}
		if(zombie != null){
			zombies.add(zombie);
		}
		this.setChanged();
		notifyObservers();
	}

	/**
	 * Returns the level info which consists of the ArrayList of Zombies
	 * @return the level info which consists of the ArrayList of Zombies
	 */
	public Level showLevel(){
		Level Levelinfo = new Level(_level);
		Levelinfo.setcomingZombiesList(zombies);
		return Levelinfo;
	}
}
