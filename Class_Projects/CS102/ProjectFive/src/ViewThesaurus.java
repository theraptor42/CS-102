import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Caspian on 12/13/2015.
 */
public class ViewThesaurus
{
    JFrame myGUIFrame;
    Database currentThesaurus;
    Container mainMenuContents;

    public ViewThesaurus(JFrame GUIFrame, Database currentThesaurus, Container mainMenuContents)
    {
        this.myGUIFrame = GUIFrame;
        this.currentThesaurus = currentThesaurus;
        this.mainMenuContents = mainMenuContents;


        Container contents = new Box(BoxLayout.Y_AXIS);

        int maxButtonWidth = 500;
        int maxButtonHeight = 30;
        Dimension maxButtonDimension = new Dimension(maxButtonWidth, maxButtonHeight);

        ButtonHandler myButtonHandler = new ButtonHandler();

        JButton returnToMainMenuButton = new JButton("Return to the Main Menu");
        returnToMainMenuButton.setMaximumSize(maxButtonDimension);
        returnToMainMenuButton.addActionListener(myButtonHandler);
        contents.add(returnToMainMenuButton);

        JTextArea thesaurusTextArea = new JTextArea(currentThesaurus.toString());
        thesaurusTextArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(thesaurusTextArea);

        contents.add(scroll);

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
        public void actionPerformed( ActionEvent theAction )
        {
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
        }
    }
}
