//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014

/* Data Table for Vehicle
Variable or Constant       Purpose
____________________       __________________
make                       String contains the make for all vehicle objects
idNumber                   int contains the vehicle id number
type                       String stores the type of vehicle
*/

abstract public class Vehicle
{
   protected String make;
   protected int idNumber;
   
   
   /* Algorithm for Vehicle
      
   */
   public Vehicle()
   {
   
   }
    
   
   /* Algorithm for setMake
      this.make <-- newMake
   */
   public void setMake(String newMake)
   {
      this.make = newMake;
   }
   
   
   /* Algorithm for setIdNumber
      this.idNumber <-- idNumber
   */
   public void setIdNumber(int idNumber)
   {
      this.idNumber = idNumber;
   }
   
   
   /* Algorithm for getMake
      return this.make
   */
   public String getMake()
   {
      return this.make;
   }
   
   
   /* Algorithm for getIdNumber
      return this.idNumber
   */
   public int getIdNumber()
   {
      return this.idNumber;
   }
   
}












