/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 3
 * Database Class: Stores and searches Entry Objects
 */
import java.util.*;
public class Database
{
    private LinkedList<Entry> entryList;
    //built in generics LinkedList of entry objects

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
            //I don't want a null, so its initialized as an empty list
            entryList = new LinkedList<Entry>();
        }
        while (inputScanner.hasNextLine())
        {
            //a new entry object parsed from the line of text
            Entry newEntry = parseInputLine(inputScanner.nextLine());
            //checks to see if entry is empty
            //null is specifically only from parseInputLine
            if (!(newEntry == null))
            {
                //adds the word to the database in alphabetical order
                addEntryInOrder(newEntry);
            }
        }
    }



    /*
    Method: isEmpty
    Purpose: checks if entryList is null or has length 0
    Parameters:
        none
    Returns:
        boolean - is this empty?
    */
    public boolean isEmpty()
    {
        //this method is used to check length
        //replacing head == null so I don't have to maintain a head
        //also error checks for null lists
        return (entryList == null || (entryList.size() == 0));
        //just doing .size() == 0 will raise a null pointer exception on occasion
    }

    /*
    Method: hasWord
    Purpose: checks if entryList has an entry with specified string
    Parameters:
        String wordSearched - the word I'm looking for
    Returns:
        boolean - is it there?
    */
    public boolean hasWord(String wordSearched)
    {
        if (this.isEmpty())
        {
            //checks for null and empty lists
            return false;
        }
        //current entry in the linked list
        Entry current;
        //position on the linked list
        int index = 0;
        while (index < entryList.size())
        {
            current = entryList.get(index);
            if (current.getWord().equalsIgnoreCase(wordSearched))
            {
                //the current word matches the searched word
                return true;
            }
            index++;

        }
        //I didn't find it in the list
        return false;

    }

    /*
    Method: getIndexOfWord
    Purpose: finds the location of a specified string
    Parameters:
        String wordSearched - the word I'm looking for
    Returns:
        int - where did I find it?
    */
    public int getIndexOfWord(String wordSearched)
    {
        //returns -1 if not found
        if (this.isEmpty())
        {
            //this was designed to always only follow a hasWord
            //returns a -1 to throw an index out of bounds if I messed up elsewhere in the code
            return -1;
        }

        //finds the entry exactly the same way as hasWord, just returns an index
        //current entry in the linked list
        Entry current;
        //position on the linked list
        int index = 0;
        while (index < entryList.size())
        {
            current = entryList.get(index);
            if (current.getWord().equalsIgnoreCase(wordSearched))
            {
                //the current word matches the searched word
                return index;
            }
            index++;

        }
        //I didn't find it in the list
        //and my code is broken
        return -1;
    }


    /*
    Method: addEntryInOrder - add to linkedList
    Purpose: add an entry to the linked list
            in alphabetical order
    Parameters:
        Entry newEntry  the entry being added
    Returns:
        boolean - did I add it successfully
    */
    public boolean addEntryInOrder(Entry newEntry)
    {
        if (this.isEmpty())
        {
            //if its empty, initializing as a new list won't hurt
            //catches slippery null lists
            entryList = new LinkedList<Entry>();
            entryList.add(newEntry);
            return true;
        }


        //current position in list
        int index = 0;
        //current word in list
        String current;
        //the word from the entry I'm adding, assumes its valid
        String newWord = newEntry.getWord();

        if (this.hasWord(newWord))
        {
            //the entry already exists
            return false;
        }

        while(index < entryList.size())
        {
            current = entryList.get(index).getWord();

            if (newWord.compareToIgnoreCase(current) < 0)
            {
               //the new word goes before the current word
                entryList.add(index, newEntry);
                return true;
            }
            else if (newWord.compareToIgnoreCase(current) == 0)
            {
                return false;
                //word already exists in database
            }
            //move on to the next one
            index++;

        }

        //if it comes after everything in the database
        entryList.add(newEntry);
        return true;//woohoo we did it

    }

    /*
    Method: searchForWord - database search
    Purpose: Searches database for matching word
                and returns the results of the search
    Parameters:
        String wordSearched      the word to be found
    Returns:
        String        What we found/not found
    */
    public String searchForWord(String wordSearched)
    {
        if (this.isEmpty())
        {
            //can't search an empty list
            return "There are no entries to search";
        }
        if ( wordSearched.equals(""))
        {
            //can't search for an empty string
            return ("I can't search for nothing");
        }
        if (this.hasWord(wordSearched))
        {
            //current position in list
            int index = 0;
            //current entry in the linked list
            Entry current = entryList.get(index);
            while (!current.getWord().equalsIgnoreCase(wordSearched))
            {
                //cycle till I get the one I want
                index++;
                current = entryList.get(index);
            }
            //found it
            return current.toString();
        }

        //I couldn't find it
        return ("I can't find: \"" + wordSearched+ "\"");
    }

    /*
    Method: searchForSynonym - database search
    Purpose: Searches each entry database for matching
                synonym and returns the results of the search
    Parameters:
        String synSearchedFor      the synonym to be found
    Returns:
        String        What we found/not found
    */
    public String searchForSynonym(String synSearchedFor)
    {
        if (this.isEmpty())
        {
            return "There are no entries to search";
        }
        //the String being returned
        String returnString = "";
        if (synSearchedFor.equals(""))
        {
            return ("I can't search for nothing");
        }
        //the current position in the linked list
        int entryIndex = 0;
        //the current entry in the linked list
        Entry current;
        while (entryIndex < entryList.size())
        {
            current = entryList.get(entryIndex);
            if (current.hasSynonym(synSearchedFor))
            {
                //if I find it, return it's info
                returnString += current.toString();
            }
            entryIndex++;
        }

        if (returnString.equals(""))
        {
            //I didn't find it
            returnString = "I could not find: \"" + synSearchedFor + "\"";
        }
        return returnString;
    }

    /*
    Method: addEntryFromMenu - database addition
    Purpose: adds a new entry to the database
    Parameters:
        String newWord      the word to be added
    Returns:
        boolean        did we add it?
    */
    public boolean addEntryFromMenu(String newWord)
    {
        if (this.hasWord(newWord))
        {
            return false;
        }
        else
        {
            //a new blank entry
            Entry newEntry = new Entry();
            //adds my new word tothe entry
            newEntry.setWord(newWord);
            //insert the new entry to the list
            this.addEntryInOrder(newEntry);
            return true;
        }
        //System.out.println("You broke logic");
        //#unreachable
    }

    /*
    Method: addSynonymFromMenu - database addition
    Purpose: adds a synonym to an existing entry
    Parameters:
        String wordToAddTo      the word to update
    Returns:
        none - the results are printed here
    */
    public void addSynonymFromMenu(String wordToAddTo)
    {
        if (wordToAddTo.equals(""))
        {
            //if the word is empty go back to caller
            System.out.println("\nPlease type a valid word\n");
            return;
        }

        //checks whether the word is in the database and gets it
        if (!this.hasWord(wordToAddTo))
        {
            //if the word isn't there, go back to caller
            System.out.println("Sorry, I could not find that word in the thesaurus\n");
            return;
        }
        Entry entryToModify = entryList.get(getIndexOfWord(wordToAddTo));

        //controls if the loop is repeated
        boolean repeatCheck = true;
        while(repeatCheck)
        {
            System.out.println("What synonym would you like " +
                    "to add to the word: " + wordToAddTo);
            System.out.print(">> ");
            //Scanner to take user input
            Scanner inputScanner = new Scanner(System.in);
            //the synonym to be added
            //will accept spaces in words
            String userInput = inputScanner.nextLine();

            if (userInput.equals(""))
            {
                System.out.println("Sorry, I can't add nothing\n");
                //jump down to loop control
            }
            else
            {
                //checks to see if the entry already has that synonym

                if (entryToModify.hasSynonym(userInput))
                    System.out.println(wordToAddTo + " already has that synonym\n");
                else
                {
                    //adds the synonym to the entry
                    entryToModify.addSynonymInOrder(userInput);
                    System.out.println(userInput + " was added to the entry\n");
                }
            }

            //loop control menu
            System.out.println("\nWould you like to add another synonym?");
            System.out.print("type (yes/no) >>");
            //does the user want to add another entry?
            String userResponse = inputScanner.next();
            if (userResponse.equalsIgnoreCase("yes"))
            {}
            else
            {
                System.out.println("\nGoing back to the main menu\n");
                repeatCheck = false;
            }
        }
    }


    /*
    Method: removeEntryFromMenu - database removal
    Purpose: interface between menu and actual remove entry method
    Parameters:
        String removeMe      the word to remove
    Returns:
        boolean - did I do it?
    */
    public boolean removeEntryFromMenu(String removeMe)
    {
        //removeEntry is farther on down, just before the toString
        if (removeEntry(removeMe))
        {
            //If I removed it successfully, print out success
            System.out.println(removeMe + " has been removed from the thesaurus");
            return true;
        }
        else
        {
            //removeEntry failed
            System.out.println("I could not find an entry: " + removeMe + "\n");
            return false;
        }
    }

    /*
    Method: removeSynonymFromMenu - database removal
    Purpose: removes a synonym from an existing entry
    Parameters:
        String wordToRemove      the word to remove a synonym from
    Returns:
        none
    */
    public void removeSynonymFromMenu(String wordToRemoveFrom)
    {
        if (wordToRemoveFrom.equals(""))
        {
            //if the word is empty go back to caller
            System.out.println("\nPlease type a valid word\n");
            return;
        }

        //checks whether the word is in the database and gets it
        if (!this.hasWord(wordToRemoveFrom))
        {
            //if the word isn't there, go back to caller
            System.out.println("Sorry, I could not find that word in the thesaurus\n");
            return;
        }
        //if the entry exists, get the entry using its index
        Entry removeFromThis = entryList.get(getIndexOfWord(wordToRemoveFrom));

        //loop control, will loop till user does not say "yes" at end
        boolean repeatCheck = true;
        while(repeatCheck)
        {
            System.out.println("What synonym would you like " +
                    "to remove from the word: " + wordToRemoveFrom);
            System.out.print(">> ");
            //Scanner to take user input
            Scanner inputScanner = new Scanner(System.in);
            //the synonym to be added
            //will accept spaces in words
            String userInput = inputScanner.nextLine();

            if (userInput.equals("")) {
                System.out.println("Sorry, I can't remove nothing\n");
                //jump down to loop control
            }
            else
            {

                if (!removeFromThis.hasSynonym(userInput))
                {
                    //if the word does not have the synonym skip down to loop control
                    System.out.println(wordToRemoveFrom + "does not have that synonym\n");
                }
                else
                {
                    //removes the synonym
                    removeFromThis.removeSynonym(userInput);
                    System.out.println(userInput + " was removed from the synonyms of " + wordToRemoveFrom + "\n");
                }
            }

            //loop control menu
            System.out.println("\nWould you like to remove another synonym?");
            System.out.print("type (yes/no) >>");
            //does the user want to add another entry?
            String userResponse = inputScanner.next();
            if (userResponse.equalsIgnoreCase("yes"))
            {}
            else
            {
                System.out.println("\nGoing back to the main menu\n");
                repeatCheck = false;
            }
        }
    }

    /*
    Method: removeEntry - database removal
    Purpose: removes an entry from the database
    Parameters:
        String removeMe      the word to remove
    Returns:
        boolean - did I remove it?
    */
    public boolean removeEntry(String removeMe)
    {
        //if the word is in the database
        if (this.hasWord(removeMe))
        {
            //current position int the linked list
            int index = 0;
            //current entry in the linked list
            Entry current;

            while (index < entryList.size())
            {
                current = entryList.get(index);
                if (current.getWord().equalsIgnoreCase(removeMe))
                {
                    //when I find it, remove it
                    entryList.remove(index);
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    /*
    Method: toString
    Purpose: sends the database to a string
    Parameters:
        none
    Returns:
        String - the relevant data
    */
    public String toString()
    {
        if (this.isEmpty())
        {
            //the thesaurus is empty
            return "\nThere are no entries in the thesaurus\n";
        }
        //the accumulating string being returned
        String returnString = "\n";
        //current position in the linkedList
        int index = 0;
        //current entry in the linkedList
        Entry current;
        while (index < entryList.size())
        {
            //for each entry add its toString
            current = entryList.get(index);
            returnString += current.toString() + "\n";
            index++;
        }

        return returnString;
    }
}
