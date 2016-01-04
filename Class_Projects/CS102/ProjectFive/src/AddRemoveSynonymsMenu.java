import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 5
 * Class: AddRemoveSynonymsMenu - frame where synonyms are added or removed
 */
public class AddRemoveSynonymsMenu
{
    //my Jframe that I keep throughout runtime
    JFrame myGUIFrame;
    //the box that stores everything I display
    Container mainMenuContents;
    //the current database of TreeNodes
    Database currentThesaurus;
    //is the adding a synonym?
    boolean addingNewSynonym = true;
    //text field for user input on what entry to modify
    JTextField searchEntryBar;
    //text field for user input on what synonym to apply
    JTextField searchSynonymBar;
    //instructions over the synonym input bar
    JLabel searchSynonymBarInstructions;
    ///button below the user input bar
    JButton searchSynonymBarButton;
    //area where the results are displayed
    JTextArea resultsTextArea;

    /*
    Method: AddRemoveSynonymsMenu
    Purpose: constructor for AddRemoveSynonymsMenu
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        AddRemoveSynonymsMenu - the menu created
    */
    public AddRemoveSynonymsMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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

        //add the search entry bar so user can input what entry they want to change
        contents.add(Box.createVerticalStrut(10));
        JLabel searchEntryBarInstructions = new JLabel("What entry would you like to modify?");
        contents.add(searchEntryBarInstructions);

        //where the usre inputs what entry they want to modify
        searchEntryBar = new JTextField();
        searchEntryBar.setMaximumSize(maxTextFieldDimension);
        contents.add(searchEntryBar);
        //don't need an action listener on this
        //end search entry bar

        //Adds radio buttons to my menu
        JLabel informationLabel = new JLabel("What would you like to do?");
        contents.add(informationLabel);

        //button group so only one radio button is selectable
        ButtonGroup myRadioButtons = new ButtonGroup();

        //radio button to select to add a new synonym
        JRadioButton addNewSynonymButton = new JRadioButton("Add a new synonym");
        addNewSynonymButton.addActionListener(myButtonHandler);
        myRadioButtons.add(addNewSynonymButton);
        //sets addNewSynonymButton to be the preselected choice
        addNewSynonymButton.setSelected(true);

        //radio button to select to remove a synonym
        JRadioButton removeEntryButton = new JRadioButton("Remove an existing synonym");
        removeEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(removeEntryButton);


        contents.add(addNewSynonymButton);
        contents.add(removeEntryButton);
        //end radio buttons

        //text search bar and search button
        //info label above my search bar
        searchSynonymBarInstructions = new JLabel("What word would you like to add to the thesaurus");
        //what is the synonym the user wants to change?
        searchSynonymBar = new JTextField();
        //search bar settings
        searchSynonymBar.setMaximumSize(maxTextFieldDimension);
        searchSynonymBar.addActionListener(mySearchBarHandler);

        //button below my search bar, like hitting enter int the bar
        searchSynonymBarButton = new JButton("Add this");
        searchSynonymBarButton.setMaximumSize(maxButtonDimension);
        searchSynonymBarButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(searchSynonymBarInstructions);
        contents.add(searchSynonymBar);
        contents.add(searchSynonymBarButton);
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

            else if (theAction.getActionCommand().equals("Add a new synonym"))
            {
                //I am adding asynonym
                addingNewSynonym = true;
                //change the instructions
                searchSynonymBarInstructions.setText("What synonym would you like to add to the entry");
                //change the button
                searchSynonymBarButton.setText("Add this");
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
            }
            else if (theAction.getActionCommand().equals("Remove an existing synonym"))
            {
                //I am removing a synonym
                addingNewSynonym = false;
                //change the instructions
                searchSynonymBarInstructions.setText("What synonym would you like to remove from the entry");
                //change the button
                searchSynonymBarButton.setText("Remove this");
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
            //what entry is the user modifying
            String entryBarText = searchEntryBar.getText();
            String synonymBarText = searchSynonymBar.getText();
            String errorMessage= "";
            TreeNode entryToModify = null;
            if (entryBarText == null || entryBarText.equals(""))
            {
                errorMessage += "Please enter an entry to modify\r\n";
            }
            else if (!currentThesaurus.containsEntry(entryBarText))
            {
                errorMessage += "That entry was not found in the thesaurus\r\n";
            }
            else
            {
                //only create this if the text is there and the entry exists
                entryToModify = TreeNode.getNodeByString(entryBarText, currentThesaurus.getEntryRoot());
            }
            if (synonymBarText == null || synonymBarText.equals(""))
            {
                errorMessage += "Please enter a synonym to add/remove";
            }

            if (!errorMessage.equals(""))
            {
                JOptionPane.showMessageDialog(null, errorMessage);
            }
            //if it passes this point, it has an entry to modify
            //and the syn search bar has text
            else if (addingNewSynonym)
            {
                //info for joption promt
                String confirmation = "Are you sure you want to add " + synonymBarText + "?";
                String title = "Add this?";
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    //if this throw a null pointer exception, I did my iff block wrong
                    boolean successful = entryToModify.addSynonymInOrder(synonymBarText);
                    String resultMessage = "";
                    if (successful)
                    {
                        resultMessage = synonymBarText + " was successfully added";
                    }
                    else
                    {
                        resultMessage = entryBarText + " already has that synonym";
                    }
                    JOptionPane.showMessageDialog(null, resultMessage);
                    resultsTextArea.setText(currentThesaurus.toString());
                }

            }
            else if (addingNewSynonym == false)
            {
                //infor for joption promt
                String confirmation = "Are you sure you want to remove " + synonymBarText + "?";
                String title = "Remove this?";
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    boolean successful = entryToModify.removeSynonym(synonymBarText);
                    String resultMessage = "";
                    if (successful)
                    {
                        resultMessage = synonymBarText + " was successfully removed";
                    }
                    else
                    {
                        resultMessage = entryBarText + " does not have that synonym";
                    }
                    JOptionPane.showMessageDialog(null, resultMessage);
                    resultsTextArea.setText(currentThesaurus.toString());
                }

            }
        }
    }
}

