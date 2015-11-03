/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 1
    Prog 1 Class: Contains main, acts as a thesaurus user interface
*/
import java.util.*;
import java.io.*;

public class Prog1
{
    public static void main(String [] args)
    {
        boolean fileCheck = false;
        while (!fileCheck)
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
                File inputFile = new File(args[0]);
                Scanner inputScanner = new Scanner(inputFile);
                Database thesaurus = new Database(inputScanner);
                //makes my database
                //sends the database a scanner so only main  deals with file io
                mainMenu(thesaurus);//opens the main menu
                fileCheck = true;//ends program if reached
                //probably should not ever reach here
                //if mainMenu's loop is activated
            }
            catch (FileNotFoundException notFoundObject)
            {
                System.out.println("Sorry, I could not find that file" +
                        "\nExiting now");
                System.exit(0);//terminates current virtual machine
            }
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
        System.out.println("Welcome to CS-102 Project One: The Thesaurus");
        System.out.println("Written by Caspian Peavyhouse\n");

        Scanner input = new Scanner(System.in);
        boolean typeCheck = false;
        while(!typeCheck)//loop controlled by typechecks activation
        //loops menu after failure or success
        {
            try
            {
                //standard menu
                System.out.println("Available Commands:");
                System.out.println("1: Search for a word");
                System.out.println("2: Search for a synonym");
                System.out.println("3: Print the database");
                System.out.println("4: Exit");
                System.out.print("Option Number >> ");
                int selection = Integer.parseInt(input.nextLine());
                //

                switch (selection)
                {
                    case 1://Search for a word
                    {
                        wordSearchMenu(currentThesaurus);
                        //calls the word search menu
                        break;
                    }
                    case 2://Search for a synonym
                    {
                        synonymSearchMenu(currentThesaurus);
                        //calls the synonym search menu
                        break;
                    }
                    case 3://Print the database
                    {
                        System.out.println(currentThesaurus.toString());
                        //prints the database using databases toString
                        break;
                    }
                    case 4://Exit
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
                //standard error message
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
        //because it stores user input into a string
        System.out.println("Please type the word to be searched for");
        System.out.print(">> ");
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine();
        String returnString = currentThesaurus.searchForWord(userInput);
        System.out.println(returnString + "\n");
        //searches the database for a word
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
        System.out.println("Please type the synonym to be searched for");
        System.out.print(">> ");
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine();

        String returnString = currentThesaurus.searchForSynonym(userInput);
        System.out.println(returnString + "\n");
        //searches each entry for a matching synonym
    }
}
