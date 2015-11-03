/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 1
    Entry Class: Parses text lines into words and synonyms
*/
import java.util.*;
public class Entry
{
    private String word;//contains the word of the entry
    private String[] synonyms;//contains the synonyms of the word

    /*
    Method: Entry - constructor
    Purpose: Parse a line of text into a String word and
                    String array synonyms
    Parameters:
        String line:        the line to be parsed
    Returns:
        Entry               the object created from text line
    */
    public Entry(String line)
    {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("/");

        word = lineScanner.next();
        //empty lines are caught in database

        synonyms = new String[0];
        int counter = 0;
        String nextWord;
        while (lineScanner.hasNext())
        {
            nextWord = lineScanner.next();
            //gets next word to be evaluated
            //for inclusion in the array
            if (nextWord.equals(""))
            {}//excludes any null elements from my array
            else
            {
                if (counter == synonyms.length)
                {
                    //increases the size of the array by one
                    //so array contains no null elements
                    String [] bigger = Arrays.asList(synonyms)
                            .toArray(new String [synonyms.length+1]);
                    synonyms = bigger;
                }
                synonyms[counter] = nextWord;
                //stores the synonym into the array
                counter++;
            }
        }
    }

    /*
    Method: getWord - getter
    Purpose: Returns word for external use
    Parameters:
        none
    Returns:
        String               the Entry's word
    */
    public String getWord()
    {
        return word;
        //returns word for external use
        //because word is private
    }

    /*
    Method: getSynonymList - getter
    Purpose: Returns synonyms for external use
    Parameters:
        none
    Returns:
        String []           the String array of synonyms
    */
    public String [] getSynonymsList()
    {
        return synonyms;
        //returns synonyms for external use
        //because synonyms is private
    }

    /*
    Method: toString - toString
    Purpose: Returns a formatted string containing the useful
                information contained by this Entry object
    Parameters:
        none
    Returns:
        String           Formatted string with word and synonyms
    */
    public String toString()
    {
        String returnString = "Word: " + word + "\nSynonyms: ";
        if (synonyms.length > 0)
        {
            returnString += synonyms[0];
            //loops and gets all the synonyms for this entry
            for (int i = 1; i < synonyms.length; i++) {
                returnString += ", " + synonyms[i];
            }
        }
        else
        //if none are found, returns failure message
            returnString += "No synonyms found";
        return returnString;
        //puts the entry into a string in the format
        //Word: word
        //Synonyms: syn1, syn2, ...
    }
}
