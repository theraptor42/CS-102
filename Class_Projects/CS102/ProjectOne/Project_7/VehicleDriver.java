//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014

import java.util.*;
import java.io.*;

public class VehicleDriver
{
   
   /*Algoritm for main
   Vehicle [] mainArray <-- new Vehicle [0] 				
				
   File inputFile <-- new File(args[0])				
   Scanner input <-- new Scanner(inputFile)				
   				
   File outputFile <-- new File(args[1])				
   FileWriter writerOutput <-- new FileWriter(outputFile)				
   String currentLine <-- new String(input.nextLine())				
   				
   writerOutput.write("VehicleDriver Version 3\n")				
   writerOutput.write("Written by Caspian Peavyhouse\n")				
   writerOutput.write("CS101-02\n\n")				
   				
   Scanner echoScanner <-- new Scanner(inputFile)				
   writeEcho(writerOutput, echoScanner)				
   				
   writerOutput.write("\n")				
   while (true)				
   	   Vehicle newVehicle <-- null			
   	   char firstLetter <-- currentLine.toLowerCase().charAt(0)			
   	   switch (firstLetter)			
   	   {			
   		case 'b':		
   		      {		
   			newVehicle <-- caseB(currentLine)	
   		      } break		
   	      			
   	      	      case 't':		
   		      {		
   			newVehicle <-- caseT(currentLine)	
   		      } break		
   				
   	      	      case 'm':		
   	      	      {		
   			newVehicle <-- caseM(currentLine)	
   		      } break		
   				
   		      case 'c':		
   	      	      {		
   	      		newVehicle <-- caseC(currentLine)	
   		      } break		
   				
   		      default:		
   		      {		
   	      	         		
   		      }break		
   				
   	   }//switch			
   				
   	   if (newVehicle != null)			
   		      mainArray <-- addToArray(mainArray, newVehicle)		
   				
   	   if (input.hasNextLine())			
              		      currentLine <-- input.nextLine()		
   				
   	   else			
   		      break		
   				
   writeToOutput(writerOutput, mainArray)				
   writerOutput.close()				
   */
   /* Data Table for main
   Variable or Constant       Purpose
   ____________________       __________________
   inputFile                  argument for input file
   outputFile                 argument for output file
   currentLine                String value of line being evaluated
   newVehicle                 Vehicle being created in switch
   mainArray                  Vehicle [] for the driver
   */
   public static void main(String [] args) throws Exception
   {
      Vehicle [] mainArray = new Vehicle [0]; 
      
      
      File inputFile = new File(args[0]);
      Scanner input = new Scanner(inputFile);
      
      File outputFile = new File(args[1]);
      FileWriter writerOutput = new FileWriter(outputFile);
      String currentLine = new String(input.nextLine());
      
      writerOutput.write("VehicleDriver Version 3\n");
      writerOutput.write("Written by Caspian Peavyhouse\n");
      writerOutput.write("CS101-02\n\n");
      
      Scanner echoScanner = new Scanner(inputFile);
      writeEcho(writerOutput, echoScanner);
      
      writerOutput.write("\n");
      while (true)
      {
         Vehicle newVehicle = null;
         char firstLetter = currentLine.toLowerCase().charAt(0);
         switch (firstLetter)
         {
            case 'b':
            {
               newVehicle = caseB(currentLine);
            } break;
            
            
            case 't':
            {
               newVehicle = caseT(currentLine);
            } break;
            
            
            case 'm':
            {
               newVehicle = caseM(currentLine);
            } break;
            
            
            case 'c':
            {
               newVehicle = caseC(currentLine);
            } break;
            
            default:
            {
               
            }break;
         }//switch
         
         if (newVehicle != null)
         {
            mainArray = addToArray(mainArray, newVehicle);
         }
                 
         if (input.hasNextLine())
            currentLine = input.nextLine();
         else
            break;
      }
      
      writeToOutput(writerOutput, mainArray);
      
      
      
      writerOutput.close();
   }//main
   
   
   
