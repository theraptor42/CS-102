//Purpose: To take an input amount of change and output the dollar ammount of the change
//Caspian Peavyhouse
//CS101-02
//10/20/2014

import javax.swing.*;
import java.text.*;

public class ValueOfChange
{

/*
     Algorithm for main(args)
main(args)
  start algorithm here  

VALUEOFPENNY   -> .01
VALUEOFNICKEL  -> .05
VALUEOFDIME    -> .10
VALUEOFQUARTER -> .25

InputNumberOfPennies = JOptionPane.showInputDialog("How many pennies?")
InputNumberOfNickels = JOptionPane.showInputDialog("How many nickels?")
InputNumberOfDimes = JOptionPane.showInputDialog("How many dimes?")
InputNumberOfQuarters = JOptionPane.showInputDialog("How many quarters?")

numberOfPennies = Integer.parseInt(InputNumberOfPennies)
numberOfNickels = Integer.parseInt(InputNumberOfNickels)
numberOfDimes = Integer.parseInt(InputNumberOfDimes)
numberOfQuarters = Integer.parseInt(InputNumberOfQuarters)


valueOfPennies = numberOfPennies * VALUEOFPENNY
valueOfNickels = numberOfNickels * VALUEOFNICKEL
valueOfDimes = numberOfDimes * VALUEOFDIME
valueOfQuarters = numberOfQuarters * VALUEOFQUARTER

double totalChange = valueOfPennies + valueOfNickels + valueOfDimes + valueOfQuarters

DecimalFormat changeFormat = new DecimalFormat("$#,##0.00")

String outputChange = changeFormat.format(totalChange)
System.out.println("Your change has monetary value: " + outputChange)

*/

/*
     Data Table for main
     
Variable or Constant         Purpose
____________________         __________________
args                         parameter for main
VALUEOFPENNY                 stores the value of a penny
VALUEOFNICKEL                stores the value of a nickel
VALUEOFDIME                  stores the value of a dime
VALUEOFQUARTER               stores the value of a quarter

inputNumberOfPennies         stores the input number of pennies
inputNumberOfNickels         stores the input number of nickels
inputNumberOfDimes           stores the input number of dimes
inputNumberOfQuarters        stores the input number of quarters

numberOfPennies              stores the converted integer number of pennies
numberOfNickels              stores the converted integer number of nickels
numberOfDimes                stores the converted integer number of dimes
numberOfQuarters             stores the converted integer number of quarters


moneyInPennies               stores the total money value of pennies 
moneyInNickels               stores the total money value of nickels
moneyInDimes                 stores the total money value of dimes
moneyInQuarters              stores the total money value of quarters

totalChange                  the total output value of all input change
*/

  public static void main(String [] args)
  {
  
   final double VALUEOFPENNY = .01;
   final double VALUEOFNICKEL = .05;
   final double VALUEOFDIME = .10;
   final double VALUEOFQUARTER = .25;
   
   String inputNumberOfPennies = JOptionPane.showInputDialog(null, "How many pennies?");
   String inputNumberOfNickels = JOptionPane.showInputDialog(null, "How many nickels?");
   String inputNumberOfDimes = JOptionPane.showInputDialog(null, "How many dimes?");
   String inputNumberOfQuarters = JOptionPane.showInputDialog(null, "How many quarters?");
   
   
   int numberOfPennies = Integer.parseInt(inputNumberOfPennies);
   int numberOfNickels = Integer.parseInt(inputNumberOfNickels);
   int numberOfDimes = Integer.parseInt(inputNumberOfDimes);
   int numberOfQuarters = Integer.parseInt(inputNumberOfQuarters);
   
   
   double moneyInPennies = numberOfPennies * VALUEOFPENNY;
   double moneyInNickels = numberOfNickels * VALUEOFNICKEL;
   double moneyInDimes = numberOfDimes * VALUEOFDIME;
   double moneyInQuarters = numberOfQuarters * VALUEOFQUARTER;
   
   double totalChange = moneyInPennies + moneyInNickels + moneyInDimes + moneyInQuarters;
   
   DecimalFormat changeFormat = new DecimalFormat("$#,##0.00");
   
   String outputChange = changeFormat.format(totalChange);
   System.out.println("Your change has monetary value: " + outputChange);
  
  }//main(args)
}//class Template