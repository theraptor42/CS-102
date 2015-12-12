import javax.swing.*;
import java.awt.*;

/**
 * Created by Caspian on 12/9/2015.
 */
public class GUI
{
    public static void main(String[] args)
    {
        mainMenu();
    }

    public static void mainMenu(/*JFrame myGUIFrame, Database currentThesaurus*/)
    {
        String frameTitle = "Program 5: Thesaurus GUI";
        int frameHeight = 400;
        int frameWidth = 400;
        Dimension GUIFrameSize = new Dimension(frameWidth, frameHeight);

        JFrame myGUIFrame = new JFrame(frameTitle);
        myGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUIFrame.setSize(GUIFrameSize);
        myGUIFrame.setVisible(true);


        searchForWordMenu(myGUIFrame);

    }

    public static void backToMainMenu(Database currentThesaurus)
    {
        //mainMenu(currentThesaurus);
    }

    public static void searchForWordMenu(JFrame myGUIFrame/*, Database currentThesaurus*/)
    {
        myGUIFrame.getContentPane().removeAll();
        myGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUIFrame.setSize(400,400);
        myGUIFrame.setVisible(true);


        //has a go back to main menu button
        //has a text search bar and an enter button
        //below is a text area to display the results

        //search for word in the thesaurus returns a string


        GridBagLayout menuAreaLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        Dimension menuDimension = new Dimension(400,200);
        Container menuArea = new Container();
        menuArea.setSize(menuDimension);
        menuArea.setLayout(menuAreaLayout);
        menuArea.setVisible(true);


        JButton backToMainMenuJButton = new JButton("Go back to Main Menu");
        int buttonHeight = 20;
        int buttonLength = 40;
        Dimension buttonDimension = new Dimension(buttonLength, buttonHeight);

        backToMainMenuJButton.setSize(buttonDimension);
        backToMainMenuJButton.setVisible(true);
        constraints.weightx = .1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        menuArea.add(backToMainMenuJButton, constraints);


        JTextField textSearchBar = new JTextField();
        int searchBarHeight = 20;
        int searchBarLength = 80;
        textSearchBar.setSize(searchBarLength, searchBarHeight);
        textSearchBar.setVisible(true);

        constraints.weightx = .5;
        constraints.gridx = 1;
        constraints.gridy = 3;
        menuArea.add(textSearchBar, constraints);

        JButton enterSearchButton = new JButton("Search");
        enterSearchButton.setSize(buttonDimension);
        enterSearchButton.setVisible(true);

        constraints.weightx = .1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 3;
        menuArea.add(enterSearchButton, constraints);




        myGUIFrame.setLayout(new BorderLayout());
        myGUIFrame.add(menuArea, BorderLayout.NORTH);

        menuArea.revalidate();
        menuArea.repaint();
        myGUIFrame.revalidate();
        myGUIFrame.repaint();
    }

}
