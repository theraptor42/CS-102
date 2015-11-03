//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014


/* Data Table for Vehicle
Variable or Constant       Purpose
____________________       __________________
numOfDoors                 int contains the number of doors
numOfPassengers            int contains the number of passengers
*/
public class Car extends Motorized
{
   protected int numOfDoors;
   protected int numOfPassengers;
   
    /* Algorithm for Car
      super
   */
   public Car()
   {
      super();
   }
   
   
   /* Algorithm for setNumOfDoors
      this.numOfDoors <-- newNumber
   */
   public void setNumOfDoors(int newNumber)
   {
      this.numOfDoors = newNumber;
   }
   
   
   /* Algorithm for setNumOfPassengers
      this.numOfPassengers <-- newNumber
   */
   public void setNumOfPassengers(int newNumber)
   {
      this.numOfPassengers = newNumber;
   }
   
   
   /* Algorithm for getNumOfDoors
      return numOfDoors
   */
   public int getNumOfDoors()
   {
      return numOfDoors;
   }
   
   
   /* Algorithm for getNumOfPassengers
      return numOfPassengers
   */
   public int getNumOfPassengers()
   {
      return numOfPassengers;
   }
   
   
   /* Algorithm for toString
      String idString = new String("" + getIdNumber())	
      for(int i = 0 idString.length() < 7 i++)	
      	idString <-- "0" + idString 
      
      String output <-- new String("Car\n")
      output += ("\tmake: " + getMake() + "\n")
      output += ("\tnumber of doors: " + getNumOfDoors() + "\n")
      output += ("\tnumber of passengers: " + getNumOfPassengers() + "\n")
      output += ("\tvehicle ID number: " + getIdNumber() + "\n")
      output += ("\tlicense plate number: " + getLicensePlate() + "\n")
      output += ("\tyear manufactured: " + getYear())
      return output
   */
   
   /* Data Table for toString
   Variable or Constant       Purpose
   ____________________       __________________
   output                     String contains value to be returned
   idString                   String value of the idNumber
   */
   public String toString()
   {
      String idString = new String("" + getIdNumber());
      for(int i = 0; idString.length() < 7; i++)
      {
         idString = "0" + idString;  
      }
      
      String output = new String("Car\n");
      output += ("\tmake: " + getMake() + "\n");
      output += ("\tnumber of doors: " + getNumOfDoors() + "\n");
      output += ("\tnumber of passengers: " + getNumOfPassengers() + "\n");
      output += ("\tvehicle ID number: " + idString + "\n");
      output += ("\tlicense plate number: " + getLicensePlate() + "\n");
      output += ("\tyear manufactured: " + getYear());
      return output;
   }
   
   
}