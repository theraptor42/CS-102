import java.io.*;
import java.util.*;

/**
 * Created by Caspian on 11/3/2015.
 */
public class prog3
{
    /*
    Method: main
    Purpose: controls the runtime of the program
    Parameters:
        Database args   String array of input arguments
    Returns:
        none
    */
    public static void main(String [] args)
    {
        if (args.length != 1)
        {
            //breaks if there isn't exactly one input
            System.out.println("Sorry, your input seems incorrect");
            System.out.println("You should have exactly one argument" +
                    " \nExiting now");
            System.exit(0);//terminates current virtual machine
            //because it can't really do anything without file io yet
        }

        try
        {
            //the file containing the thesaurus information
            File inputFile = new File(args[0]);
            //Scanner of the input file, to be passed to the database
            Scanner inputScanner = new Scanner(inputFile);
            //thesaurus contains all of the data parsed from the test file
            Database thesaurus = new Database(inputScanner);
            //makes my database
            //sends the database a scanner so only main  deals with file io
            mainMenu(thesaurus);//opens the main menu
        }
        catch (FileNotFoundException notFoundObject)
        {
            System.out.println("Sorry, I could not find that file" +
                    "\nExiting now");
            System.exit(0);//terminates current virtual machine
        }
    }
}
