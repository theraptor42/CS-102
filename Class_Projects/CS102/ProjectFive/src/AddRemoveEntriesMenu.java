import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 5
 * Class: AddRemoveEntriesMenu - frame where entries are added or removed
 */
public class AddRemoveEntriesMenu
{
    //my Jframe that I keep throughout runtime
    JFrame myGUIFrame;
    //the box that stores everything I display
    Container mainMenuContents;
    //the current database of TreeNodes
    Database currentThesaurus;
    //is the adding an entry?
    boolean addingNewEntry = true;
    //text field for user input
    JTextField searchBar;
    //area where the results are displayed
    JTextArea resultsTextArea;
    //label above the user input search bar
    JLabel searchBarInstructions;
    //button below the user input bar
    JButton searchBarButton;


    /*
    Method: AddRemoveEntriesMenu
    Purpose: constructor for AddRemoveEntrieMenu
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        AddRemoveEntriesMenu - the menu created
    */
    public AddRemoveEntriesMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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
        //info label above my radio buttons
        JLabel informationLabel = new JLabel("What would you like to do?");
        contents.add(informationLabel);
        //button group so only one radio button is selectable
        ButtonGroup myRadioButtons = new ButtonGroup();

        //radio button to select to add a new entry
        JRadioButton addNewEntryButton = new JRadioButton("Add a new entry");
        addNewEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(addNewEntryButton);
        //sets addNewEntryButton to be the preselected choice
        addNewEntryButton.setSelected(true);

        //radio button to select to remove an entry
        JRadioButton removeEntryButton = new JRadioButton("Remove an existing entry");
        removeEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(removeEntryButton);

        //add the buttons to the contents
        contents.add(addNewEntryButton);
        contents.add(removeEntryButton);
        //end radio buttons

        //text search bar and search button
        //info label above my search bar
        searchBarInstructions = new JLabel("What word would you like to add to the thesaurus");
        //what is the user trying to find?
        searchBar = new JTextField();
        //search bar settings
        searchBar.setMaximumSize(maxTextFieldDimension);
        searchBar.addActionListener(mySearchBarHandler);

        //button below the search bar
        searchBarButton = new JButton("Add this");
        searchBarButton.setMaximumSize(maxButtonDimension);
        searchBarButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(searchBarInstructions);
        contents.add(searchBar);
        contents.add(searchBarButton);
        //end search bar

        //prints out the database with new changes
        resultsTextArea = new JTextArea(currentThesaurus.toString());
        resultsTextArea.setEditable(false);

        //holds the display area to make it scrollable
        JScrollPane scroll = new JScrollPane(resultsTextArea);

        contents.add(scroll);

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
        public void actionPerformed(ActionEvent theAction)
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

            else if (theAction.getActionCommand().equals("Add a new entry"))
            {
                //I am add an entry
                addingNewEntry = true;
                //change the instructions
                searchBarInstructions.setText("What word would you like to add to the thesaurus");
                //change the button
                searchBarButton.setText("Add this");
                //refresh
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
            }
            else if (theAction.getActionCommand().equals("Remove an existing entry"))
            {
                //I am removing an entry
                addingNewEntry = false;
                //change the instructions
                searchBarInstructions.setText("What word would you like to remove from the thesaurus");
                //change the button
                searchBarButton.setText("Remove this");
                //refresh
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
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
            String userInput = searchBar.getText();
            if (userInput == null || userInput.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please type something in the text bar");
            }
            if (addingNewEntry)
            {
                //confirms the user really wnated to do this
                String confirmation = "Are you sure you want to add " + userInput + "?";
                String title = "Add this?";
                //what did the user say to the prompt?
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    //add the new entry
                    boolean successful = currentThesaurus.addEntryFromMenu(userInput);
                    String resultMessage = "";
                    if (successful)
                    {
                        //success
                        resultMessage = userInput + " was successfully added";
                    }
                    else
                    {
                        //failure
                        resultMessage = userInput + " is already in the thesaurus";
                    }
                    //tell the user what happened
                    JOptionPane.showMessageDialog(null, resultMessage);
                    resultsTextArea.setText(currentThesaurus.toString());
                }

            }
            else if (addingNewEntry == false)
            {
                //confirms the user really wnated to do this
                String confirmation = "Are you sure you want to remove " + userInput + "?";
                String title = "Remove this?";
                //what did the user say to the prompt?
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    //remove the entry
                    boolean successful = currentThesaurus.removeEntryFromMenu(userInput);
                    String resultMessage = "";
                    if (successful)
                    {
                        //success
                        resultMessage = userInput + " was successfully removed";
                    }
                    else
                    {
                        //failure
                        resultMessage = userInput + " was not found in the thesaurus";
                    }
                    //tell the user what happened
                    JOptionPane.showMessageDialog(null, resultMessage);
                    resultsTextArea.setText(currentThesaurus.toString());
                }
            }
        }
    }
}
