import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Caspian on 12/15/2015.
 */
public class FileInputOutputMenu
{
    JFrame myGUIFrame;
    Database currentThesaurus;
    Container mainMenuContents;
    JLabel fileIOBarInstructions;
    JTextField fileIOBar;
    JButton executeActionButton;
    boolean exportingFile = true;

    public FileInputOutputMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
    {
        this.myGUIFrame = GUIFrame;
        this.currentThesaurus = currentThesaurus;
        this.mainMenuContents = mainMenuContents;

        Container contents = new Box(BoxLayout.Y_AXIS);

        int maxButtonWidth = 500;
        int maxButtonHeight = 30;
        Dimension maxButtonDimension = new Dimension(maxButtonWidth, maxButtonHeight);

        int maxTextFieldWidth = 500;
        int maxTextFieldHeight = 30;
        Dimension maxTextFieldDimension = new Dimension(maxTextFieldWidth, maxTextFieldHeight);

        ButtonHandler myButtonHandler = new ButtonHandler();
        SearchBarHandler mySearchBarHandler = new SearchBarHandler();


        JButton returnToMainMenuButton = new JButton("Return to the Main Menu");
        returnToMainMenuButton.setMaximumSize(maxButtonDimension);
        returnToMainMenuButton.addActionListener(myButtonHandler);
        contents.add(returnToMainMenuButton);

        //Adds radio buttons to my menu
        contents.add(Box.createVerticalStrut(10));
        JLabel radioButtonInstructions = new JLabel("What would you like to do?");
        contents.add(radioButtonInstructions);

        ButtonGroup myRadioButtons = new ButtonGroup();

        JRadioButton exportToFileButton = new JRadioButton("Export current thesaurus to file");
        exportToFileButton.addActionListener(myButtonHandler);
        myRadioButtons.add(exportToFileButton);
        //sets selectEntryButton to be the preselected choice
        exportToFileButton.setSelected(true);

        JRadioButton loadFromFileButton = new JRadioButton("Load a new thesaurus from file");
        loadFromFileButton.addActionListener(myButtonHandler);
        myRadioButtons.add(loadFromFileButton);


        contents.add(exportToFileButton);
        contents.add(loadFromFileButton);
        //end radio buttons

        //text search bar and search button
        fileIOBarInstructions = new JLabel("Where do you want to save this file? (ex. C:\\filename.txt");


        fileIOBar = new JTextField();
        fileIOBar.setMaximumSize(maxTextFieldDimension);
        fileIOBar.addActionListener(mySearchBarHandler);

        executeActionButton = new JButton("Export");
        executeActionButton.setMaximumSize(maxButtonDimension);
        executeActionButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(fileIOBarInstructions);
        contents.add(fileIOBar);
        contents.add(executeActionButton);
        //end search bar

        Box borderedBox  = Box.createHorizontalBox();
        borderedBox.add(Box.createHorizontalStrut(10));
        borderedBox.add(contents);
        borderedBox.add(Box.createHorizontalStrut(10));


        myGUIFrame.setContentPane(borderedBox);
        myGUIFrame.repaint();
        myGUIFrame.revalidate();
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent theAction )
        {
            System.out.println(theAction.getActionCommand());
            if (theAction.getActionCommand().equals("Return to the Main Menu"))
            {
                //this makes it look like its going back to the main menu
                //but its more like the main menu is being inserted here
                Box borderedContents = Box.createHorizontalBox();
                borderedContents.add(Box.createHorizontalStrut(10));
                borderedContents.add(mainMenuContents);
                borderedContents.add(Box.createHorizontalStrut(10));
                myGUIFrame.setContentPane(borderedContents);
                myGUIFrame.repaint();
                myGUIFrame.revalidate();

            }

            if (theAction.getActionCommand().equals("Export current thesaurus to file"))
            {
                exportingFile = true;
                fileIOBarInstructions.setText("Where do you want to save this file? (ex. C:\\filename.txt");
                executeActionButton.setText("Export");

            }
            if (theAction.getActionCommand().equals("Load a new thesaurus from file"))
            {
                exportingFile = false;
                fileIOBarInstructions.setText("Where is the file you want to load? (ex. C:\\filename.txt");
                executeActionButton.setText("Load");
            }
        }
    }

    private class SearchBarHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent theAction)
        {
            String userInput = fileIOBar.getText();
            String errorMessage = "";
            if (userInput == null || userInput.equals(""))
            {
                errorMessage += "Please enter a valid filepath";
            }

            if (!errorMessage.equals(""))
            {
                JOptionPane.showMessageDialog(null, errorMessage);
            }
            else if (exportingFile)
            {
                String confirmation = "Are you sure you want to export the thesaurus?";
                String title = "Export?";
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);

                if (userResponse == JOptionPane.YES_OPTION)
                {
                    try {
                        //the file containing the thesaurus information
                        if (!userInput.substring(userInput.charAt(userInput.length() -5))
                        {
                            //if the last 4 chars aren't .txt, make them .txt
                            userInput+=".txt";
                        }
                        File outputFile = new File(userInput);
                        System.out.println(outputFile.getAbsolutePath());
                        FileWriter outputWriter = new FileWriter(outputFile.getAbsolutePath());

                        currentThesaurus.writeToFile(outputWriter, currentThesaurus.getEntryRoot());
                        outputWriter.close();
                        JOptionPane.showMessageDialog(null, "The new thesaurus has been saved to \r\n"
                                + outputFile.getAbsolutePath());
                    }
                    catch (IOException outputException)
                    {
                        JOptionPane.showMessageDialog(null, "I could not write to that file");
                    }
                }
            }

            else if (!exportingFile)
            {
                String confirmation = "Are you sure you want to load this thesaurus?";
                String title = "Load?";
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
                        JOptionPane.showMessageDialog(null, "The new thesaurus has been loaded");
                        currentThesaurus = newThesaurus;
                    } catch (FileNotFoundException notFoundObject) {
                        JOptionPane.showMessageDialog(null, "I could not find that file");
                    }
                }
            }
        }
    }
}
