import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Caspian Peavyhouse - peav2414@kettering.edu
 * CS-102, Fall 2015
 * Programming Assignment 5
 * Class: GUIMenu - main menu for my GUI
 */

public class GUIMenu extends JFrame
{

    //my Jframe that I keep throughout runtime
    JFrame myGUIFrame;
    //the box that stores everything I display
    Container contents;
    //the current database of TreeNodes
    Database currentThesaurus;

    /*
    Method: GUIMenu
    Purpose: constructor for main menu
    Parameters:
        Database currentThesaurus   the database parsed from the text file
    Returns:
        GUIMenu - the menu created
    */
    public GUIMenu(Database currentThesaurus)
    {
        //set my current thesaurus
        this.currentThesaurus = currentThesaurus;
        //This is the top level menu
        //this is what creates the initial and reoccurring JFrame
        myGUIFrame = new JFrame("Program 5: Thesaurus GUI");

        //frame height for my menu
        int frameHeight = 400;
        //frame width for menu
        int frameWidth = 400;
        //frame size for menu
        Dimension GUIFrameSize = new Dimension(frameWidth, frameHeight);
        //setting for my jframe
        myGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUIFrame.setSize(GUIFrameSize);
        myGUIFrame.setVisible(true);

        //my contents are in a BoxLayout for simplicty
        contents = new Box(BoxLayout.Y_AXIS);

        //max size for my buttons
        //max button width
        int maxButtonWidth = 500;
        //max button height
        int maxButtonHeight = 30;
        //max button size
        Dimension maxButtonDimension = new Dimension(maxButtonWidth, maxButtonHeight);

        //displayed menu information
        String informationOne = "CS-102: Project Five";
        String informationTwo = "Created by Caspian Peavyhouse";
        String informationThree = "Main Menu";

        //displayed menu items
        JLabel informationLabelOne = new JLabel(informationOne);
        JLabel informationLabelTwo = new JLabel(informationTwo);
        JLabel informationLabelThree = new JLabel(informationThree);
        contents.add(informationLabelOne);
        contents.add(informationLabelTwo);
        contents.add(informationLabelThree);

        //adds spacing between my elements
        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));

        //Create my event handler object which is used by all of my buttons
        ButtonHandler myButtonHandler = new ButtonHandler();

        //button for view the entire database menu button
        JButton viewDatabaseButton = new JButton("View the Thesaurus");
        viewDatabaseButton.setMaximumSize(maxButtonDimension);
        viewDatabaseButton.addActionListener(myButtonHandler);
        contents.add(viewDatabaseButton);

        //button for search the database
        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        JButton searchDatabaseButton = new JButton("Search the Thesaurus");
        searchDatabaseButton.setMaximumSize(maxButtonDimension);
        searchDatabaseButton.addActionListener(myButtonHandler);
        contents.add(searchDatabaseButton);

        //button for add or remove an entry from the database
        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        JButton modifyEntryButton = new JButton("Add/Remove entry from the Thesaurus");
        modifyEntryButton.setMaximumSize(maxButtonDimension);
        modifyEntryButton.addActionListener(myButtonHandler);
        contents.add(modifyEntryButton);

        //button for add or remove a synonym from the database
        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        JButton modifySynonymButton = new JButton("Add/Remove synonym from the Thesaurus");
        modifySynonymButton.setMaximumSize(maxButtonDimension);
        modifySynonymButton.addActionListener(myButtonHandler);
        contents.add(modifySynonymButton);

        //button for file input and output
        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        JButton databaseFileIOButton = new JButton("Load a thesaurus/Save this thesaurus");
        databaseFileIOButton.setMaximumSize(maxButtonDimension);
        databaseFileIOButton.addActionListener(myButtonHandler);
        contents.add(databaseFileIOButton);

        //button to exit
        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(maxButtonDimension);
        exitButton.addActionListener(myButtonHandler);
        contents.add(exitButton);


        //outsideBox is used to create a 10 pixel border on the left
        //and right edges of the menu
        Box outsideBox = Box.createHorizontalBox();
        //ten pixel left side border
        outsideBox.add(Box.createHorizontalStrut(10));
        //the displayed contents
        outsideBox.add(contents);
        //ten pixel right side border
        outsideBox.add(Box.createHorizontalStrut(10));




        //sets and displays my contnts
        myGUIFrame.setContentPane(outsideBox);
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
            if (theAction.getActionCommand().equals("View the Thesaurus"))
            {
                //makes a menu to view the thesaurus
                ViewThesaurus viewThesaurus = new ViewThesaurus(myGUIFrame, currentThesaurus, contents);

            }
            else if (theAction.getActionCommand().equals("Search the Thesaurus"))
            {
                //makes a menu to search the thesaurus
                SearchMenu viewThesaurus = new SearchMenu(myGUIFrame, currentThesaurus, contents);
            }
            else if (theAction.getActionCommand().equals("Add/Remove entry from the Thesaurus"))
            {
                //makes a menu to add or remove entries
                AddRemoveEntriesMenu entriesMenu = new AddRemoveEntriesMenu(myGUIFrame, currentThesaurus, contents);
            }
            else if (theAction.getActionCommand().equals("Add/Remove synonym from the Thesaurus"))
            {
                //makes a menu to add or remove synonyms
                AddRemoveSynonymsMenu synonymMenu = new AddRemoveSynonymsMenu(myGUIFrame, currentThesaurus, contents);
            }
            else if (theAction.getActionCommand().equals("Load a thesaurus/Save this thesaurus"))
            {
                //makes a menu to load or save a thesaurus
                FileInputOutputMenu fileIOMenu = new FileInputOutputMenu(myGUIFrame, currentThesaurus, contents);
            }
            else if (theAction.getActionCommand().equals("Exit"))
            {
                //exits the program
                int normalExit = 0;
                System.exit(normalExit);
            }
        }
    }
}
