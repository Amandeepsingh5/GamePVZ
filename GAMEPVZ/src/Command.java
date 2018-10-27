/*
 * The Command class check converts the command we have entered and returns it back as a string.
 */
public class Command
{
    private String commandWord;
    private String secondWord;
    
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * 
     * @param firstWord The first word of the command. Null if the command was not recognised
     * @param secondWord The second word of the command
     */
<<<<<<< HEAD
    public Command(String firstWordIn, String secondWordIn)
=======
    
    public Command(String firstWord, String secondWord)
>>>>>>> 8d9215bea0da8198fe7ee825b9a27b7b1d8aeba4
    {
        commandWord = firstWordIn;
        secondWord = secondWordIn;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * 
     * @return The command word, or null if not understood
     */
    
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Returns the second word of the command.  Returns null if there was no
     * second word.
     * 
     * @return The second word of this command, or null if only one word
     */
    
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Returns true if the command is unknown.
     * 
     * @return true if this command was not understood, false otherwise
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * Returns true if the command has a second word.
     * 
     * @return true if the command has a second word, false otherwise
     */
    
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

