
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
			
	writerOutput.write("Fraction Math Version 3")		
	writerOutput.write("Written by Caspian Peavyhouse")		
	writerOutput.write("CS101-02")		
			
	do		
		 currentLine <-- currentLine.toLowerCase()
       if currentLine contains("quit")
          break
       else
          readLine(currentLine, writerOutput)
       currentLine <-- input.nextLine()	
			
   while (input.hasNextLine())
   
   
  
*/

/*
     Data Table for main
     
Variable or Constant     Purpose
____________________     __________________
args                     parameter for main
*/

   public static void main(String [] args)throws Exception
   {
      File inputFile = new File(args[0]);
      Scanner input = new Scanner(inputFile);
      
      File outputFile = new File(args[1]);
      FileWriter writerOutput = new FileWriter(outputFile);
      String currentLine = new String(input.nextLine());
      
      writerOutput.write("FractionMath Version 3\n");
      writerOutput.write("Written by Caspian Peavyhouse\n");
      writerOutput.write("CS101-02\n\n");
      
      do
      {  
         currentLine = currentLine.toLowerCase();
         if (currentLine.contains("quit"))
         {
            break;
         }
         
         else
         {
            readLine(currentLine, writerOutput);
         }
         currentLine = input.nextLine();
         
      } while (input.hasNextLine());
      
      writerOutput.close();
   
   }//main(args)
   
   
/*
readLine(String currentLine)

	writerOutput write(currentLine + \n)
      
   currentLine = currentLine.replace('/', ' ')
      Scanner stringScan <-- new Scanner(currentLine)
      Scanner numberScan <-- new Scanner(currentLine)
      int firstNum <-- numberScan.nextInt()
      int secondNum <-- numberScan.nextInt()
      
      String currentString <-- new String(stringScan.next())
      
      Fraction currentFraction <-- new Fraction(firstNum, secondNum)
      Fraction nextFraction <-- new Fraction()
      
      while (stringScan.hasNext())
      
         if (currentString.equals("add"))
         
         else if (currentString.equals("sub"))

         else if (currentString.equals("mul"))

         else if (currentString.equals("div"))

         else if (currentString.equals("rec"))
         
         currentString <-- stringScan.next()

	
*/
/*
     Data Table for checkLine
     
Variable or Constant     Purpose
____________________     __________________
args                     parameter for readLine
firstNum                 storest the value for the firs numerator
secondNum                stores the value for the first denominator    
*/   
   private static void readLine(String currentLine, FileWriter writerOutput)
      throws Exception
   {
      writerOutput.write(currentLine + "\n");
      
      currentLine = currentLine.replace('/', ' ');
      Scanner stringScan = new Scanner(currentLine);
      Scanner numberScan = new Scanner(currentLine);
      int firstNum = numberScan.nextInt();
      int secondNum = numberScan.nextInt();
      
      String currentString = new String(stringScan.next());
      
      Fraction currentFraction = new Fraction(firstNum, secondNum);
      Fraction nextFraction = new Fraction();
      
      while (stringScan.hasNext())
      {
         if (currentString.equals("add"))
         {
            
         }
         else if (currentString.equals("sub"))
         {
         
         }
         else if (currentString.equals("mul"))
         {
         
         }
         else if (currentString.equals("div"))
         {
         
         }
         else if (currentString.equals("rec"))
         {
         
         }
         currentString = stringScan.next();
      }     

   }//readLine
   
    
}//class FractionMath