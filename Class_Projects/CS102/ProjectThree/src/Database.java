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
        boolean isHead = true;
        if(!inputScanner.hasNextLine())
        {
            //sets head to null if file is empty
            entryList = new LinkedList<Entry>();
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
    public Entry getFirst()
    {
        //I don't have to maintain a "head" variable
        if (entryList == null || entryList.isEmpty())
        {
            return null;
        }
        return entryList.get(0);
    }

    public boolean isEmpty()
    {
        if (entryList == null)
        {
            return true;
        }
        return (entryList.size() == 0);
    }

    public boolean hasWord(String wordSearched)
    {
        if (this.isEmpty())
        {
            return false;
        }
        Entry current;
        int index = 0;
        while (index < entryList.size())
        {
            current = entryList.get(index);
            if (current.getWord().equalsIgnoreCase(wordSearched))
            {
                return true;
            }
            index++;

        }
        return false;

    }

    public int getIndexOfWord(String wordSearched)
    {
        //returns null if not found
        if (this.isEmpty())
        {
            return -1;
        }
        Entry current;
        int index = 0;
        while (index < entryList.size())
        {
            current = entryList.get(index);
            if (current.getWord().equalsIgnoreCase(wordSearched))
            {
                return index;
            }
            index++;

        }
        return -1;
    }


    public boolean addEntryInOrder(Entry newEntry)
    {
        if (this.isEmpty())
        {
            entryList.add(newEntry);
            return true;
        }

        //current position in list
        int index = 0;
        //current word in list
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

    public String searchForWord(String wordSearched)
    {
        if (this.isEmpty())
        {
            return "There are no entries to search";
        }
        if ( wordSearched.equals(""))
        {
            return ("I can't search for nothing");
        }
        if (this.hasWord(wordSearched))
        {
            int index = 0;
            Entry current = entryList.get(index);
            while (!current.getWord().equalsIgnoreCase(wordSearched))
            {
                index++;
                current = entryList.get(index);
            }

            return current.toString();
        }

        return ("I can't find: \"" + wordSearched+ "\"");
    }

    public String searchForSynonym(String synSearchedFor)
    {
        if (this.isEmpty())
        {
            return "There are no entries to search";
        }
        String returnString = "";
        if (synSearchedFor.equals(""))
        {
            return ("I can't search for nothing");
        }
        int entryIndex = 0;
        Entry current;
        while (entryIndex < entryList.size())
        {
            current = entryList.get(entryIndex);
            if (current.hasSynonym(synSearchedFor))
            {
                returnString += current.toString();
            }
            entryIndex++;
        }

        if (returnString.equals(""));
        {
            returnString = "I could not find: \"" + synSearchedFor + "\"";
        }
        return returnString;
    }

    public boolean addEntryFromMenu(String newWord)
    {
        if (this.hasWord(newWord))
        {
            return false;
        }
        else
        {
            Entry newEntry = new Entry();
            newEntry.setWord(newWord);
            this.addEntryInOrder(newEntry);
            return true;
        }
        //System.out.println("You broke logic");
    }

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
            System.out.println("Sorry, I could not find that word in the thesaurus");
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
                System.out.println("Sorry, I can't add nothing");
                //jump down to loop control
            }
            else
            {
                //checks to see if the entry already has that synonym

                if (entryToModify.hasSynonym(userInput))
                    System.out.println(wordToAddTo + " already has that synonym");
                else
                {
                    //adds the synonym to the entry
                    entryToModify.addSynonymInOrder(userInput);
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

    public boolean removeEntryFromMenu(String removeMe)
    {
        if (removeEntry(removeMe))
        {
            System.out.println(removeMe + " has been removed from the thesaurus");
            return true;
        }
        else
        {
            System.out.println("I could not find an entry: " + removeMe);
            return false;
        }
    }

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
            System.out.println("Sorry, I could not find that word in the thesaurus");
            return;
        }
        Entry removeFromThis = entryList.get(getIndexOfWord(wordToRemoveFrom));

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
                System.out.println("Sorry, I can't remove nothing");
                //jump down to loop control
            }
            else
            {

                if (!removeFromThis.hasSynonym(userInput))
                    System.out.println(wordToRemoveFrom + "does not have that synonym");
                else
                {
                    //removes the synonym
                    removeFromThis.removeSynonym(userInput);
                    System.out.println(userInput + " was removed from the synonyms of" + wordToRemoveFrom);
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

    public boolean removeEntry(String removeMe)
    {
        if (this.hasWord(removeMe))
        {
            int index = 0;
            Entry current;
            while (index < entryList.size())
            {
                current = entryList.get(index);
                if (current.getWord().equalsIgnoreCase(removeMe))
                {
                    entryList.remove(index);
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    public String toString()
    {
        if (this.isEmpty())
        {
            return "There are no entries in the thesaurus";
        }
        String returnString = "\n";
        int index = 0;
        Entry current;
        while (index < entryList.size())
        {
            current = entryList.get(index);
            returnString += current.toString() + "\n";
            index++;
        }

        return returnString;
    }
}
