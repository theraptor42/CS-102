import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Caspian on 12/13/2015.
 */
public class AddRemoveEntriesMenu
{
    JFrame myGUIFrame;
    Database currentThesaurus;
    Container mainMenuContents;
    boolean addingNewEntry = true;
    JTextField searchBar;
    JTextArea resultsTextArea;
    JLabel searchBarInstructions;
    JButton searchBarButton;
    public AddRemoveEntriesMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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

        JLabel informationLabel = new JLabel("What would you like to do?");
        contents.add(informationLabel);

        //Adds radio buttons to my menu
        ButtonGroup myRadioButtons = new ButtonGroup();

        JRadioButton addNewEntryButton = new JRadioButton("Add a new entry");
        addNewEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(addNewEntryButton);
        //sets addNewEntryButton to be the preselected choice
        addNewEntryButton.setSelected(true);

        JRadioButton removeEntryButton = new JRadioButton("Remove an existing entry");
        removeEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(removeEntryButton);


        contents.add(addNewEntryButton);
        contents.add(removeEntryButton);
        //end radio buttons

        //text search bar and search button
        searchBarInstructions = new JLabel("What word would you like to add to the thesaurus");
        searchBar = new JTextField();
        searchBar.setMaximumSize(maxTextFieldDimension);
        searchBar.addActionListener(mySearchBarHandler);

        searchBarButton = new JButton("Add this");
        searchBarButton.setMaximumSize(maxButtonDimension);
        searchBarButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(searchBarInstructions);
        contents.add(searchBar);
        contents.add(searchBarButton);
        //end search bar

        //search results area
        resultsTextArea = new JTextArea(currentThesaurus.toString());
        resultsTextArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(resultsTextArea);

        contents.add(scroll);
        //end search results

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
        public void actionPerformed(ActionEvent theAction)
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

            else if (theAction.getActionCommand().equals("Add a new entry"))
            {
                addingNewEntry = true;
                searchBarInstructions.setText("What word would you like to add to the thesaurus");
                searchBarButton.setText("Add this");
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
            }
            else if (theAction.getActionCommand().equals("Remove an existing entry"))
            {
                addingNewEntry = false;
                searchBarInstructions.setText("What word would you like to remove from the thesaurus");
                searchBarButton.setText("Remove this");
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
            }

            /*else if (theAction.getActionCommand().equals("Add this") ||
                     theAction.getActionCommand().equals("Remove this"))
            {
                if (addingNewEntry == true)
                {
                    System.out.println("Search Entry");
                }
                else if (addingNewEntry == false)
                {
                    System.out.println("Search Synonym");
                }
            }*/
        }
    }

    private class SearchBarHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent theAction)
        {
            String userInput = searchBar.getText();
            if (userInput == null || userInput.equals(""))
            {
                resultsTextArea.setText("I can't search for nothing");
            }
            if (addingNewEntry)
            {
                String confirmation = "Are you sure you want to add " + userInput + "?";
                String title = "Add this?";
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    boolean successful = currentThesaurus.addEntryFromMenu(userInput);
                    String resultMessage = "";
                    if (successful)
                    {
                        resultMessage = userInput + " was successfully added";
                    }
                    else
                    {
                        resultMessage = userInput + " is already in the thesaurus";
                    }
                    JOptionPane.showMessageDialog(null, resultMessage);
                    resultsTextArea.setText(currentThesaurus.toString());
                }

            }
            else if (addingNewEntry == false)
            {
                String confirmation = "Are you sure you want to remove " + userInput + "?";
                String title = "Remove this?";
                int userResponse = JOptionPane.showConfirmDialog(null, confirmation, title, JOptionPane.YES_NO_OPTION);
                if (userResponse == JOptionPane.YES_OPTION)
                {
                    boolean successful = currentThesaurus.removeEntryFromMenu(userInput);
                    String resultMessage = "";
                    if (successful)
                    {
                        resultMessage = userInput + " was successfully removed";
                    }
                    else
                    {
                        resultMessage = userInput + " was not found in the thesaurus";
                    }
                    JOptionPane.showMessageDialog(null, resultMessage);
                    resultsTextArea.setText(currentThesaurus.toString());


                }

            }
        }
    }
}
