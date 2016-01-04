import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 5
 * Class: SearchMenu - frame where thesaurus is printed
 */
public class SearchMenu
{
    //my Jframe that I keep throughout runtime
    JFrame myGUIFrame;
    //the box that stores everything I display
    Container mainMenuContents;
    //the current database of TreeNodes
    Database currentThesaurus;
    //is the user searching for an entry?
    boolean searchForEntry = true;
    //text field for user input
    JTextField searchBar;
    //area where the results are displayed
    JTextArea resultsTextArea;

    /*
    Method: SearchMenu
    Purpose: constructor for SearchMenu
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        SearchMenu - the menu created
    */
    public SearchMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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
        //information label above radio buttons
        JLabel informationLabel = new JLabel("What would you like to find?");
        contents.add(informationLabel);
        //button group so only one radio button is selectable
        ButtonGroup myRadioButtons = new ButtonGroup();

        //radio button to select to find an entry
        JRadioButton selectEntryButton = new JRadioButton("Entry");
        selectEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(selectEntryButton);
        //sets selectEntryButton to be the preselected choice
        selectEntryButton.setSelected(true);

        //radio button to select to find an entry
        JRadioButton selectSynButton = new JRadioButton("Synonym");
        selectSynButton.addActionListener(myButtonHandler);
        myRadioButtons.add(selectSynButton);

        //add the buttons to the contents
        contents.add(selectEntryButton);
        contents.add(selectSynButton);
        //end radio buttons

        //text search bar and search button
        //info label above my search bar
        JLabel searchBarInstructions = new JLabel("Enter your search here");
        //what is the user trying to find?
        searchBar = new JTextField();
        //search bar settings
        searchBar.setMaximumSize(maxTextFieldDimension);
        searchBar.addActionListener(mySearchBarHandler);

        //button below the search bar
        JButton searchButton = new JButton("Search");
        searchButton.setMaximumSize(maxButtonDimension);
        searchButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(searchBarInstructions);
        contents.add(searchBar);
        contents.add(searchButton);
        //end search bar

        //search results area
        resultsTextArea = new JTextArea("Your search results will appear here");
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
        Purpose: simple button listenter that controls what button click do
        Parameters:
            ActionEvent theAction - what event am I responding to
        Returns:
            none
        */
        public void actionPerformed(ActionEvent theAction)
        {
            //click from return to main menu button
            if (theAction.getActionCommand().equals("Return to the Main Menu"))
            {
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

            //radio button click
            else if (theAction.getActionCommand().equals("Entry"))
            {
                //I am searching for an entry
                searchForEntry = true;
            }
            //radio button click
            else if (theAction.getActionCommand().equals("Synonym"))
            {
                //I am searching for a synonym
                searchForEntry = false;
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
            //whats in the search bar right now?
            String searchedFor = searchBar.getText();
            if (searchedFor == null || searchedFor.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please type something in the search bar");
            }
            if (searchForEntry)
            {
                //put the results in the search results area
                resultsTextArea.setText(currentThesaurus.searchForWord(searchedFor));
            }
            else if (searchForEntry == false)
            {
                //put the results in the search results area
                resultsTextArea.setText(currentThesaurus.searchForSynonym(searchedFor));
            }
        }
    }
}

