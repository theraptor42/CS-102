import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Caspian on 12/13/2015.
 */
public class SearchMenu
{
    JFrame myGUIFrame;
    Database currentThesaurus;
    Container mainMenuContents;
    boolean searchForEntry = true;
    JTextField searchBar;
    JTextArea resultsTextArea;
    public SearchMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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

        JLabel informationLabel = new JLabel("What would you like to find?");
        contents.add(informationLabel);

        //Adds radio buttons to my menu
        ButtonGroup myRadioButtons = new ButtonGroup();

        JRadioButton selectEntryButton = new JRadioButton("Entry");
        selectEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(selectEntryButton);
        //sets selectEntryButton to be the preselected choice
        selectEntryButton.setSelected(true);

        JRadioButton selectSynButton = new JRadioButton("Synonym");
        selectSynButton.addActionListener(myButtonHandler);
        myRadioButtons.add(selectSynButton);


        contents.add(selectEntryButton);
        contents.add(selectSynButton);
        //end radio buttons

        //text search bar and search button
        JLabel searchBarInstructions = new JLabel("Enter your search here");
        searchBar = new JTextField();
        searchBar.setMaximumSize(maxTextFieldDimension);
        searchBar.addActionListener(mySearchBarHandler);

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

            else if (theAction.getActionCommand().equals("Entry"))
            {
                searchForEntry = true;
            }
            else if (theAction.getActionCommand().equals("Synonym"))
            {
                searchForEntry = false;
            }

            else if (theAction.getActionCommand().equals("Search"))
            {
                if (searchForEntry == true)
                {
                    System.out.println("Search Entry");
                }
                else if (searchForEntry == false)
                {
                    System.out.println("Search Synonym");
                }
            }
        }
    }

    private class SearchBarHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent theAction)
        {
            String searchedFor = searchBar.getText();
            if (searchedFor == null || searchedFor.equals(""))
            {
                resultsTextArea.setText("I can't search for nothing");
            }
            if (searchForEntry)
            {
                resultsTextArea.setText(currentThesaurus.searchForWord(searchedFor));
            }
            else if (searchForEntry == false)
            {
                resultsTextArea.setText(currentThesaurus.searchForSynonym(searchedFor));
            }
        }
    }
}

