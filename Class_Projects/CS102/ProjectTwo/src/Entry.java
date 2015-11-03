/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 2
    Entry Class - parses text line to create entry object
                -stores a word, a refefernce to a list of synonyms
                -and a reference to the next Entry
*/
public class Entry
{
    String word;//the word of the entry object
    Entry nextEntry;//reference to the next entry object
    SynNode firstSynonymNode;//reference to the first synonym

    /*
    Method: Entry - constructor
    Purpose: previously called WordNode
            linked list node of entry objects
    Parameters:
        none -sets all fields to null
    Returns:
        Entry - object created
    */
    public Entry()
    {
        word = null;
        nextEntry = null;
        firstSynonymNode = null;
    }
    /*
    Method: Entry - constructor
    Purpose: previously called WordNode
            linked list node of entry objects
    Parameters:
        String word     the word of the entry object
        Entry nextEntry      reference to the next entry object
        SynNode firstSynonymNode    reference to the first synonym
    Returns:
        Entry - object created
    */
    public Entry(String word, Entry nextEntry,
                 SynNode firstSynonymNode)
    {
        this.word = word;
        this.nextEntry = nextEntry;
        this.firstSynonymNode = firstSynonymNode;
    }

    /*
    Method: getWord - getter
    Purpose: gets the entry's word
    Parameters:
        none
    Returns:
        String - word
    */
    public String getWord()
    {
        return word;
    }

    /*
    Method: setWord - setter
    Purpose: sets the entry's word
    Parameters:
        String word - the new word
    Returns:
        none
    */
    public void setWord(String word)
    {
        this.word = word;
    }

    /*
    Method: getNextEntry - getter
    Purpose: gets the next entry in the chain
    Parameters:
        none
    Returns:
        Entry - the next entry
    */
    public Entry getNextEntry()
    {
        return nextEntry;
    }

    /*
    Method: setNextEntry - setter
    Purpose: sets the next node in the chain
    Parameters:
        Entry nextEntry - the next entry
    Returns:
        none
    */
    public void setNextEntry(Entry nextEntry)
    {
        this.nextEntry = nextEntry;
    }

    /*
    Method: getFirstSynonymNode - getter
    Purpose: gets the first synonym node
    Parameters:
        none
    Returns:
        SynNode - the first synonym node for the entry
    */
    public SynNode getFirstSynonymNode()
    {
        return firstSynonymNode;
    }


    /*
    Method: setFirstSynonymNode - setter
    Purpose: sets the entry's first synonym node
    Parameters:
        SynNode - the new synonym node
    Returns:
        none
    */
    public void setFirstSynonymNode(SynNode firstSynonymNode)
    {
        this.firstSynonymNode = firstSynonymNode;
    }


    /*
    Method: addSynonymInOrder - add to linkedList
    Purpose: add an synonym to the linked list
            in alphabetical order
    Parameters:
        String newSynonym  the synonym being added
    Returns:
        boolean - did I add it successfully
    */
    public boolean addSynonymInOrder(String newSynonym)
    {
        if (newSynonym.equals(""))
        {
            //fails if line the synonym is empty
            return false;
        }
        //the current synonym in the chain
        SynNode current = firstSynonymNode;
        //theprevious synonym in the chain
        SynNode previous = null;
        //the new synonym node bing add to the chain
        SynNode newSynNode = new SynNode(newSynonym, null);
        if (current == null)
        {
            //adds it if the chain is empty
            this.setFirstSynonymNode(newSynNode);
            return true;//returns a successful addition
        }
        while (current != null)
        {
            //the current synonym on the chain
            String currentString = current.getSynonym();
            if (newSynonym.compareToIgnoreCase(currentString) < 0)
            {
                //if the new synonym goes before the current synonym
                //insert it before it
                newSynNode.setNextSynonymNode(current);
                if(previous == null)
                {
                    this.setFirstSynonymNode(newSynNode);
                }
                else
                {
                    previous.setNextSynonymNode(newSynNode);
                }
                return true;
            }
            if (newSynonym.compareToIgnoreCase(currentString) == 0)
            {
                return false;//synonym already exists
            }

            //move on to next synonym if neither are true
            previous = current;
            current = current.getNextSynonymNode();
        }
        //if it reaches the end of the list,
        //add it to the end of the list
        previous.setNextSynonymNode(newSynNode);
        newSynNode.setNextSynonymNode(null);
        return true;
    }

    /*
    Method: searchForSynonym - search database
    Purpose: search the synonym linked list to see if
            it has a particular synonym
    Parameters:
        String Synonym  the synonym being searched for
    Returns:
        boolean - did I find it?
    */
    public boolean searchForSynonym(String synonym)
    {
        if (firstSynonymNode == null)
        {
            //if there are no synonym return false
            return false;
        }
        //cuurent synNode on the chain
        SynNode current = firstSynonymNode;
        while (current != null)
        {
            if (current.getSynonym().equalsIgnoreCase(synonym))
            {
                //return true if you find it
                return true;
            }
            current = current.getNextSynonymNode();
        }

        //return false if you don't find it
        return false;
    }


    /*
    Method: getSynNodeBySynonym - search database
    Purpose: like search for synonym, but returns
            the synonym if its found
    Parameters:
        String Synonym  the synonym being searched for
    Returns:
        SynNode - what I found
    */
    public SynNode getSynNodeBySynonym(String synonym)
    {
        //synnode being returned
        SynNode returnMe = null;

        //curretn synNode in the chain
        SynNode current = firstSynonymNode;
        if (current == null)
            return null;
        //return false if the chain is empty

        while (current != null)
        {
            if (current.getSynonym().equalsIgnoreCase(synonym))
            {
                //set return me if I find it and
                //break out of the loop
                returnMe = current;
                break;
            }
            current = current.getNextSynonymNode();
        }

        return returnMe;//return what I found
    }

    /*
    Method: toString -  toString
    Purpose: Returns a formatted string containing the useful
                information contained by this entry object
    Parameters:
        none
    Returns:
        String           Formatted string with word and synonyms
                            from eah entry object
    */
    public String toString()
    {
        //prints out the word and all of its synonyms
        //string being returned
        String returnString = "\nWord: " + this.getWord();
        returnString += "\nSynonyms: ";
        SynNode currentSyn = this.getFirstSynonymNode();
        if (currentSyn == null)
        {
            returnString += "No Synonyms found";
        }
        else
        {
            returnString += currentSyn.getSynonym();
            currentSyn = currentSyn.getNextSynonymNode();
            while (currentSyn != null)
            {
                returnString += ", " + currentSyn.getSynonym();
                currentSyn = currentSyn.getNextSynonymNode();
            }
        }

        return returnString;
    }
}
