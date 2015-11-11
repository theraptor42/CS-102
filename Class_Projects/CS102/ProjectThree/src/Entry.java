/*
    * Caspian Peavyhouse - peav2414@kettering.edu
    * CS-102, Fall 2015
    * Programming Assignment 3
    * Entry Class -
*/
import java.util.*;
public class Entry
{
    private LinkedList<String> wordList;

    public Entry()
    {
        wordList = new LinkedList<String>();
    }


    public String getWord()
    {
        if (wordList.size() == 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return wordList.getFirst();
    }

    public boolean isEmpty()
    {
        if(wordList.size() == 0)
            return true;
        else//else for clarity
            return false;
    }


    public void setWord(String word)
    {
        //setting the word will clear out any existing strings
        wordList.clear();
        wordList.add(word);
    }


    public boolean addSynonymInOrder(String newSynonym)
    {
        if (wordList.size() == 1)
        {
            wordList.add(newSynonym);
            return true;
        }
        int index = 1;
        String current;
        String last = getLastSynonym();
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
                wordList.add(index, newSynonym);
                return true;
            }
            if (newSynonym.compareToIgnoreCase(current) == 0)
            {
                return false;
            }

            index++;
        }

        //because it won't compile without a return here
        //though it should never be reached
        System.out.println("You reached an non-accessible point: 1\n");
        wordList.addLast(newSynonym);
        return true;
    }

    public String getFirstSynonym()
    {
        if (wordList.size() <= 1)
        {
            return null;
        }
        return wordList.get(1);
    }
    public String getLastSynonym()
    {
        if (wordList.size() <= 1)
        {
            return null;
        }
        return wordList.getLast();
    }

    public boolean hasSynonym(String synSearched)
    {
        if (wordList.isEmpty() || wordList.size() == 1)
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
                return true;
            }
            index++;
        }
        return false;
    }

    public int getIndexOfSyn(String synSearched)
    {
        if (wordList.isEmpty() || wordList.size() == 1)
        {
            //no synonyms
            return -1;
        }
        //current position in list
        int index = 1;
        String current;

        while (index < wordList.size())
        {
            current = wordList.get(index);
            if (current.equalsIgnoreCase(synSearched))
            {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean removeSynonym(String removeMe)
    {
        if (this.hasSynonym(removeMe))
        {
            int index = 1;
            String current;
            while (index < wordList.size())
            {
                current = wordList.get(index);
                if (current.equalsIgnoreCase(removeMe))
                {
                    wordList.remove(index);
                    return true;
                }
                index ++;
            }
        }
        return false;
    }

    public String toString()
    {
        String returnString = "\nWord: ";
        returnString += getWord();
        returnString += "\nSynonyms: ";
        if (wordList.size() == 1)
        {
            returnString += "No synonyms found";
        }
        else
        {
            int index = 1;
            String current = wordList.get(index);
            returnString += current;
            index++;

            while (index < wordList.size())
            {
                //while current does not equal last
                current = wordList.get(index);
                returnString += ", " + current;

                index++;
            }
        }

        return returnString;
    }
}


