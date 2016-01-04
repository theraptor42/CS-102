import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 5
 * Class: ViewThesaurus - frame where thesaurus is printed
 */
public class ViewThesaurus
{
    //my Jframe that I keep throughout runtime
    JFrame myGUIFrame;
    //the box that stores everything I display
    Container mainMenuContents;
    //the current database of TreeNodes
    Database currentThesaurus;

    /*
    Method: ViewThesaurus
    Purpose: constructor for ViewThesaurus
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        ViewThesaurus - the menu created
    */
    public ViewThesaurus(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
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

        //Create my event handler object which is used by all of my buttons
        ButtonHandler myButtonHandler = new ButtonHandler();

        //button to return to the main menu
        JButton returnToMainMenuButton = new JButton("Return to the Main Menu");
        //set button size
        returnToMainMenuButton.setMaximumSize(maxButtonDimension);
        //set button listenter
        returnToMainMenuButton.addActionListener(myButtonHandler);
        //add it to the contents
        contents.add(returnToMainMenuButton);

        //display are for the thesaurus
        JTextArea thesaurusTextArea = new JTextArea(currentThesaurus.toString());
        thesaurusTextArea.setEditable(false);

        //holds the display area to make it scrollable
        JScrollPane scroll = new JScrollPane(thesaurusTextArea);

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
        }
    }
}
