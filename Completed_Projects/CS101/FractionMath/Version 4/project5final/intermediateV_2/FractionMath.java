
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
			
	writerOutput.write("Fraction Math Version 2")		
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
      
      writerOutput.write("FractionMath Version 2\n");
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

	writerOutput write(currentLine) + new line	
*/
/*
     Data Table for checkLine
     
Variable or Constant     Purpose
____________________     __________________
args                     parameter for readLine
     
*/   
   private static void readLine(String currentLine, FileWriter writerOutput) throws Exception
   {
      writerOutput.write(currentLine + "\n");

   }//checkLine
   
    
}//class Template