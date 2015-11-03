//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014

/* Data Table for Vehicle
Variable or Constant       Purpose
____________________       __________________
color                      String contains the color of the trike
wheelSize                  int contains the size of the wheels
maxAgeOfRider              int stores the max age of the rider
*/
public class Tricycle extends Pedal
{
   protected String color;
   protected int wheelSize;
   protected int maxAgeOfRider;
   
   
   /* Algorithm for Tricycle
      super
   */
   public Tricycle()
   {
      super();
   } 
   
   
   /* Algorithm for setColor
      this.color <-- newColor
   */
   public void setColor(String newColor)
   {
      this.color = newColor;
   }
   
   
   /* Algorithm for setWheelSize
      this.wheelSize <-- wheelSize
   */
   public void setWheelSize(int wheelSize)
   {
      this.wheelSize = wheelSize;
   }
   
   
   /* Algorithm for setMaxAgeOfRider
      this.maxAgeOfRider <-- maxAge
   */
   public void setMaxAgeOfRider(int maxAge)
   {
      this.maxAgeOfRider = maxAge;
   }
   
   
   /* Algorithm for getColor
      return this.color
   */
   public String getColor()
   {
      return this.color;
   }
   
   
   /* Algorithm for getWheelSize
      return this.wheelSize
   */
   public int getWheelSize()
   {
      return this.wheelSize;
   }
   
   
   /* Algorithm for getMaxAgeOfRider
      return this.maxAgeOfRider 
   */
   public int getMaxAgeOfRider()
   {
      return this.maxAgeOfRider;
   }
   
   
   /* Algorithm for toString
      
   String idString = new String("" + getIdNumber())	
   for(int i = 0 idString.length() < 7 i++)	
   	idString <-- "0" + idString 
      
   String output <-- new String("Tricycle\n")
   output += ("\tmake: " + getMake() + "\n")
   output += ("\tcolor: " + getColor() + "\n")
   output += ("\ttricycle ID number: " + getIdNumber() + "\n")
   output += ("\towner: " + getOwner() + "\n")
   output += ("\twheel size: " + getWheelSize() + "\n")
   output += ("\tmaximum age of rider: " + getMaxAgeOfRider())
      
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
      
      String output = new String("Tricycle\n");
      output += ("\tmake: " + getMake() + "\n");
      output += ("\tcolor: " + getColor() + "\n");
      output += ("\ttricycle ID number: " + idString + "\n");
      output += ("\towner: " + getOwner() + "\n");
      output += ("\twheel size: " + getWheelSize() + "\n");
      output += ("\tmaximum age of rider: " + getMaxAgeOfRider());
      
      return output;
   }
}
