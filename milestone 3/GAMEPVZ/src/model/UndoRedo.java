package model;

import java.util.Stack;

public class UndoRedo {
	public static final int MAX_ROWS = 6;
	public static final int MAX_COLS = 12;
	private static Stack<Level> prevLevel;
	private static Stack<Level> nextLevel;
	private static Stack<Player> prevPlayer;
	private static Stack<Player> nextPlayer;

	public UndoRedo(){
		prevPlayer = new Stack<Player>();
		nextPlayer = new Stack<Player>();
		prevLevel = new Stack<Level>();
		nextLevel = new Stack<Level>();
	}

	/**
	 * Holds onto the previous state of the game by pushing it into a stack
	 * @param presentLevel 
	 * @param presentPlayer
	 */
	public void saveState(Level presentLevel, Player presentPlayer) throws CloneNotSupportedException{
		prevLevel.push((Level) presentLevel.clone());
		prevPlayer.push((Player) presentPlayer.clone());
		nextLevel.clear();		
		nextPlayer.clear();
	}

	/**
	 * Undo level by getting the previous state from the prevLevel stack
	 * @return temp - the previous state of the game
	 */
	public Level undoLevel(){
		Level temp = null;
		if(!prevLevel.isEmpty()){
			temp = prevLevel.pop();
			//printGrid(templist);
			nextLevel.push(temp);
		}
		//System.out.println("Undid\n");
		return temp;
	}

	/**
	 * Undo Player by getting the previous state from the prevPlayer stack
	 * @return temp - the previous state of the game
	 */
	public Player undoPlayer(){
		Player temp = null;
		if(!prevPlayer.isEmpty()){
			temp = prevPlayer.pop();
			//printGrid(templist);
			nextPlayer.push(temp);
		}
		return temp;	
	}

	/**
	 * Redo player by getting the next state from the nextPlayer stack
	 * @return temp - the next state of the game
	 */
	public Player redoPlayer(){
		Player temp = null;
		if(!nextPlayer.isEmpty()){
			temp = nextPlayer.pop();
			//printGrid(templist);
			prevPlayer.push(temp);
		}
		return temp;
	}

	/**
	 * Redo player by getting the next state from the nextLevel stack
	 * @return temp - the next state of the game
	 */
	public Level redoLevel(){
		Level temp = null;
		if(!nextLevel.isEmpty()){
			temp = nextLevel.pop();
			//printGrid(templist);
			prevLevel.push(temp);
		}
		return temp;
	}

	/**
	 * Checks if an undo is possible
	 * @return true if the prevPlayer and prevLevel are not empty
	 */
	boolean canUndo(){
		return(!prevPlayer.isEmpty() && !prevLevel.isEmpty());
	}

	/**
	 * Checks if an redo is possible
	 * @return true if the nextPlayer and nextLevel are not empty
	 */
	boolean canRedo(){
		return(!nextPlayer.isEmpty() && !nextLevel.isEmpty());
	}






}
