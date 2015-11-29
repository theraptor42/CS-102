/** Nesting components using layout managers
*   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BridgeRules extends JFrame
{
 private Container contents;

 // 1st row, column 1
 private JPanel questionPanel;
 private JButton [] questionButtons;
 private String [] questionNames = {
            "Dummy is North, who plays ?",
            "Dummy is East, who plays ?",
            "Dummy is South, who plays ?",
            "Dummy is West, who plays ?" };

 private JButton reset;

 // 1st row, column 2
 private JPanel gamePanel;
 private JLabel gameTable;
 private JLabel [] gameLabels;

 public BridgeRules( )
 {
  super( "At the Bridge Table" );

  contents = getContentPane( );
  contents.setLayout( new GridLayout( 1, 2 ) );

  // 1st row, col 1: question buttons and reset button
  questionPanel = new JPanel( );
  questionPanel.setLayout( new GridLayout( 5, 1 ) );

  QuestionButtonHandler qbh = new QuestionButtonHandler( );
  questionButtons = new JButton[questionNames.length];

  for ( int i = 0; i < questionNames.length; i ++ )
  {
     questionButtons[i] = new JButton( questionNames[i] );
     questionButtons[i].addActionListener( qbh );
     questionPanel.add( questionButtons[i] );
  }

  reset = new JButton( "Show all players" );
  ResetButtonHandler rbh = new ResetButtonHandler( );
  reset.addActionListener( rbh );

  questionPanel.add( reset );

  // 1st row, column 2: gamePanel contains the players and table
  gamePanel = new JPanel( );
  gamePanel.setLayout( new BorderLayout( 3, 3 ) );
  gameLabels = new JLabel[4];
  gameLabels[0] = new JLabel( "North", SwingConstants.CENTER );
  gameLabels[1] = new JLabel( "East", SwingConstants.CENTER );
  gameLabels[2] = new JLabel( "South", SwingConstants.CENTER );
  gameLabels[3] = new JLabel( "West", SwingConstants.CENTER );

  gameTable = new JLabel( );
  gameTable.setBackground( Color.GREEN );
  gameTable.setOpaque( true );

  gamePanel.add( gameLabels[0], BorderLayout.NORTH );
  gamePanel.add( gameLabels[1], BorderLayout.EAST );
  gamePanel.add( gameLabels[2], BorderLayout.SOUTH );
  gamePanel.add( gameLabels[3], BorderLayout.WEST );
  gamePanel.add( gameTable, BorderLayout.CENTER );

  // add panels to content pane
  contents.add( questionPanel );
  contents.add( gamePanel );

  setSize( 410, 200 );
  setVisible( true );
 }

 private class QuestionButtonHandler
                        implements ActionListener
 {
  public void actionPerformed( ActionEvent ae )
  {
   for ( int i = 0; i < questionButtons.length; i++ )
   {
     if ( ae.getSource( ) == questionButtons[i] )
       gameLabels[i].setVisible( false );
     else
       gameLabels[i].setVisible( true );
   }
  }
 }

 private class ResetButtonHandler
                           implements ActionListener
 {
   public void actionPerformed( ActionEvent ae )
   {
      for ( int i = 0; i < gameLabels.length; i++ )
         gameLabels[i].setVisible( true );
   }
 }

 public static void main( String [] args )
 {
   BridgeRules myNestedLayout = new BridgeRules( );
   myNestedLayout.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}