   /* Algoritm for writeEcho
   String currentLine <-- new String(echoScanner.nextLine())		
   writerOutput.write("Input:\n")		
   		
   while (true)		
   	   writerOutput.write("\t" + currentLine + "\n")	
      		
      	   if (echoScanner.hasNextLine())	
   		currentLine <-- echoScanner.nextLine()
   	   else	
   		return
   */
   /* Data Table for writeEcho
   Variable or Constant       Purpose
   ____________________       __________________
   currentLine                String value of line being evaluated
   */
   public static void writeEcho(FileWriter writerOutput, Scanner echoScanner)
                                                            throws Exception
   {
      String currentLine = new String(echoScanner.nextLine());
      writerOutput.write("Input:\n");
      
      while (true)
      {
         writerOutput.write("\t" + currentLine + "\n");
         
         
         if (echoScanner.hasNextLine())
            currentLine = echoScanner.nextLine();
         else
            return;
      }
   }//writeEcho
   
   
   
   
   /* Algoritm for caseB
   Bicycle newVehicle <-- new Bicycle()		
   Scanner lineScan <-- new Scanner(currentLine)		
   lineScan.useDelimiter("\\*")		
   		
   lineScan.next()//to skip over the initial b		
   		
   String make <-- lineScan.next()		
   int size <-- lineScan.nextInt()		
   int idNumber <-- lineScan.nextInt()		
   int numOfGears <-- lineScan.nextInt()		
   String owner <-- lineScan.next()		
   int numOfRiders <-- lineScan.nextInt()		
   		
   newVehicle.setMake(make)		
   newVehicle.setSize(size)		
   newVehicle.setIdNumber(idNumber)		
   newVehicle.setNumberOfGears(numOfGears)		
   newVehicle.setOwner(owner)		
   newVehicle.setNumberOfRiders(numOfRiders)		
   		
   return newVehicle		
   */
   /* Data Table for caseB
   Variable or Constant       Purpose
   ____________________       __________________
   currentLine                String value of line being evaluated
   newVehicle                 Bicycle being created
   make                       String vale, stores the make
   size                       int value, stores the size
   idNumber                   int value, stores the id number
   numOfGears                 int vaue, stores the number of gears
   owner                      String value stores the owner
   numOfRiders                int value, stores the number of riders
   */
   public static Vehicle caseB(String currentLine)
   {
      Bicycle newVehicle = new Bicycle();
      Scanner lineScan = new Scanner(currentLine);
      lineScan.useDelimiter("\\*");
      
      lineScan.next();//to skip over the initial b
      
      String make = lineScan.next();
      int size = lineScan.nextInt();
      int idNumber = lineScan.nextInt();
      int numOfGears = lineScan.nextInt();
      String owner = lineScan.next();
      int numOfRiders = lineScan.nextInt();
      
      newVehicle.setMake(make);
      newVehicle.setSize(size);
      newVehicle.setIdNumber(idNumber);
      newVehicle.setNumberOfGears(numOfGears);
      newVehicle.setOwner(owner);
      newVehicle.setNumberOfRiders(numOfRiders);
      
      return newVehicle;
      
   }//caseB
   
   
   
