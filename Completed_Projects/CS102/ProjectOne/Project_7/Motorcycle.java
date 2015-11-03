//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014


/* Data Table for Vehicle
Variable or Constant       Purpose
____________________       __________________
color                      String contains the color of the motorcycle
engineSize                 int contains the size of the engine
*/
public class Motorcycle extends Motorized
{
   protected String color;
   protected int engineSize;
   
   /* Algorithm for Motorcycle
      super
   */
   public Motorcycle()
   {
      super();
   }//Motorcycle
   
  
  /* Algorithm for setColor
      this.color <-- newColor
   */
  public void setColor(String newColor)
   {
      this.color = newColor;
   }//setColor
   
   
   /* Algorithm for setColor
      this.engineSize <-- newSize
   */
   public void setEngineSize(int newSize)
   {
      this.engineSize = newSize;
   }//setEngineSize
   
   
   /* Algorithm for getColor
      return this.color
   */
   public String getColor()
   {
      return this.color;
   }//getColor
   
   
   /* Algorithm for getEngineSize
      return this.engineSize
   */
   public int getEngineSize()
   {
      return this.engineSize;
   }//getEngineSize
   
   
   /* Algorithm for toString
      String idString = new String("" + getIdNumber())	
      for(int i = 0 idString.length() < 7 i++)	
      	idString <-- "0" + idString 
      
      String output <-- new String("Motorcycle\n")
      output += ("\tmake: " + getMake() + "\n")
      output += ("\tcolor: " + getColor() + "\n")
      output += ("\tvehicle ID number: " + getIdNumber() + "\n")
      output += ("\tlicense plate number: " + getLicensePlate() + "\n")
      output += ("\tengine size: " + getEngineSize() + "\n")
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
      
      String output = new String("Motorcycle\n");
      output += ("\tmake: " + getMake() + "\n");
      output += ("\tcolor: " + getColor() + "\n");
      output += ("\tvehicle ID number: " + idString + "\n");
      output += ("\tlicense plate number: " + getLicensePlate() + "\n");
      output += ("\tengine size: " + getEngineSize() + "\n");
      output += ("\tyear manufactured: " + getYear());
      
      return output;
   }
}
