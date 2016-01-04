/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 4
    Prog 4 Class: Contains main, acts as a thesaurus user interface
*/
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;


public class Prog5
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
            //mainMenu(thesaurus);//opens the main menu
            GUIMenu menu = new GUIMenu(thesaurus);
        }
        catch (FileNotFoundException notFoundObject)
        {
            System.out.println("Sorry, I could not find that file" +
                    "\nExiting now");
            System.exit(0);//terminates current virtual machine
        }
    }
}


