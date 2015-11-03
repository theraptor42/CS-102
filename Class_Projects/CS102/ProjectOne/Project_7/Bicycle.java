//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014

/* Data Table for Vehicle
Variable or Constant       Purpose
____________________       __________________
size                       int stores the size of the bicycle
numberOfGears              int stores the number of gears
numberOfRiders             int stores the number of riders
*/
public class Bicycle extends Pedal
{
   protected int size;
   protected int numberOfGears;
   protected int numberOfRiders;
   
   
   /* Algorithm for Bicycle
      super
   */
   public Bicycle()
   {
      super();
   }
   
   
   /* Algorithm for setSize
      this.size <-- newSize
   */
   public void setSize(int newSize)
   {
      this.size = newSize;
   }
   
   
   /* Algorithm for setNumberOfGears
      this.NnmberOfGears <-- newNumber
   */
   public void setNumberOfGears(int newNumber)
   {
      this.numberOfGears = newNumber;
   }
   
  
  /* Algorithm for setNumberOfRiders
      this.NnmberOfRiders <-- newNumber
   */
  public void setNumberOfRiders(int newNumber)
   {
      this.numberOfRiders = newNumber;
   }
   
   
   /* Algorithm for getSize
      return this.size
   */
   public int getSize()
   {
      return this.size;
   }
   
   
   /* Algorithm for getNumberOfGears
      return this.numberOfGears
   */
   public int getNumberOfGears()
   {
      return this.numberOfGears;
   }
   
   
   /* Algorithm for getNumberOfRiders
      return this.numberOfRiders
   */
   public int getNumberOfRiders()
   {
      return this.numberOfRiders;
   }
   
   
   /* Algorithm for toString
      String idString = new String("" + getIdNumber())	
      for(int i = 0 idString.length() < 7 i++)	
      	idString <-- "0" + idString  
            	
      String output = new String("Bicycle\n")	
      output += ("\tmake: " + getMake() + "\n")	
      output += ("\tsize: " + getSize() + "\n")	
      output += ("\tbicycle ID number: " + idString + "\n")	
      output += ("\tnumber of gears: " + getNumberOfGears() + "\n")	
      output += ("\towner: " + getOwner() + "\n")	
      output += ("\tnumber of riders: " + getNumberOfRiders())	
            	
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
      }//because the int was dropping leading zeroes
      
      
      
      String output = new String("Bicycle\n");
      output += ("\tmake: " + getMake() + "\n");
      output += ("\tsize: " + getSize() + "\n");
      output += ("\tbicycle ID number: " + idString + "\n");
      output += ("\tnumber of gears: " + getNumberOfGears() + "\n");
      output += ("\towner: " + getOwner() + "\n");
      output += ("\tnumber of riders: " + getNumberOfRiders());
      
      return output;
   }
   
}