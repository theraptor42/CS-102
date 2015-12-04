/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 4
 * Database Class: Stores and searches mt binary search trees
 */

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class Database
{
    TreeNode entryRoot;
    final boolean ENTRY = true;
    final boolean SYNONYM = false;

    /*
    Method: Database
    Purpose: makes a new database from a file
    Parameters:
        Scanner inputScanner - scanner of the file
    Returns:
        Database
    */
    public Database(Scanner inputScanner)
    {
        if(!inputScanner.hasNextLine())
        {
            //I don't want a null, so its initialized as an empty list
            entryRoot = new TreeNode(ENTRY);//is an entry
        }
        while (inputScanner.hasNextLine())
        {
            //a new entry object parsed from the line of text
            TreeNode newEntry = parseInputLine(inputScanner.nextLine());
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
    Method: parseInputLine - text parser
    Purpose: parse the line of text and returns a TreeNode
    Parameters:
        String line   the line of text being parsed
    Returns:
        Entry - the Object parsed from the text line
    */
    private TreeNode parseInputLine(String line)
    {
        if (line.equals(""))
        {
            //returns a null object if the line is empty
            //only null entry source in code
            return null;
        }

        //a new empty TreeNode object
        TreeNode returnNode = new TreeNode(ENTRY);//is an entry
        //Scanner to scan the line of text
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("/");

        //sets the entry's word
        returnNode.setMyString(lineScanner.next());

        while (lineScanner.hasNext())
        {
            //the next word in the line
            String nextWord = lineScanner.next();
            //end of line and 'a//b/c' blank words
            if (!(nextWord == null) && !(nextWord.equals("")))
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

    public TreeNode getEntryRoot()
    {
        return entryRoot;
    }

    /*
    Method: addEntryInOrder
    Purpose: adds an entry in order to the database
    Parameters:
        TreeNode newRntry - the entry being added
    Returns:
        boolean - did i do it?
    */
    public boolean addEntryInOrder(TreeNode newEntry)
    {
        //in scope, this. is an entry node adding a new syn to synTree
        if (newEntry == null || newEntry.getMyString().equals(""))
        {
            return false;
        }
        if (this.containsEntry(newEntry.getMyString()))
        {
            return false;
        }
        entryRoot = TreeNode.addTreeNodeInOrder(newEntry, entryRoot);
        return true;
    }

    public boolean containsEntry(String findThisWord)
    {
        if (findThisWord == null || findThisWord.equalsIgnoreCase(""))
        {
            return false;
        }
        return (TreeNode.containsString(findThisWord, entryRoot));
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
        return (entryRoot == null || entryRoot.getMyString() == null);
        //just doing .size() == 0 will raise a null pointer exception on occasion
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
        if (this.containsEntry(wordSearched))
        {
            //its in the list, so get it
            TreeNode found = TreeNode.getNodeByString(wordSearched, entryRoot);

            return found.toString();
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

        returnString += searchForSynonym(synSearchedFor, entryRoot);

        //recursive call for a lcr search
        if (returnString.equals(""))
        {
            //I didn't find it
            returnString = "I could not find: \"" + synSearchedFor + "\"";
        }
        return returnString;
    }

    private String searchForSynonym(String searchedFor, TreeNode currentNode)
    {
        String returnString = "";

        if (currentNode == null)
        {
            return returnString;
        }

        returnString += searchForSynonym(searchedFor, currentNode.getLeftBranch());

        if (currentNode.containsSynonym(searchedFor))
        {
            returnString += "\r\n" + currentNode.toString() + "\r\n";
        }

        returnString += searchForSynonym(searchedFor, currentNode.getRightBranch());

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
        if (this.containsEntry(newWord))
        {
            return false;
        }
        else
        {
            //a new blank entry
            TreeNode newEntry = new TreeNode(ENTRY);
            //adds my new word tothe entry
            newEntry.setMyString(newWord);
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
        if (!this.containsEntry(wordToAddTo))
        {
            //if the word isn't there, go back to caller
            System.out.println("Sorry, I could not find that word in the thesaurus\n");
            return;
        }
        TreeNode entryToModify = TreeNode.getNodeByString(wordToAddTo, entryRoot);

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

                if (entryToModify.containsSynonym(userInput))
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
        if (this.containsEntry(removeMe))
        {
            System.out.println("Are you sure you want to remove the entry: " + removeMe +"?");
            System.out.print("(Yes/No) >>");
            //Will accept spaces in words
            //Scanner to take user input
            Scanner inputScanner = new Scanner(System.in);
            //the wood the user wants to add
            String userInput = inputScanner.nextLine();

            if (userInput.equalsIgnoreCase("yes"))
            {
                TreeNode.removeTreeNode(TreeNode.getNodeByString(removeMe, entryRoot), entryRoot, null);
                return true;
            }
            else
            {
                //go back to the menu
                return false;
            }
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
        if (!this.containsEntry(wordToRemoveFrom))
        {
            //if the word isn't there, go back to caller
            System.out.println("Sorry, I could not find that word in the thesaurus\n");
            return;
        }
        //if the entry exists, get the entry using its index
        TreeNode removeFromThis = TreeNode.getNodeByString(wordToRemoveFrom, entryRoot);

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
            String removeMe = inputScanner.nextLine();

            if (removeMe.equals("")) {
                System.out.println("Sorry, I can't remove nothing\n");
                //jump down to loop control
            }
            else
            {

                if (!removeFromThis.containsSynonym(removeMe))
                {
                    //if the word does not have the synonym skip down to loop control
                    System.out.println(wordToRemoveFrom + "does not have that synonym\n");
                }
                else
                {
                    System.out.println("Are you sure you want to remove the Synonym: " + removeMe +"?");
                    System.out.print("(Yes/No) >>");
                    //Will accept spaces in words
                    String userInput = inputScanner.nextLine();

                    if (userInput.equalsIgnoreCase("yes"))
                    {
                       TreeNode nodeToRemove = TreeNode.getNodeByString(removeMe, removeFromThis.getSynonymTree());

                        TreeNode.removeTreeNode(nodeToRemove,
                                removeFromThis.getSynonymTree(), null);
                        System.out.println(removeMe + " was successfully removed from the entry.");
                        return;
                    }
                    else
                    {
                        //go back to the menu
                        System.out.println("Going back to the main menu");
                        return;
                    }
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
    Method: toString
    Purpose: sends the database to a string
    Parameters:
        none
    Returns:
    */
    public String toString()
    {
        String returnSting = "";

        returnSting += toString(entryRoot);

        if (returnSting.equalsIgnoreCase(""))
        {
            returnSting = "There are currently no entries in the thesaurus";
        }

        return returnSting;
    }

    /*
    Method: toString
    Purpose: sends the database to a string
    Parameters:
        TreeNode currentNode - the current node in the binary tree
    Returns:
    */
    private String toString (TreeNode currentNode)
    {
        String returnString = "";
        if (currentNode == null)
        {
            return returnString;
        }

        returnString += toString(currentNode.getLeftBranch());
        returnString += currentNode.toString() + "\r\n";
        returnString += toString(currentNode.getRightBranch());

        return returnString;
    }

    /*
    Method: toFile
    Purpose: sends the database to a File
    Parameters:
        FileWriter fileWriter - the filewriter to pprint to file
        TreeNode current - current node bing printed
    Returns:
    */
    public void writeToFile(FileWriter fileWriter, TreeNode current)
    {
        try
        {
            if (current == null)
            {
                return;
            }
            fileWriter.write(current.toFile() + "\r\n");
            writeToFile(fileWriter, current.getLeftBranch());
            writeToFile(fileWriter, current.getRightBranch());
        }
        catch(IOException exception)
        {
            System.out.println("An error occurred in the file writing");
        }


    }

}
