/*
    * Caspian Peavyhouse - peav2414@kettering.edu
    * CS-102, Fall 2015
    * Programming Assignment 3
    * Entry Class - stores strings in a linked list
*/
import java.util.*;
public class Entry
{
    private LinkedList<String> wordList;

    /*
    Method: Entry - Constructor
    Purpose: make a blank Entry Object
    Parameters:
        none
    Returns:
        Entry - the entry object I made
    */
    public Entry()
    {
        //not null because null evul
        //(for my methods)
        wordList = new LinkedList<String>();
    }


    /*
    Method: getWord - getter
    Purpose: returns the "word" object at position 0
    Parameters:
        none
    Returns:
        String - the word
    */
    public String getWord()
    {
        if (wordList == null || wordList.size() == 0)
        {
            //if there is no word, the program is broken
            throw new IndexOutOfBoundsException();
        }
        return wordList.getFirst();
        //wordlist.get(0);
    }


    /*
    Method: setWord - setter
    Purpose: sets the "word" at position 0
    Parameters:
        String word - the new word
    Returns:
        none
    */
    public void setWord(String word)
    {
        //setting the word will clear out any garbage
        wordList = new LinkedList<String>();
        wordList.add(word);
    }


    /*
    Method: addSynonymInOrder
    Purpose: adds a word to the list of synonyms
    Parameters:
        String newSynonym - the synonym I want to add
    Returns:
        boolean - did I add it?
    */
    public boolean addSynonymInOrder(String newSynonym)
    {
        if (wordList.size() == 1)
        {
            // if its just the word, add the synonym to the end
            wordList.add(newSynonym);
            return true;
        }
        //current position in the linked list
        int index = 1;
        //current string in the linkedList
        String current;
        //last synonym in the linked list
        String last = getLastSynonym();
        //if it goes after the last synonym, just add it there
        if (newSynonym.compareToIgnoreCase(last) > 0)
        {
            //added to eliminate the longest
            //add operation
            wordList.addLast(newSynonym);
            return true;
        }
        while (index < wordList.size())
        {
            current = wordList.get(index);
            if (newSynonym.compareToIgnoreCase(current) < 0)
            {
                //insert it into the list
                wordList.add(index, newSynonym);
                return true;
            }
            if (newSynonym.compareToIgnoreCase(current) == 0)
            {
                //the synonym is already in the list
                return false;
            }

            index++;
        }

        //because it won't compile without a return here
        //though it should never be reached
        //because the last is checked first
        System.out.println("You reached an non-accessible point: 1\n");
        wordList.addLast(newSynonym);
        return true;
    }


    /*
    Method: getLastSynonym
    Purpose: gets the last synonym in the list
    Parameters:
        none
    Returns:
        String - the last synonym
    */
    public String getLastSynonym()
    {
        if (wordList == null || wordList.size() <= 1)
        {
            //return null if there are no synonyms
            return null;
        }
        return wordList.getLast();
    }

    /*
    Method: hasSynonym
    Purpose: checks to see if the synonym is in the list
    Parameters:
        String synSearched - the synonym being searched for
    Returns:
        boolean - did I find it?
    */
    public boolean hasSynonym(String synSearched)
    {
        if (wordList == null || wordList.isEmpty() || wordList.size() == 1)
        {
            //no synonyms
            return false;
        }
        //current position in list
        int index = 1;
        String current;

        while (index < wordList.size())
        {
            current = wordList.get(index);
            if (current.equalsIgnoreCase(synSearched))
            {
                //yayy I found the synonym
                return true;
            }
            index++;
        }
        //boo I didn't find it
        return false;
    }


    /*
    Method: hasSynonym
    Purpose: removes a synonym from the list
    Parameters:
        String remove me - the synonym being removed
    Returns:
        boolean - did I remove it?
    */
    public boolean removeSynonym(String removeMe)
    {
        if (this.hasSynonym(removeMe))
        {
            //current position in the list
            int index = 1;
            //current string in the list
            String current;
            while (index < wordList.size())
            {
                current = wordList.get(index);
                if (current.equalsIgnoreCase(removeMe))
                {
                    //when I find it, remove it
                    wordList.remove(index);
                    return true;
                }
                index ++;
            }
        }
        return false;
    }

    /*
    Method: toString
    Purpose: sends the entry to a string
    Parameters:
        none
    Returns:
        String - the relevant data
    */
    public String toString()
    {
        //add the word
        String returnString = "\nWord: ";
        returnString += getWord();
        //add the synonym
        returnString += "\nSynonyms: ";
        if (wordList.size() == 1)
        {
            //if there's only one word, its the word
            returnString += "No synonyms found";
        }
        else
        {
            //start at the first synonym
            int index = 1;
            //will have at least one synonym if it reaches here
            String current = wordList.get(index);
            //done before the loop for formatting with the comma
            returnString += current;
            index++;

            while (index < wordList.size())
            {
                //add each synonym
                current = wordList.get(index);
                returnString += ", " + current;

                index++;
            }
        }

        return returnString;
    }
}