   /* Algoritm for caseT
   Tricycle newVehicle <-- new Tricycle()
   Scanner lineScan <-- new Scanner(currentLine)
   lineScan.useDelimiter("\\*")
   
   lineScan.next()//to skip over the initial t
   
   String make <-- lineScan.next()
   String color <-- lineScan.next()
   int idNumber <-- lineScan.nextInt()
   String owner <-- lineScan.next()
   int wheelSize <-- lineScan.nextInt()
   int maxAge <-- lineScan.nextInt()
   
   newVehicle.setMake(make)
   newVehicle.setColor(color)
   newVehicle.setIdNumber(idNumber)
   newVehicle.setOwner(owner)
   newVehicle.setWheelSize(wheelSize)
   newVehicle.setMaxAgeOfRider(maxAge)
   
   return newVehicle
   */
   /* Data Table for caseT
   Variable or Constant       Purpose
   ____________________       __________________
   currentLine                String value of line being evaluated
   newVehicle                 Tricycle being created
   make                       String vale, stores the make
   color                      String value, stores the color
   idNumber                   int value, stores the id number
   owner                      String value stores the owner
   wheelSize                  int vaue, stores the size of the wheels   
   maxAge                     int value, stores the max age of riders
   */
   public static Vehicle caseT(String currentLine)
   {
      Tricycle newVehicle = new Tricycle();
      Scanner lineScan = new Scanner(currentLine);
      lineScan.useDelimiter("\\*");
      
      lineScan.next();//to skip over the initial t
      
      String make = lineScan.next();
      String color = lineScan.next();
      int idNumber = lineScan.nextInt();
      String owner = lineScan.next();
      int wheelSize = lineScan.nextInt();
      int maxAge = lineScan.nextInt();
      
      newVehicle.setMake(make);
      newVehicle.setColor(color);
      newVehicle.setIdNumber(idNumber);
      newVehicle.setOwner(owner);
      newVehicle.setWheelSize(wheelSize);
      newVehicle.setMaxAgeOfRider(maxAge);
      
      return newVehicle;
      
   }//caseT  
   
   
   /* Algoritm for caseM
   Motorcycle newVehicle <-- new Motorcycle()
   Scanner lineScan <-- new Scanner(currentLine)
   lineScan.useDelimiter("\\*")
   
   lineScan.next()//to skip over the initial m
   
   String make <-- lineScan.next()
   String color <-- lineScan.next()
   int idNumber <-- lineScan.nextInt()
   String licensePlate <-- lineScan.next()
   int engineSize <-- lineScan.nextInt()
   int year <-- lineScan.nextInt()
   
   newVehicle.setMake(make)
   newVehicle.setColor(color)
   newVehicle.setIdNumber(idNumber)
   newVehicle.setLicensePlate(licensePlate)
   newVehicle.setEngineSize(engineSize)
   newVehicle.setYear(year)
   
   return newVehicle
   */
   /* Data Table for caseM
   Variable or Constant       Purpose
   ____________________       __________________
   currentLine                String value of line being evaluated
   newVehicle                 Motorcycle being created
   make                       String vale, stores the make
   color                      String value, stores the color
   idNumber                   int value, stores the id number
   licensePlate               int value stores the license plate
   engineSize                 int vaue, stores the size of the engine   
   year                       int value, stores the year it was made
   */
   public static Vehicle caseM(String currentLine)
   {
      Motorcycle newVehicle = new Motorcycle();
      Scanner lineScan = new Scanner(currentLine);
      lineScan.useDelimiter("\\*");
      
      lineScan.next();//to skip over the initial m
      
      String make = lineScan.next();
      String color = lineScan.next();
      int idNumber = lineScan.nextInt();
      String licensePlate = lineScan.next();
      int engineSize = lineScan.nextInt();
      int year = lineScan.nextInt();
      
      newVehicle.setMake(make);
      newVehicle.setColor(color);
      newVehicle.setIdNumber(idNumber);
      newVehicle.setLicensePlate(licensePlate);
      newVehicle.setEngineSize(engineSize);
      newVehicle.setYear(year);
      
      return newVehicle;
      
   }//caseM
   
   
   /* Algoritm for caseC
   Car newVehicle <-- new Car()
   Scanner lineScan <-- new Scanner(currentLine)
   lineScan.useDelimiter("\\*")
   
   lineScan.next()//to skip over the initial c
   
   String make <-- lineScan.next()
   int numOfDoors <-- lineScan.nextInt()
   int numOfPassengers <-- lineScan.nextInt()
   int idNumber <-- lineScan.nextInt()
   String licensePlate <-- lineScan.next()
   int year <-- lineScan.nextInt()
   
   newVehicle.setMake(make)
   newVehicle.setNumOfDoors(numOfDoors)
   newVehicle.setNumOfPassengers(numOfPassengers)
   newVehicle.setIdNumber(idNumber)
   newVehicle.setLicensePlate(licensePlate)
   newVehicle.setYear(year)
   
   return newVehicle
   */
   /* Data Table for caseC
   Variable or Constant       Purpose
   ____________________       __________________
   currentLine                String value of line being evaluated
   newVehicle                 Car being created
   make                       String vale, stores the make
   numOfDoors                 int value, stores the number of doors
   numOfPassengers            int vaue, stores the number of passengers   
   idNumber                   int value, stores the id number
   licensePlate               int value stores the license plate
   year                       int value, stores the year it was made
   */
   public static Vehicle caseC(String currentLine)
   {
      Car newVehicle = new Car();
      Scanner lineScan = new Scanner(currentLine);
      lineScan.useDelimiter("\\*");
      
      lineScan.next();//to skip over the initial c
      
      String make = lineScan.next();
      int numOfDoors = lineScan.nextInt();
      int numOfPassengers = lineScan.nextInt();
      int idNumber = lineScan.nextInt();
      String licensePlate = lineScan.next();
      int year = lineScan.nextInt();
      
      newVehicle.setMake(make);
      newVehicle.setNumOfDoors(numOfDoors);
      newVehicle.setNumOfPassengers(numOfPassengers);
      newVehicle.setIdNumber(idNumber);
      newVehicle.setLicensePlate(licensePlate);
      newVehicle.setYear(year);
      
      return newVehicle;
      
   }//caseC
   
   
   /* Algoritm for addToArray
   Vehicle [] tempArray <-- new Vehicle [mainArray.length + 1]				
   				
   for (int i <-- 0 i < mainArray.length i++)				
   	   tempArray[i] <-- mainArray[i]  			
   				
   mainArray <-- tempArray				
   mainArray[mainArray.length - 1] <-- newVehicle				
          				
   for (int run <-- 0 run < mainArray.length - 1 run++)				
   	   for (int j <-- 0; j < mainArray.length - 1; j++)			
   		      if (mainArray[j].getIdNumber() > 		
   			             mainArray[j + 1].getIdNumber())	
   			Vehicle temp <-- mainArray[j]	
   			mainArray[j] <-- mainArray[j + 1]	
   			mainArray[j + 1] <-- temp	
   return mainArray				
   */
   /* Data Table for addToArray
   Variable or Constant       Purpose
   ____________________       __________________
   mainArray                  vehicle [] from main()
   newVehicle                 vehicle being added
   tempArray                  temporary array for size change
   temp                       temporary vehicle for position change
   */
   public static Vehicle [] addToArray(Vehicle [] mainArray, Vehicle newVehicle)
   {
      Vehicle [] tempArray = new Vehicle [mainArray.length + 1];
         
      for (int i = 0; i < mainArray.length; i++)
      {
         tempArray[i] = mainArray[i];  
      }  
      
      mainArray = tempArray;
      mainArray[mainArray.length - 1] = newVehicle;
             
      for (int run = 0; run < mainArray.length - 1; run++)
      {
         for (int j = 0; j < mainArray.length - 1; j++)
         {
            if (mainArray[j].getIdNumber() > mainArray[j + 1].getIdNumber())
            {
               Vehicle temp = mainArray[j];
               mainArray[j] = mainArray[j + 1];
               mainArray[j + 1] = temp;
            }
         }
      }
      
      return mainArray;   
   }//addToArray
   
   
   
