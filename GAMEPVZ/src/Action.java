/**
 * A class that simply holds two integers, one to indentify the action and another to hold it's magnitude(if required, else default to -1)
 * 
 * @author James
 *
 */
public class Action {
	/*Table of Action IDs
	 *  000 - No action
	 *  001 - Move Left, or Attack Left if Occupied
	 *  002 - Generate Sun
	 */
	private int ID;
	private int magnitude;
	public Action(int id, int power) {
		ID = id;
		magnitude = power;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getPower() {
		return magnitude;
	}

}
