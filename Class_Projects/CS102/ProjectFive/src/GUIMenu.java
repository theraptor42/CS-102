import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Caspian on 12/9/2015.
 */
public class GUIMenu extends JFrame
{

    JFrame myGUIFrame;
    Container contents;
    Database currentThesaurus;
    public GUIMenu(Database currentThesaurus)
    {
        this.currentThesaurus = currentThesaurus;
        //This is the top level menu
        //this is what creates the initial and reoccurring JFrame
        myGUIFrame = new JFrame("Program 5: Thesaurus GUI");
        int frameHeight = 400;
        int frameWidth = 400;
        Dimension GUIFrameSize = new Dimension(frameWidth, frameHeight);
        myGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUIFrame.setSize(GUIFrameSize);
        myGUIFrame.setVisible(true);

        contents = new Box(BoxLayout.Y_AXIS);

        int maxButtonWidth = 500;
        int maxButtonHeight = 30;
        Dimension maxButtonDimension = new Dimension(maxButtonWidth, maxButtonHeight);

        String informationOne = "CS-102: Project Five";
        String informationTwo = "Created by Caspian Peavyhouse";
        String informationThree = "Main Menu";

        JLabel informationLabelOne = new JLabel(informationOne);
        JLabel informationLabelTwo = new JLabel(informationTwo);
        JLabel informationLabelThree = new JLabel(informationThree);
        contents.add(informationLabelOne);
        contents.add(informationLabelTwo);
        contents.add(informationLabelThree);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));

        //Create my event handler object which is used by all of my buttons
        ButtonHandler myButtonHandler = new ButtonHandler();

        //view the entire database
        JButton viewDatabaseButton = new JButton("View the Thesaurus");
        viewDatabaseButton.setMaximumSize(maxButtonDimension);
        viewDatabaseButton.addActionListener(myButtonHandler);
        contents.add(viewDatabaseButton);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        //search the database
        JButton searchDatabaseButton = new JButton("Search the Thesaurus");
        searchDatabaseButton.setMaximumSize(maxButtonDimension);
        searchDatabaseButton.addActionListener(myButtonHandler);
        contents.add(searchDatabaseButton);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        //add or remove an entry from the database
        JButton modifyEntryButton = new JButton("Add/Remove entry from the Thesaurus");
        modifyEntryButton.setMaximumSize(maxButtonDimension);
        modifyEntryButton.addActionListener(myButtonHandler);
        contents.add(modifyEntryButton);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        //add or remove a synonym from the database
        JButton modifySynonymButton = new JButton("Add/Remove synonym from the Thesaurus");
        modifySynonymButton.setMaximumSize(maxButtonDimension);
        modifySynonymButton.addActionListener(myButtonHandler);
        contents.add(modifySynonymButton);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        //send the database to a file
        JButton databaseToFileButton = new JButton("Send Thesaurus to file");
        databaseToFileButton.setMaximumSize(maxButtonDimension);
        databaseToFileButton.addActionListener(myButtonHandler);
        contents.add(databaseToFileButton);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        //load database from a file
        JButton loadFromFileButton = new JButton("Load Thesaurus from file");
        loadFromFileButton.setMaximumSize(maxButtonDimension);
        loadFromFileButton.addActionListener(myButtonHandler);
        contents.add(loadFromFileButton);

        contents.add(Box.createVerticalStrut(/*invisible height of*/ 10));
        //exit
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




        //myGUIFrame.setContentPane(contents);
        myGUIFrame.setContentPane(outsideBox);
        myGUIFrame.repaint();
        myGUIFrame.revalidate();
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent theAction)
        {
            System.out.println(theAction.getActionCommand());
            Container localContents = contents;

            if (theAction.getActionCommand().equals("View the Thesaurus"))
            {
                ViewThesaurus viewThesaurus = new ViewThesaurus(myGUIFrame, currentThesaurus, contents);

            }
            else if (theAction.getActionCommand().equals("Search the Thesaurus"))
            {
                SearchMenu viewThesaurus = new SearchMenu(myGUIFrame, currentThesaurus, contents);
            }
            else if (theAction.getActionCommand().equals("Add/Remove entry from the Thesaurus"))
            {
                AddRemoveEntriesMenu entriesMenu = new AddRemoveEntriesMenu(myGUIFrame, currentThesaurus, contents);
            }
            else if (theAction.getActionCommand().equals("Add/Remove synonym from the Thesaurus"))
            {
                int normalExit = 0;
                //System.exit(normalExit);
            }
            else if (theAction.getActionCommand().equals("Send Thesaurus to file"))
            {
                int normalExit = 0;
                System.exit(normalExit);
            }
            else if (theAction.getActionCommand().equals("Load Thesaurus from file"))
            {
                int normalExit = 0;
                System.exit(normalExit);
            }
            else if (theAction.getActionCommand().equals("Exit"))
            {
                int normalExit = 0;
                System.exit(normalExit);
            }
        }
    }
}
