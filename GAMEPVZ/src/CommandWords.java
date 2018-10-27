/**
 * The CommandWords class has the Arraylist of the valid commands in the game and checks that if the command 
 * being entered is a valid command or not
 * @author Amandeep Singh
 *
 */

public class CommandWords{
	
    // a constant array that holds all valid command words
	
    private static final String[] validCommands = {
    "DropPeashooter", "DropSunflower", "Shoot","Sunpoints" ,"DropCherrybomb","Replay", "Quit"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * 
     * @param aString The String to check
     * @return true if it is valid, false otherwise
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Return all valid commands.
     *  
     * @return a String containing all valid commands
     */
    public String getCommandList() 
    {
        String s = "";
        for(String command: validCommands) {
            s += command + "  ";
        }
        return s;
    }
}
