/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 1
    Database Class: Stores and searches Entry Objects
*/
import java.util.*;
public class Database //the thesaurus is the database of entries
{
    private Entry head;
    //head is the first node of the LinkedList of Entry objects


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
            head = null;
        }
        while (inputScanner.hasNextLine())
        {
            //a new entry object parsed from the line of text
            Entry newWord = parseInputLine(inputScanner.nextLine());
            if (!(newWord == null))
            {
                //adds the word to the database in alphabet order
                addWordInOrder(newWord);
            }
        }
    }

    /*
    Method: parseInputLine - text parser
    Purpose: parse the line of text and return an entry object
    Parameters:
        String line   the line of text being parsed
    Returns:
        Entry - the Object parsed from the text line
    */
    private Entry parseInputLine(String line)
    {
        if (line.equals(""))
        {
            //returns a null object if the line is empty
            return null;
        }

        //a new empty Entry object
        Entry returnNode = new Entry();
        //Scanner to scan the line of text
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("/");
        //Sets the returnNode's word field
        returnNode.setWord(lineScanner.next());

        while (lineScanner.hasNext())
        {
            //the next word in the line
            String nextWord = lineScanner.next();
            if (!(nextWord == null))
            {
                //adds each word in alphabet order to the
                //synonym linkedList
                returnNode.addSynonymInOrder(nextWord);
                //might not have any synonyms
            }
        }
        //returns the finished entry object
        return returnNode;
    }

    /*
    Method: addWordInOrder - add to linkedList
    Purpose: add an entry to the linked list
            in alphabetical order
    Parameters:
        Entry newEntry  the entry being added
    Returns:
        boolean - did I add it successfully
    */
    public boolean addWordInOrder(Entry newEntry)
    {
        //getting ready to walk down the chain
        //the current entry in the chain
        Entry current = head;
        //the previous entry in the chain
        Entry previous = new Entry();

        //the word in the entry being added
        String newWord = newEntry.getWord();
        if (current == null)
        {
            //adds it if the list is empty
            head = newEntry;
            return true;
        }
        while (current != null)
        {
            //the word in the current entry object on the chain
            String currentWord = current.getWord();
            if (newWord.compareToIgnoreCase(currentWord) < 0)
            {
                //if the newWord comes before the currentWord
                //insert it before it

                //inserts it before the current word
                newEntry.setNextEntry((current));
                //if it becomes the first word in the list
                //previous will be empty
                if(previous.getWord() == null)
                {
                    //previous isn't null because that made
                    //other errors, but the word will be null
                    //if its an empty entry
                    //if it comes before the first word in
                    //the list, insert it at the beginning
                    head = newEntry;
                }
                else
                {
                    //links the previous entry to finish the chain
                    previous.setNextEntry(newEntry);
                }
                //return success
                return true;
            }
            if (newWord.compareToIgnoreCase(currentWord) == 0)
            {
                return false;//synonym already exists
            }

            //move on to next synonym if neither are true
            previous = current;
            current = current.getNextEntry();
        }
        //if it reaches the end of the list,
        //add it to the end of the list
        previous.setNextEntry(newEntry);
        newEntry.setNextEntry(null);
        return true;
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
        if (head == null)
            return "\nThere are no entries in the thesaurus";
        //the current entry in the chain
        Entry current = head;
        while ( current != null)
        {
            if (current.getWord().equalsIgnoreCase(word))
            {
                return current.toString();
            }
            current = current.getNextEntry();
        }
        return "\nI could not find that word in the thesaurus";
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
        if (head == null)
            return "\nThere are no entries in the thesaurus";

        //the current entry in the chain
        Entry current = head;
        //the string with the search results
        String returnString = "";
        while (current != null)
        {
            if (current.searchForSynonym(synonym))
            {
                //if the synonym is found, add it to the results
                returnString += current.toString();
            }
            current = current.getNextEntry();
        }

        if (returnString.equals(""))
            returnString = "\nNo entries with that synonym were found";

        return returnString;//returns the results
    }

    /*
    Method: getEntryByWord - database search
    Purpose: Searches each entry in the linked list
                for a word and returns the results of the search
    Parameters:
        String word      the word to be found
    Returns:
        Entry        What we found/not found
    */
    public Entry getEntryByWord(String word)
    {
        //the entry object to be returned
        Entry returnMe = null;

        //the current entry in the chain
        Entry current = head;

        //if the chain is empty, return null
        if (current == null)
            return null;

        while (current != null)
        {
            if (current.getWord().equalsIgnoreCase(word))
            {
                //break out of the loop if the word is found
                returnMe = current;
                break;
            }
            current = current.getNextEntry();
        }

        return returnMe; //return the results
    }

    /*
    Method: addEntryFromMenu - database addition
    Purpose: adds a new entry to the database
    Parameters:
        String word      the word to be added
    Returns:
        boolean        did we add it?
    */
    public boolean addEntryFromMenu(String word)
    {
        //new entry with the word being added
        Entry newEntry = new Entry(word, null, null);
        //checks whether the entry was added
        //so the caller can print the results
        boolean successCheck = addWordInOrder(newEntry);

        return successCheck;
    }

    /*
    Method: addSynonymFromMenu - database addition
    Purpose: adds a synonym to an existing entry
    Parameters:
        String word      the word to update
    Returns:
        none - the results are printed here
    */
    public void addSynonymFromMenu(String word)
    {
        if (word.equals(""))
        {
            //if the word is empty go back to caller
            System.out.println("\nPlease type a valid word\n");
            return;
        }

        //checks whether the word is in the database and gets it
        Entry userEntry = getEntryByWord(word);

        if (userEntry == null)
        {
            //if the word isn't there, go back to caller
            System.out.println("Sorry, I could not find that word in the thesaurus");
            return;
        }

        //controls if the loop is repeated
        boolean repeatCheck = true;
        while(repeatCheck)
        {
            System.out.println("What synonym would you like " +
                    "to add to the word: " + word);
            System.out.print(">> ");
            //Scanner to take user input
            Scanner inputScanner = new Scanner(System.in);
            //the synonym to be added
            //will accept spaces in words
            String userInput = inputScanner.nextLine();

            if (userInput.equals("")) {
                System.out.println("Sorry, I can't add nothing");
                //jump down to loop control
            }
            else
            {
                //checks to see if the entry already has that synonym
                SynNode checkSynonym = userEntry.getSynNodeBySynonym(userInput);
                if (checkSynonym != null)
                    System.out.println(word + " already has that synonym");
                else
                {
                    //adds the synonym to the entry
                    userEntry.addSynonymInOrder(userInput);
                    System.out.println(userInput + " was added to the entry");
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
    Method: toString -  toString
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
        if (head == null)
            return "\nThere are no entries in the thesaurus\n";
        Entry current = head;
        String returnString = "";
        while ( current != null)
        {
            returnString += current.toString() + "\n";
            current = current.getNextEntry();
        }
        return returnString;
    }
}
