import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *   
 * The parser reads the user input that is the reason we are importing the scanner class from java util package.
 * Everytime it is called it reads a line from the terminal and tries to interpret the lines as two word command
 *.It returns command as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * /@version 2006.03.30
 * 
 * @author Amandeep Singh
 * /@version October 26,2018
 * 
 * 
 * 
 */

public class Parser 
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Get the command from the user.
     * 
     * @return The next command from the user
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;  // set the word1 to null
        String word2 = null;  // set the word2 to null

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }

    /**
     * Returns a list of valid command words.
     * 
     * @return a list of valid command words.
     */
    public String getCommands()
    {
        return commands.getCommandList();
    }
}
