//Purpose: to convert an input binary value to decimal
//Caspian Peavyhouse
//CS101-02
//November 11, 2014

import java.util.*;
import java.io.*;

public class BinaryToDecimal
{
/*
     Algorithm for main(args)
main(args)

File inputFile = new File(args[0])
Scanner fileScan = new Scanner(inputFile)

File outputFile = new File(args[1]);      
PrintStream fileWriter = new PrintStream(outputFile)

fileWriter.println("Binary to Decimal Conversion")
fileWriter.println("Caspian Peavyhouse")
fileWriter.println("CS101-02\n")


int lineNumber => 1
int characterValue => 0
int lineValue => 0
String lineOutput = new String("")
boolean invalidCharacters

while (fileScan.hasNextLine())
{
   String currentLine = fileScan.nextLine();
   lineValue = 0;
   for (int index = 0; index < currentLine.length(); index += 1)
   {  
      ***This portion checks  to see if there is leading or trailing whitespace in a line
      and if there is, removes it***
      if (index == 0 && currentLine.charAt(index) == ' ')
      {
         currentLine = currentLine.substring(1, currentLine.length())
      }
      if (index == (currentLine.length() - 1) && currentLine.charAt(index) == ' ')
      {
         currentLine = currentLine.substring(0, currentLine.length() - 1)
      }
      
      
      ***This section checks to see if the line contains invalid characters***
      if (currentLine.charAt(index) != '1' && currentLine.charAt(index) != '0')
      {
         lineOutput = ("Line " + lineNumber + " is invalid")
         invalidCharacters = true
         break
      }
   ***If the line is only 1's or 0's this calculates the decimal value***
   else
   {
      characterValue = Integer.parseInt("" + currentLine.charAt(index));
      int exponentMultiplier = 1
      
     ***This  part  is the actual calculation of the binary conversion
     ***Using a for loop to account for the exponent of the digit***
         for(int digit = currentLine.length() - 1;(digit - index) > 0  ; digit--)
         {
            exponentMultiplier *= 2
         }
         
         int characterBinary = characterValue * exponentMultiplier
         lineValue += characterBinary   
         invalidCharacters = false  
      }
      
         ***if there were invalid characters in the line, the invalid message is printed
			***else the line value is printed***
         if (invalidCharacters == false)
         {
            lineOutput = Integer.toString(lineValue)
         }
      }
      fileWriter.println(lineOutput)
      lineNumber += 1
   
   }
  
*/

/*
     Data Table for main
     
Variable or Constant          Purpose
____________________         __________________
args                          parameter for main 
lineNumber                    stores the number of the current line for output clarity
characterValue                stores the int decimal 1 or 0 of the digit being converted to decimal
lineValue                     stores the accumulated value of the line
lineOutput                    stores the value of what will be printed out to the output file
invalidCharacters             stores wheter or not the current line has invalid characters
exponentMultiplier            stores the value of the exponent for converting binary to decimal

    
*/

   public static void main(String [] args) throws Exception
   {
      File inputFile = new File(args[0]);
      Scanner fileScan = new Scanner(inputFile);
      
      File outputFile = new File(args[1]);      
      PrintStream fileWriter = new PrintStream(outputFile);
      
      fileWriter.println("Binary to Decimal Conversion");
      fileWriter.println("Caspian Peavyhouse");
      fileWriter.println("CS101-02\n");
      
      int lineNumber = 1;
      int characterValue = 0;
      int lineValue = 0;
      String lineOutput = new String("");
      boolean invalidCharacters;
      
      while (fileScan.hasNextLine())
      {
         String currentLine = fileScan.nextLine();
         lineValue = 0;
         for (int index = 0; index < currentLine.length(); index += 1)
         {  
            //This portion checks  to see if there is leading or trailing whitespace in a line
            // and if there is, removes it
            if (index == 0 && currentLine.charAt(index) == ' ')
            {
               currentLine = currentLine.substring(1, currentLine.length());
            }
            if (index == (currentLine.length() - 1) && currentLine.charAt(index) == ' ')
            {
               currentLine = currentLine.substring(0, currentLine.length() - 1);
            }
            
            //This section checks to see if the line contains invalid characters
            if (currentLine.charAt(index) != '1' && currentLine.charAt(index) != '0')
            {
               lineOutput = ("" + currentLine + " \t: Line " + lineNumber + " is invalid");
			      invalidCharacters = true;
               break;
            }
            
            //If the line is only 1's or 0's this calculates the decimal value
            else
            {
               characterValue = Integer.parseInt("" + currentLine.charAt(index));
               int exponentMultiplier = 1;
               
			      //This  part  is the actual calculation of the binary conversion
			      //Using a for loop to account for the exponent of the digit
               for(int digit = currentLine.length() - 1;(digit - index) > 0  ; digit--)
               {
                  exponentMultiplier *= 2;
               }
               
               int characterBinary = characterValue * exponentMultiplier;
               lineValue += characterBinary;
			      invalidCharacters = false;
            }
		   
		      //if there were invalid characters in the line, the invalid message is printed
		      //else the line value is printed
            if (invalidCharacters == false)
            {
               lineOutput = ("" + currentLine + " \t: The value in decimal is " + Integer.toString(lineValue));
            }
         }
         fileWriter.println(lineOutput);
         lineNumber += 1;
      }
   }//main(args)
}//class Template