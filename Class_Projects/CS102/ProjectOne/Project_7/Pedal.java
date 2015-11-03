//Purpose: use a class hierarchy to practice inheritance and polymorphism
//Caspian Peavyhouse
//CS101-02
//12/13/2014


/* Data Table for Pedal
Variable or Constant       Purpose
____________________       __________________
owner                      String contains the name of the owner
*/
abstract public class Pedal extends Vehicle
{
   protected String owner;
   
   
   /* Algorithm for Pedal
      super
   */
   public Pedal()
   {
      super();
   }
   
   
   /* Algorithm for setOwner
      this.owner <-- newOwner
   */
   public void setOwner(String newOwner)
   {
      this.owner = newOwner;
   }
   
   
   /* Algorithm for getOwner
      return this.owner
   */
   public String getOwner()
   {
      return this.owner;
   }
}