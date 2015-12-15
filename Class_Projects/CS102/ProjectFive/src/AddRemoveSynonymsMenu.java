import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Caspian on 12/13/2015.
 */

public class AddRemoveSynonymsMenu
{
    JFrame myGUIFrame;
    Database currentThesaurus;
    Container mainMenuContents;
    boolean addingNewSynonym = true;
    JTextField searchEntryBar;
    JTextField searchSynonymBar;
    JLabel searchSynonymBarInstructions;
    JButton searchSynonymBarButton;
    JTextArea resultsTextArea;

    public AddRemoveSynonymsMenu(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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

        //add the search entry bar so user can input what entry they want to change
        contents.add(Box.createVerticalStrut(10));
        JLabel searchEntryBarInstructions = new JLabel("What entry would you like to modify?");
        contents.add(searchEntryBarInstructions);

        searchEntryBar = new JTextField();
        searchEntryBar.setMaximumSize(maxTextFieldDimension);
        contents.add(searchEntryBar);
        //don't need an action listener on this
        //end search entry bar

        //Adds radio buttons to my menu
        JLabel informationLabel = new JLabel("What would you like to do?");
        contents.add(informationLabel);

        ButtonGroup myRadioButtons = new ButtonGroup();

        JRadioButton addNewSynonymButton = new JRadioButton("Add a new synonym");
        addNewSynonymButton.addActionListener(myButtonHandler);
        myRadioButtons.add(addNewSynonymButton);
        //sets addNewSynonymButton to be the preselected choice
        addNewSynonymButton.setSelected(true);

        JRadioButton removeEntryButton = new JRadioButton("Remove an existing synonym");
        removeEntryButton.addActionListener(myButtonHandler);
        myRadioButtons.add(removeEntryButton);


        contents.add(addNewSynonymButton);
        contents.add(removeEntryButton);
        //end radio buttons

        //text search bar and search button
        searchSynonymBarInstructions = new JLabel("What word would you like to add to the thesaurus");
        searchSynonymBar = new JTextField();
        searchSynonymBar.setMaximumSize(maxTextFieldDimension);
        searchSynonymBar.addActionListener(mySearchBarHandler);

        searchSynonymBarButton = new JButton("Add this");
        searchSynonymBarButton.setMaximumSize(maxButtonDimension);
        searchSynonymBarButton.addActionListener(mySearchBarHandler);

        //add spacing in my menu
        contents.add(Box.createVerticalStrut(10));
        contents.add(searchSynonymBarInstructions);
        contents.add(searchSynonymBar);
        contents.add(searchSynonymBarButton);
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

            else if (theAction.getActionCommand().equals("Add a new synonym"))
            {
                addingNewSynonym = true;
                searchSynonymBarInstructions.setText("What synonym would you like to add to the entry");
                searchSynonymBarButton.setText("Add this");
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
            }
            else if (theAction.getActionCommand().equals("Remove an existing synonym"))
            {
                addingNewSynonym = false;
                searchSynonymBarInstructions.setText("What synonym would you like to remove from the entry");
                searchSynonymBarButton.setText("Remove this");
                myGUIFrame.repaint();
                myGUIFrame.revalidate();
            }
        }
    }

    private class SearchBarHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent theAction)
        {
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

