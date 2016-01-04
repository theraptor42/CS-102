import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 5
 * Class: FileInputOutputMenu - frame where thesaurus is loaded or saved from file
 */
public class FileInputOutputMenu
{
    //my Jframe that I keep throughout runtime
    JFrame myGUIFrame;
    //the box that stores everything I display
    Container mainMenuContents;
    //the current database of TreeNodes
    Database currentThesaurus;
    //instuctions above my input bar
    JLabel fileIOBarInstructions;
    //user's input bar
    JTextField fileIOBar;
    //button below my input bar
    JButton executeActionButton;
    //is the user sending the databas to file
    boolean exportingFile = true;

    /*
    Method: FileInputOutputMenu
    Purpose: constructor for FileInputOutputMenu
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        FileInputOutputMenu - the menu created
    */
    public FileInputOutputMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
    {
        //my reocurring JFrame
        this.myGUIFrame = GUIFrame;
        //the currently loaded database
        this.currentThesaurus = currentThesaurus;
        //the contents of the mainMenu
        this.mainMenuContents = mainMenuContents;

        //my contents are in a BoxLayout for simplicty
        Container contents = new Box(BoxLayout.Y_AXIS);

        //max size for my buttons
        //max button width
        int maxButtonWidth = 500;
        //max button height
        int maxButtonHeight = 30;
        //max button size
        Dimension maxButtonDimension = new Dimension(maxButtonWidth, maxButtonHeight);

        //max text field width
        int maxTextFieldWidth = 500;
        //max text field height
        int maxTextFieldHeight = 30;
        //max text field size
        Dimension maxTextFieldDimension = new Dimension(maxTextFieldWidth, maxTextFieldHeight);

        //Create my event handler object which is used by all of my buttons
        ButtonHandler myButtonHandler = new ButtonHandler();
        //Create my event handler object which is used by my search bar and button
        SearchBarHandler mySearchBarHandler = new SearchBarHandler();

        //button to return to the main menu
        JButton returnToMainMenuButton = new JButton("Return to the Main Menu");
        //set button size
        returnToMainMenuButton.setMaximumSize(maxButtonDimension);
        //set button listenter
        returnToMainMenuButton.addActionListener(myButtonHandler);
        //add it to the contents
        contents.add(returnToMainMenuButton);

        //Adds radio buttons to my menu
        contents.add(Box.createVerticalStrut(10));
        JLabel radioButtonInstructions = new JLabel("What would you like to do?");
        contents.add(radioButtonInstructions);

        //button group so only one radio button is selectable
        ButtonGroup myRadioButtons = new ButtonGroup();

        //button to export the database
        JRadioButton exportToFileButton = new JRadioButton("Export current thesaurus to file");
        exportToFileButton.addActionListener(myButtonHandler);
        myRadioButtons.add(exportToFileButton);
        //sets selectEntryButton to be the preselected choice
        exportToFileButton.setSelected(true);

        //button to load a new database
        JRadioButton loadFromFileButton = new JRadioButton("Load a new thesaurus from file");
        loadFromFileButton.addActionListener(myButtonHandler);
        myRadioButtons.add(loadFromFileButton);


        contents.add(exportToFileButton);
        contents.add(loadFromFileButton);
        //end radio buttons

        //text search bar and search button
        fileIOBarInstructions = new JLabel("Where do you want to save this file? (ex. C:\\filename.txt)");


        //where is the file you want to load/make
        fileIOBar = new JTextField();
        fileIOBar.setMaximumSize(maxTextFieldDimension);
        fileIOBar.addActionListener(mySearchBarHandler);

        //button that is the same as hitting enter in the search bar
        executeActionButton = new JButton("Export");
        executeActionButton.setMaximumSize(maxButtonDimension);
        executeActionButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(fileIOBarInstructions);
        contents.add(fileIOBar);
        contents.add(executeActionButton);
        //end search bar

        //adds spacing to the sided of my frame for aesthetics
        Box borderedBox  = Box.createHorizontalBox();
        borderedBox.add(Box.createHorizontalStrut(10));
        borderedBox.add(contents);
        borderedBox.add(Box.createHorizontalStrut(10));

        //sets and displays my contnts
        myGUIFrame.setContentPane(borderedBox);
        myGUIFrame.repaint();
        myGUIFrame.revalidate();
    }

