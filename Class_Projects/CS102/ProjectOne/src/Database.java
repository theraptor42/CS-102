/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 1
    Database Class: Stores and searches Entry Objects
*/
import java.util.*;
public class Database //the thesaurus is the database of entries
{
    private Entry [] database;
    //database holds an array of entries


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
        database = new Entry [1];
        //gives it size one as an initial value
        int counter = 0;
        while (inputScanner.hasNextLine())
        {
            String nextLine = inputScanner.nextLine();
            if (nextLine.equals(""))
            {}//skips empty lines
            else
            {
                if (counter == database.length) {
                    Entry[] bigger = Arrays.asList(database)
                            .toArray(new Entry[database.length + 1]);
                    //increases the size of database by one
                    //so I don't have null elements
                    // which will break my toString()
                    database = bigger;
                }
                database[counter] = new Entry(nextLine);
                //sends the next scanner line to make a new entry
                counter++;
            }
        }
    }

    /*
    Method: searchForWord - database search
    Purpose: Searches database for matching word
                and returns the results of the search
    Parameters:
        String word      the word to be found
    Returns:
        String        What we found/not found
    */
    public String searchForWord(String word)
    {
        for (int i = 0; i < database.length; i++)
        {
            //runs through all the entry objects in the database
            if (database[i].getWord().equalsIgnoreCase(word))
            {
                String wordFound = database[i].toString();
                return wordFound;
                //if it finds the word, breaks out and returns it
            }
        }
        //else it sends back a failure message
        String searchFailed = "Sorry, I could not find \"" + word + "\"";
        return searchFailed;
    }

    /*
    Method: searchForSynonym - database search
    Purpose: Searches each entry database for matching
                synonym and returns the results of the search
    Parameters:
        String synonym      the synonym to be found
    Returns:
        String        What we found/not found
    */
    public String searchForSynonym(String synonym)
    {
        String returnString = "";
        for (int i = 0; i < database.length; i++)
        {
            //loops through each entry object to scan list of synonyms
            String [] synonymList = database[i].getSynonymsList();
            for (int j = 0; j < synonymList.length; j++)
            {
                if (synonym.equalsIgnoreCase(synonymList[j]))
                {
                    //if it finds an entry with that synonym
                    //it adds it to the return string
                    returnString += database[i].toString() + "\n";
                }
            }
        }
        if (returnString.equals(""))
        {
            //if no synonyms are found, sends back failure message
            returnString = "Sorry, I could not find any words " +
                    "with a synonym \"" + synonym + "\"";
        }

        return returnString;
    }

    /*
    Method: toString - toString
    Purpose: Returns a formatted string containing the useful
                information contained by this Database object
    Parameters:
        none
    Returns:
        String           Formatted string with word and synonyms
                            from eah entry object
    */
    public String toString()
    {
        //uses the entry's toString
        //loops through each entry and adds it toString to the return
        String returnString = "";
        for (int i =0; i < database.length; i++)
        {
            returnString += database[i].toString()+"\n";
        }
        return returnString;
    }
}
