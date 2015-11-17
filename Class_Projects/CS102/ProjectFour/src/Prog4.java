/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 3
    Prog 3 Class: Contains main, acts as a thesaurus user interface
*/
import java.util.*;
import java.io.*;

public class Prog4
{
    /*
    Method: main
    Purpose: controls the runtime of the program
    Parameters:
        String [] args   String array of input arguments
    Returns:
        none
    */
    public static void main(String [] args)
    {
        if (args.length != 1)
        {
            //breaks if there isn't exactly one input
            System.out.println("Sorry, your input seems incorrect");
            System.out.println("You should have exactly one argument" +
                    " \nExiting now");
            System.exit(0);//terminates current virtual machine
            //because it can't really do anything without file io yet
        }

        try
        {
            //the file containing the thesaurus information
            File inputFile = new File(args[0]);
            //Scanner of the input file, to be passed to the database
            Scanner inputScanner = new Scanner(inputFile);
            //thesaurus contains all of the data parsed from the test file
            Database thesaurus = new Database(inputScanner);
            //makes my database
            //sends the database a scanner so only main  deals with file io
            mainMenu(thesaurus);//opens the main menu
        }
        catch (FileNotFoundException notFoundObject)
        {
            System.out.println("Sorry, I could not find that file" +
                    "\nExiting now");
            System.exit(0);//terminates current virtual machine
        }
    }



