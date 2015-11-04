/**
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 3
 * Database Class: Stores and searches Entry Objects
 */
import java.util.*;
public class NewDatabase
{
    private LinkedList<NewEntry> entryList;

    /*
    Method: Database - constructor
    Purpose: Scans the input file and creates an Entry object
                for each line with data
    Parameters:
        Scanner inputScanner:    scanner of the file being parsed
    Returns:
        Database           the object created by parsing the file
    */
    public NewDatabase(Scanner inputScanner)
    //takes a scanner so main can handle file exceptions
    //also so only main has to deal with i/o
    {
        if(!inputScanner.hasNextLine())
        {
            //sets head to null if file is empty
            entryList = null;
        }
        while (inputScanner.hasNextLine())
        {
            //a new entry object parsed from the line of text
            NewEntry newEntry = parseInputLine(inputScanner.nextLine());
            //checks to see if entry is empty
            if (!(newEntry == null))
            {
                //adds the word to the database in alphabet order
                addEntryInOrder(newEntry);
            }
        }
    }

    private NewEntry parseInputLine(String line)
    {
        if (line.equals(""))
        {
            //returns a null object if the line is empty
            return null;
        }

        //a new empty Entry object
        NewEntry returnEntry = new NewEntry();
        //Scanner to scan the line of text
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("/");
        //sets the entry's word
        //
        returnEntry.setWord(lineScanner.next());

        while (lineScanner.hasNext())
        {
            //the next word in the line
            String nextWord = lineScanner.next();
            if (!(nextWord == null))
            {
                //adds each word in alphabet order to the
                //synonym linkedList
                returnEntry.addSynonymInOrder(nextWord);
                //might not have any synonyms
            }
        }
        //returns the finished entry object
        return returnEntry;
    }

    public boolean addEntryInOrder(NewEntry newEntry)
    {

    }
}