    /*
     * Caspian Peavyhouse - peav2414@kettering.edu
     * CS-102, Fall 2015
     * Programming Assignment 5
     * Class:ButtonHandler - controls my button action events
     */
    private class ButtonHandler implements ActionListener
    {
        /*
        Method: actionPerformed
        Purpose: simple button listenter that controls what button click or search bar enter do
        Parameters:
            ActionEvent theAction - what event am I responding to
        Returns:
            none
        */
        public void actionPerformed( ActionEvent theAction )
        {
            if (theAction.getActionCommand().equals("Return to the Main Menu"))
            {
                //this makes it look like its going back to the main menu
                //but its more like the main menu is being inserted here
                //adds spacing to the sided of my frame for aesthetics
                Box borderedBox  = Box.createHorizontalBox();
                borderedBox.add(Box.createHorizontalStrut(10));
                borderedBox.add(mainMenuContents);
                borderedBox.add(Box.createHorizontalStrut(10));

                //sets and displays my contnts
                myGUIFrame.setContentPane(borderedBox);
                myGUIFrame.repaint();
                myGUIFrame.revalidate();

            }

            if (theAction.getActionCommand().equals("Export current thesaurus to file"))
            {
                //I am esporting the database
                exportingFile = true;
                //change the instructions
                fileIOBarInstructions.setText("Where do you want to save this file? (ex. C:\\filename.txt)");
                //change the button
                executeActionButton.setText("Export");

            }
            if (theAction.getActionCommand().equals("Load a new thesaurus from file"))
            {
                //I am loading a database
                exportingFile = false;
                //change the instructions
                fileIOBarInstructions.setText("Where is the file you want to load? (ex. C:\\filename.txt)");
                //change the button
                executeActionButton.setText("Load");
            }
        }
    }

    /*
     * Caspian Peavyhouse - peav2414@kettering.edu
     * CS-102, Fall 2015
     * Programming Assignment 5
     * Class:SearchBarHandler - controls my search bar and button action events
     */
    private class SearchBarHandler implements ActionListener
    {
        /*
        Method: actionPerformed
        Purpose: simple button listenter that controls what button click or search bar enter do
        Parameters:
            ActionEvent theAction - what event am I responding to
        Returns:
            none
        */
        public void actionPerformed(ActionEvent theAction)
        {
            //the file the user wants to load/make
            String userInput = fileIOBar.getText();
            //is it okay?
            String errorMessage = "";
            if (userInput == null || userInput.equals(""))
            {
                //blank box
                errorMessage += "Please enter a valid filepath";
            }

            if (!errorMessage.equals(""))
            {
                //something went wrong
                JOptionPane.showMessageDialog(null, errorMessage);
            }
            else if (exportingFile)
            {
                //confimation information
                String confirmation = "Are you sure you want to export the thesaurus?";
                String title = "Export?";
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);

                //what did the user say to the prompt?
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    try {
                        //the file containing the thesaurus information
                        //extension is the last 4 chars of what the user put in the text box
                        //this is to make sure the file is openable
                        String extension;
                        if (userInput.length() > 5)
                        {
                            extension = userInput.substring(userInput.charAt(userInput.length() -4));
                        }
                        else
                        {
                            extension ="";
                        }
                        if (!extension.equals(".txt"))
                        {
                            //if the last 4 chars aren't .txt, make them .txt
                            userInput+=".txt";
                        }
                        File outputFile = new File(userInput);

                        //write the database to file
                        FileWriter outputWriter = new FileWriter(outputFile.getAbsolutePath());

                        currentThesaurus.writeToFile(outputWriter, currentThesaurus.getEntryRoot());
                        outputWriter.close();
                        //tell the user what happened
                        JOptionPane.showMessageDialog(null, "The new thesaurus has been saved to \r\n"
                                + outputFile.getAbsolutePath());
                    }
                    catch (IOException outputException)
                    {
                        //something went wrong
                        JOptionPane.showMessageDialog(null, "I could not write to that file");
                    }
                }
            }

            else if (!exportingFile)
            {
                //confimation information
                String confirmation = "Are you sure you want to load this thesaurus?";
                String title = "Load?";
                //what did the user say to the prompt?
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    try {
                        //the file containing the thesaurus information
                        File inputFile = new File(userInput);
                        //Scanner of the input file, to be passed to the database
                        Scanner inputScanner = new Scanner(inputFile);
                        //thesaurus contains all of the data parsed from the test file
                        Database newThesaurus = new Database(inputScanner);
                        //makes my database
                        //sends the database a scanner so only main  deals with file io
                        //tell the user what happened
                        JOptionPane.showMessageDialog(null, "The new thesaurus has been loaded");
                        currentThesaurus = newThesaurus;
                        myGUIFrame = new GUIMenu(currentThesaurus);
                    } catch (FileNotFoundException notFoundObject)
                    {
                        JOptionPane.showMessageDialog(null, "I could not find that file");
                    }
                }
            }
        }
    }
}