    /*
    Method: mainMenu - user interface
    Purpose: Main menu, interacts with user and directs
                to other sub-menus
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void mainMenu(Database currentThesaurus)
    {
        //menu command to search for a word
        final int SEARCHFORWORD = 1;
        //menu command to search for a synonym
        final int SEARCHFORSYNONYM = 2;
        //menu command to print the database
        final int PRINTDATABASE = 3;
        //menu command to add a new word
        final int ADDNEWWORD = 4;
        //menu command to add a new synonym
        final int ADDNEWSYNONYM = 5;
        //menu command to remove an entry
        final int REMOVEENTRY = 6;
        //menu command to remove an synonym
        final int REMOVESYNONYM = 7;
        //menu command to end the program
        final int EXIT = 8;

        System.out.println("Welcome to CS-102 Project One: The Thesaurus");
        System.out.println("Written by Caspian Peavyhouse\n");

        //scanner to take user input
        Scanner input = new Scanner(System.in);

        //controls whether the menu will loop on completion
        boolean loopOn = true;
        while(loopOn)//loop controlled by loopOn activation
        //loops menu after failure or success
        {
            try
            {
                //standard menu
                System.out.println("Available Commands:");
                System.out.println("1: Search for a word");
                System.out.println("2: Search for a synonym");
                System.out.println("3: Print the database");
                System.out.println("4: Add a new word to the thesaurus");
                System.out.println("5: Add a new synonym to a word");
                System.out.println("6: Remove a word from the thesaurus");
                System.out.println("7: Remove a synonym from a word");
                System.out.println("8: Exit");
                System.out.print("Option Number >> ");

                int selection = Integer.parseInt(input.nextLine());
                //

                switch (selection)
                {
                    case SEARCHFORWORD://Search for a word
                    {
                        wordSearchMenu(currentThesaurus);
                        //calls the word search menu
                        break;
                    }
                    case SEARCHFORSYNONYM://Search for a synonym
                    {
                        synonymSearchMenu(currentThesaurus);
                        //calls the synonym search menu
                        break;
                    }
                    case PRINTDATABASE://Print the database
                    {
                        System.out.println(currentThesaurus.toString());
                        //prints the database using databases toString
                        break;
                    }
                    case ADDNEWWORD://add a new entry
                    {
                        addNewEntry(currentThesaurus);
                        //calls the method to add a new entry
                        break;
                    }
                    case ADDNEWSYNONYM://add a new synonym to an entry
                    {
                        addNewSynonymToEntry(currentThesaurus);
                        //calls the method to add a new synonym
                        break;
                    }
                    case REMOVEENTRY:
                    {
                        removeEntry(currentThesaurus);
                        //calls the method to remove an entry
                        break;
                    }
                    case REMOVESYNONYM://add a new synonym to an entry
                    {
                        removeSynonymFromEntry(currentThesaurus);
                        //calls the method to remove a synonym
                        break;
                    }
                    case EXIT://Exit
                    {
                        System.out.println("The program will exit now");
                        System.exit(0);
                    }
                    default:
                    {
                        System.out.println("Please enter a valid number for " +
                                "the choice of your selection\n\n");
                        // will loop though till user gets correct input
                    }
                }

                //typeCheck = true; //this line sets mode for either
                //one run through or infinite run till user exits or breaks it
            }
            catch (NumberFormatException wrongTypeObject)
            {
                System.out.println("Please enter a valid number for " +
                        "the choice of your selection\n\n");
                //catches when the user input bad data
            }
        }
    }

    /*
    Method: wordSearchMenu - user interface
    Purpose: word menu, interacts with user and calls database methods
                to search for user input, prints out search results
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void wordSearchMenu(Database currentThesaurus)
    {
        //basic menu for simple text input
        //should work for any normal circumstances
        System.out.println("\nPlease type the word to be searched for");
        System.out.print(">> ");
        //Scanner to take user input
        Scanner inputScanner = new Scanner(System.in);
        //the word being searched for
        String userInput = inputScanner.nextLine();

        //searches the database for a word

        String returnString = currentThesaurus.searchForWord(userInput);
        // the results of the search
        System.out.println(returnString + "\n");

    }

    /*
    Method: synonymSearchMenu - user interface
    Purpose: word menu, interacts with user and calls database methods
                to search for user input, prints out search results
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void synonymSearchMenu(Database currentThesaurus)
    {
        //basic menu for simple text input
        //should work for any normal circumstances
        //because it stores user input into a string
        System.out.println("\nPlease type the synonym to be searched for");
        System.out.print(">> ");
        //Scanner to take user input
        Scanner inputScanner = new Scanner(System.in);
        //Synonym being searched for
        String userInput = inputScanner.nextLine();

        //searches each entry for a matching synonym
        String returnString = currentThesaurus.searchForSynonym(userInput);
        //the results of the search
        System.out.println(returnString + "\n");
    }

    /*
    Method: addNewEntry - user interface
    Purpose: word menu, interacts with user and calls database methods
                to add new entries, prints out results
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void addNewEntry(Database currentThesaurus)
    {
        System.out.println("\nPlease type the word you would like to add");
        System.out.print(">>");
        //Will accept spaces in words
        //Scanner to take user input
        Scanner inputScanner = new Scanner(System.in);
        //the wood the user wants to add
        String newUserWord = inputScanner.nextLine();

        //checks whether the word was added successfully
        boolean successCheck = currentThesaurus.addEntryFromMenu(newUserWord);
        if (successCheck == true)
        {
            System.out.println("\n" +newUserWord + " has been " +
                    "added to the thesaurus");
            System.out.println("Would you like to add a synonym for it?");
            System.out.print("type (yes/no) >>");
            //does the user want to add a synonym
            String userResponse = inputScanner.next();
            if (userResponse.equalsIgnoreCase("yes"))
            {
                //calls the same method that addNewSynonym calls
                currentThesaurus.addSynonymFromMenu(newUserWord);
            }
            else
            {
                System.out.println("\nGoing back to the main menu");
            }
        }
        else
        {
            System.out.println("\nSorry, that word is already in the thesaurus\n");
            System.out.println("Going back to the main menu");
            //returns to the main menu
        }
    }

    /*
    Method: addNewSynonym - basic user interface
    Purpose: word menu, interacts with user and calls database methods
                to add new synonyms
                real work is done in database
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void addNewSynonymToEntry(Database currentThesaurus)
    {
        System.out.println("\nPlease type the word you would like to update");
        System.out.print(">>");
        //Scanner to take user input
        Scanner inputScanner = new Scanner(System.in);
        //What word does the user want to update?
        String word = inputScanner.nextLine();

        //calls the method where the real work is done
        currentThesaurus.addSynonymFromMenu(word);
        //written that way so code is usable by addNewEntry
    }


    /*
    Method: removeEntry  - basic user interface
    Purpose: word menu, interacts with user and calls database methods
                to remove entries
                real work is done in database
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void removeEntry(Database currentThesaurus)
    {
        System.out.println("\nPlease type the word you would like to remove");
        System.out.print(">>");
        //Will accept spaces in words
        //Scanner to take user input
        Scanner inputScanner = new Scanner(System.in);
        //the wood the user wants to add
        String newUserWord = inputScanner.nextLine();

        //checks whether the word was added successfully
        boolean successCheck = currentThesaurus.removeEntryFromMenu(newUserWord);
        if (successCheck)
        {
            System.out.println("\n" +newUserWord + " has been " +
                    "removed from the thesaurus");
            System.out.println("\nGoing back to the main menu");
        }
        else
        {
            System.out.println("Going back to the main menu");
            //returns to the main menu
        }
    }

    /*
    Method: removeSynonymFromEntry  - basic user interface
    Purpose: word menu, interacts with user and calls database methods
                to remove synonyms
                real work is done in database
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        none
    */
    public static void removeSynonymFromEntry(Database currentThesaurus)
    {
        System.out.println("\nPlease type the word you would like to update");
        System.out.print(">>");
        //Scanner to take user input
        Scanner inputScanner = new Scanner(System.in);
        //WHat word does the user want to update?
        String word = inputScanner.nextLine();

        //calls the method where the real work is done
        currentThesaurus.removeSynonymFromMenu(word);
    }

}


