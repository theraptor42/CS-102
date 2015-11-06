/**
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 3
 * Database Class: Stores and searches Entry Objects
 */
import java.util.*;
public class Database
{
    private LinkedList<Entry> entryList;

    /*
    Method: Database - constructor
    Purpose: Scans the input file and creates an Entry object
                for each line with data
    Parameters:
        Scanner inputScanner:    scanner of the file being parsed
    Returns:
        Database           the object created by parsing the file
    */
    public Database(Scanner inputScanner)
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
            Entry newEntry = parseInputLine(inputScanner.nextLine());
            //checks to see if entry is empty
            if (!(newEntry == null))
            {
                //adds the word to the database in alphabet order
                addEntryInOrder(newEntry);
            }
        }
    }

    private Entry parseInputLine(String line)
    {
        if (line.equals(""))
        {
            //returns a null object if the line is empty
            return null;
        }

        //a new empty Entry object
        Entry returnEntry = new Entry();
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

    public boolean isEmpty()
    {
        return (entryList.size() == 0);
    }

    public boolean addEntryInOrder(Entry newEntry)
    {
        if (this.isEmpty())
        {
            entryList.add(newEntry);
            return true;
        }

        int index = 0;
        String current;
        String newWord = newEntry.getWord();

        while(index > entryList.size())
        {
            current = entryList.get(index).getWord();

            if (newWord.compareToIgnoreCase(current) < 0)
            {
                entryList.add(index, newEntry);
                return true;
            }
            else if (newWord.compareToIgnoreCase(current) == 0)
            {
                return false;
                //word already exists in database
            }

            index++;

        }

        //if it comes after everything in the database
        entryList.add(newEntry);
        return true;

    }
}
