import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Caspian on 12/14/2015.
 */
public class YesNoWindow
{
    JFrame yesNoFrame;
    boolean userResponse = false;
    public YesNoWindow(boolean returnValue, JFrame passedWindow, String confirmationMessage, String frameTitle)
    {
        yesNoFrame = passedWindow;
        int frameWidth = 400;
        int frameHeight = 200;
        Dimension frameDimension = new Dimension(frameWidth, frameHeight);
        yesNoFrame.setSize(frameDimension);
        yesNoFrame.setTitle(frameTitle);


        int maxButtonWidth = 500;
        int maxButtonHeight = 30;
        Dimension maxButtonDimension = new Dimension(maxButtonWidth, maxButtonHeight);

        ButtonHandler myButtonHandler = new ButtonHandler();



        Box contents = Box.createVerticalBox();

        JLabel confirmationLabel = new JLabel(confirmationMessage);

        Box buttonBox = Box.createHorizontalBox();

        JButton yesButton = new JButton("Yes");
        yesButton.setMaximumSize(maxButtonDimension);
        yesButton.addActionListener(myButtonHandler);

        JButton noButton = new JButton("No");
        noButton.setMaximumSize(maxButtonDimension);
        noButton.addActionListener(myButtonHandler);

        buttonBox.add(yesButton);
        buttonBox.add(noButton);


        contents.add(confirmationLabel);
        contents.add(buttonBox);

        Box borderedBox  = Box.createHorizontalBox();
        borderedBox.add(Box.createHorizontalStrut(10));
        borderedBox.add(contents);
        borderedBox.add(Box.createHorizontalStrut(10));

        yesNoFrame.setVisible(true);
        yesNoFrame.setContentPane(borderedBox);
        yesNoFrame.repaint();
        yesNoFrame.revalidate();
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent theAction)
        {
            System.out.println(theAction.getActionCommand());
            if (theAction.getActionCommand().equals("Yes"))
            {
                userResponse = true;
            }
            else
            {
                userResponse = false;
            }
        }
    }
}
