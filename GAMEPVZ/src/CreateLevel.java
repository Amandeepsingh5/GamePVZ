package model;

import java.util.ArrayList;
import java.util.Observable;


public class CreateLevel extends Observable{

	private int _level;
	private ArrayList<Character> zombies;
	
	public CreateLevel(int level){
		
		this._level = level;
		zombies = new ArrayList<Character>();
		

	}
	public void takeZombie(){
		zombies.remove(zombies.size() - 1);
		this.setChanged();
		notifyObservers();
		}
		
		public void putZombie(String string){
			Zombie zombie = null;
			if(string.equals("ExplosiveZombie")){
				zombie = new ExplosiveZombie(_level);
			}
			if(zombie != null){
				zombies.add(zombie);
			}
			this.setChanged();
			notifyObservers();
		}

		public Level showLevel(){
			Level levelinfo = new Level(_level);
			levelinfo.setcomingZombiesList(zombies);
			return levelinfo;
		}
		


	}
