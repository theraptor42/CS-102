
//Purpose: take input from a file and output the fraction value of the operation
//Caspian Peavyhouse
//CS101-02
//11/23/14

import java.util.*;
import java.io.*;

public class FractionMath
{
/*
     Algorithm for main(args)
main(args)
	File inputFile <-- new File(args[0])		
	Scanner input <-- new Scanner(inputFile)		
			
	File outputFile <-- new File(args[1])		
	FileWriter writerOutput <-- new FileWriter(outputFile)		
	String currentLine <-- new String(input.nextLine())		
			
	writerOutput.write("Fraction Math Version 1")		
	writerOutput.write("Written by Caspian Peavyhouse")		
	writerOutput.write("CS101-02")		
			
	while (input.hasNextLine())		
		String output <-- new String(checkLine(currentLine))	
		if (output.equals(""))	
			break;
		writerOutput.write(output)	
		writerOutput.write("\n")	
			
		currentLine <-- input.nextLine()	
  
*/

/*
     Data Table for main
     
Variable or Constant     Purpose
____________________     __________________
args                     parameter for main
output                   contains the String value to be written to the file     
*/

   public static void main(String [] args)throws Exception
   {
      File inputFile = new File(args[0]);
      Scanner input = new Scanner(inputFile);
      
      File outputFile = new File(args[1]);
      FileWriter writerOutput = new FileWriter(outputFile);
      String currentLine = new String(input.nextLine());
      
      writerOutput.write("FractionMath Version 1\n");
      writerOutput.write("Written by Caspian Peavyhouse\n");
      writerOutput.write("CS101-02\n\n");
      
      while (input.hasNextLine())
      {  
         String output = new String(checkLine(currentLine));
         if (output.equals(""))
         {
            break;
         }
         writerOutput.write(output);
         writerOutput.write("\n");


         currentLine = input.nextLine();
         
      }
      
      writerOutput.close();
   
   }//main(args)
   
   
/*
checkLine(String currentLine)

	String endSequence <-- new String("quit")		
	String emptyString <-- new String("")		
	if (currentLine.toLowerCase().contains(endSequence))		
		return emptyString	
	else		
		return currentLine	
*/
/*
     Data Table for checkLine
     
Variable or Constant     Purpose
____________________     __________________
args                     parameter for checkLine
endSequence              contains the String value "quit"
emptyString              contains the empty string     
*/   
   private static String checkLine(String currentLine)
   {
      String endSequence = new String("quit");
      String emptyString = new String("");
      if (currentLine.toLowerCase().contains(endSequence))
      {
         return emptyString;
      }
      else
      {
         return currentLine;
      }
   }//checkLine
   
   private void readAdd()
   {
      //Stub
   }//readAdd
 
   private void readSubtract()
   {
      //Stub
   }//readSubtract
  
   private void readMultiply()
   {
      //Stub
   }//readMultiply
  
   private void readDivide()
   {
      //Stub
   }//readDivide
  
   private void readReciprocal()
   {
      //Stub
   }//readReciprocal
  
}//class Template