   /* Algoritm for writeToOutput
   Vehicle temp						
   writer.write("Databse by identification number:\n\n")						
   for (int i <-- 0; i < mainArray.length; i++)						
   	   writer.write(mainArray[i].toString() + "\n\n")					
   						
   for (int run <-- 0; run < mainArray.length; run++)						
   	   for (int i <-- 1; i < mainArray.length; i++)					
   		if (mainArray[i] instanceof Motorized)				
   			if (!(mainArray[i - 1] instanceof Motorized))			
   				temp <-- mainArray[i-1]		
   				mainArray[i-1] <-- mainArray[i]		
   				mainArray[i] <-- temp               		
   						
   		else if (mainArray[i].getMake().compareTo				
   				(mainArray[i -1].getMake()) < 0)		
   						
            			temp <-- mainArray[i-1]			
   			mainArray[i-1] <-- mainArray[i]			
   			mainArray[i] <-- temp			
   						
   writer.write("Motorized vehicles sorted by make:\n\n")						
   for (int i <-- 0; i < mainArray.length; i++)						
   	   if (mainArray[i] instanceof Motorized)					
   		writer.write(mainArray[i].toString() + "\n\n")				
   						
   for (int run <-- 0; run < mainArray.length; run++)						
   	   for (int i <-- 1; i < mainArray.length; i++)					
   	      if (mainArray[i] instanceof Motorcycle)					
   		         if (!(mainArray[i - 1] instanceof Motorcycle))				
   						
   			          temp <-- mainArray[i-1]			
   			          mainArray[i-1] <-- mainArray[i]			
   			          mainArray[i] <-- temp               			
   		         else 				
   						
   			          Vehicle motoSecond <-- mainArray[i]			
   			          Vehicle motoFirst <-- mainArray[i - 1]			
   			          if (((Motorcycle)motoSecond).getEngineSize() 			
   					< ((Motorcycle)motoFirst).getEngineSize())	
   						
   				            temp <-- mainArray[i-1]		
   				            mainArray[i-1] <-- mainArray[i]		
   				            mainArray[i] <-- temp		
   						
   writer.write("Motorcycles sorted by engine size:\n\n")						
   for (int j <-- 0; j < mainArray.length; j++)						
   	   if (mainArray[j] instanceof Motorcycle)					
   		 writer.write(mainArray[j] + "\n\n")				
   						
   						
   for (int run <-- 0; run < mainArray.length; run++)						
   	for (int i <-- 1; i < mainArray.length; i++)					
   		if (mainArray[i] instanceof Pedal)				
   			 if (!(mainArray[i - 1] instanceof Pedal))			
   				 temp <-- mainArray[i-1]		
   				mainArray[i-1] <-- mainArray[i]		
   				mainArray[i] <-- temp               		
   			 else if (((Pedal)mainArray[i]).getOwner().compareTo			
   					(((Pedal)mainArray[i -1]).getOwner()) < 0)	
   				temp <-- mainArray[i-1]		
   				mainArray[i-1] <-- mainArray[i]		
   				mainArray[i] <-- temp		
   						
   writer.write("Pedal vehicles sorted by owner:\n\n")						
   for (int j <-- 0; j < mainArray.length; j++)						
   	   if (mainArray[j] instanceof Pedal)					
   		writer.write(mainArray[j] + "\n\n")				
   						
   						
   for (int run <-- 0; run < mainArray.length; run++)						
   {						
   	for (int i <-- 1; i < mainArray.length; i++)					
   		if (mainArray[i] instanceof Car)				
   			if (!(mainArray[i - 1] instanceof Car))			
   				temp <-- mainArray[i-1]		
   				mainArray[i-1] <-- mainArray[i]		
   				mainArray[i] <-- temp               		
   			else 			
   				Vehicle carSecond <-- mainArray[i]		
   				Vehicle carFirst <-- mainArray[i - 1]		
   				if (((Car)carSecond).getNumOfDoors() <		
   						 ((Car)carFirst).getNumOfDoors())
   					temp <-- mainArray[i-1]	
   					mainArray[i-1] <-- mainArray[i]	
   					mainArray[i] <-- temp	
   						
   writer.write("Cars sorted by number of doors:\n\n")						
   for (int j <-- 0; j < mainArray.length; j++)						
   	if (mainArray[j] instanceof Car)					
   		writer.write(mainArray[j] + "\n\n")				
   */
   /* Data Table for writeToOutput
   Variable or Constant       Purpose
   ____________________       __________________
   mainArray                  vehicle [] from main()
   temp                       temporary vehicle for position change
   motoFirst                  temporary motorcycle slot
   motoSecond                 temporary motorcycle slot
   */
   public static void writeToOutput(FileWriter writer, Vehicle [] mainArray)
                                                         throws Exception
   {
      
      Vehicle temp;
      writer.write("Databse by identification number:\n\n");
      for (int i = 0; i < mainArray.length; i++)
      {
         writer.write(mainArray[i].toString() + "\n\n");
      }
      
      for (int run = 0; run < mainArray.length; run++)
      {
         for (int i = 1; i < mainArray.length; i++)
         {
            if (mainArray[i] instanceof Motorized)
            {
               if (!(mainArray[i - 1] instanceof Motorized))
               {
                  temp = mainArray[i-1];
                  mainArray[i-1] = mainArray[i];
                  mainArray[i] = temp;               
               }
               
               else if (mainArray[i].getMake().compareTo
                           (mainArray[i -1].getMake()) < 0)
               {
                  temp = mainArray[i-1];
                  mainArray[i-1] = mainArray[i];
                  mainArray[i] = temp;
               }
            }
         }
      }
      writer.write("Motorized vehicles sorted by make:\n\n");
      for (int i = 0; i < mainArray.length; i++)
      {
         if (mainArray[i] instanceof Motorized)
            writer.write(mainArray[i].toString() + "\n\n");
      }
         
      
      for (int run = 0; run < mainArray.length; run++)
      {
         for (int i = 1; i < mainArray.length; i++)
         {
            if (mainArray[i] instanceof Motorcycle)
            {
               if (!(mainArray[i - 1] instanceof Motorcycle))
               {
                  temp = mainArray[i-1];
                  mainArray[i-1] = mainArray[i];
                  mainArray[i] = temp;               
               }
               
               else 
               {
                  Vehicle motoSecond = mainArray[i];
                  Vehicle motoFirst = mainArray[i - 1];
                  if (((Motorcycle)motoSecond).getEngineSize() < 
                                 ((Motorcycle)motoFirst).getEngineSize())
                  {
                     temp = mainArray[i-1];
                     mainArray[i-1] = mainArray[i];
                     mainArray[i] = temp;
                  }
               }   
            }
         }
      }
         
      writer.write("Motorcycles sorted by engine size:\n\n");
      for (int j = 0; j < mainArray.length; j++)
      {
         if (mainArray[j] instanceof Motorcycle)
         {
            writer.write(mainArray[j] + "\n\n");
         }
      }
      
      for (int run = 0; run < mainArray.length; run++)
      {
         for (int i = 1; i < mainArray.length; i++)
         {
            if (mainArray[i] instanceof Pedal)
            {
               if (!(mainArray[i - 1] instanceof Pedal))
               {
                  temp = mainArray[i-1];
                  mainArray[i-1] = mainArray[i];
                  mainArray[i] = temp;               
               }
               
               else if (((Pedal)mainArray[i]).getOwner().compareTo
                              (((Pedal)mainArray[i -1]).getOwner()) < 0)
               {
                  temp = mainArray[i-1];
                  mainArray[i-1] = mainArray[i];
                  mainArray[i] = temp;
               }
            }
         }
      }
      
      writer.write("Pedal vehicles sorted by owner:\n\n");
      for (int j = 0; j < mainArray.length; j++)
      {
         if (mainArray[j] instanceof Pedal)
         {
            writer.write(mainArray[j] + "\n\n");
         }
      }
      
      for (int run = 0; run < mainArray.length; run++)
      {
         for (int i = 1; i < mainArray.length; i++)
         {
            if (mainArray[i] instanceof Car)
            {
               if (!(mainArray[i - 1] instanceof Car))
               {
                  temp = mainArray[i-1];
                  mainArray[i-1] = mainArray[i];
                  mainArray[i] = temp;               
               }
               
               else 
               {
                  Vehicle carSecond = mainArray[i];
                  Vehicle carFirst = mainArray[i - 1];
                  if (((Car)carSecond).getNumOfDoors() < 
                              ((Car)carFirst).getNumOfDoors())
                  {
                     temp = mainArray[i-1];
                     mainArray[i-1] = mainArray[i];
                     mainArray[i] = temp;
                  }
               }   
            }
         }
      }
      
      writer.write("Cars sorted by number of doors:\n\n");
      for (int j = 0; j < mainArray.length; j++)
      {
         if (mainArray[j] instanceof Car)
         {
            writer.write(mainArray[j] + "\n\n");
         }
      }
              
   }//writeToOutput
                 
   
}//VehicleDriver

