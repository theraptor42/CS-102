public class Stuff
{
   public static void main(String [] args)
   {
      Set [] mainArray = new Set [100];
      if (mainArray[1] == null)
         System.out.println("null"); 
      else if(mainArray[1].isEmpty())
         System.out.println("true");
      else 
         System.out.println("false");
   }
}