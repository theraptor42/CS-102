//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014


/* Data Table for Vehicle
Variable or Constant       Purpose
____________________       __________________
licensePlate               String stores the license plate number
year                       int stores the year the vehicle was made
*/
abstract public class Motorized extends Vehicle
{
   protected String licensePlate;
   protected int year;//year manufactured
   
   
   /* Algorithm for Motorized
      super
   */
   public Motorized()
   {
      super(); 
   }
   
   
   /* Algorithm for setLicensePlate
      this.licensePlate <-- newPlate
   */
   public void setLicensePlate(String newPlate)
   {
      this.licensePlate = newPlate;
   }
   
   
   /* Algorithm for setYear
      this.year <-- newYear
   */
   public void setYear(int newYear)
   {
      this.year = newYear;
   }
   
   
   /* Algorithm for getLicensePlate
      return this.licensePlate
   */
   public String getLicensePlate()
   {
      return this.licensePlate;
   }
   
   
   /* Algorithm for getYear
      return this.year
   */
   public int getYear()
   {
      return this.year;
   }
   
}