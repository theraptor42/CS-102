//This is a driver for the Fraction class to test its functionality
//Caspian Peavyhouse
//CS101-02
//11/19/2014

public class FractionDriver
{  
   public static void main(String [] args)
   {
      //This is to test the constructors
      System.out.println("The output of (5 / 6) should be 5 / 6:");
      Fraction alpha = new Fraction(5, 6);
      System.out.println(alpha.toString());
      //Testing the reducing code
      System.out.println("The output of (7 / 49) should be 1 / 7:");
      Fraction beta = new Fraction(7, 49);
      System.out.println(beta.toString());
      //Testing the undefined code
      System.out.println("The output of (6 / 0) should be Undefined:");
      Fraction gamma = new Fraction(6, 0);
      System.out.println(gamma.toString());
      //Testing the negative code
      Fraction delta = new Fraction(-5, 3);
      Fraction zeta = new Fraction(4, -2);
      Fraction eta = new Fraction (-6, -19);
      System.out.println("The output of (-5 / 3) should be -5 / 3:");
      System.out.println(delta.toString());
      System.out.println("The output of (4 / -2) should be -2 / 1:");
      System.out.println(zeta.toString());
      System.out.println("The output of (-6 / -19) should be 6 / 19:");
      System.out.println(eta.toString() + "\n");
      
      
      Fraction answer = new Fraction();
      Fraction base = new Fraction(1, 5);
      
      //Test the add method
      Fraction addThis = new Fraction(7, 8);
      answer = base.add(addThis);
      System.out.println("(1 / 5) + (7 / 8) = ");
      System.out.println(answer.toString());
      
      //Test the subtract method
      Fraction subtractThis = new Fraction(7, 3);
      answer = base.subtract(subtractThis);
      System.out.println("(1 / 5) - (7 / 3) = ");
      System.out.println(answer.toString());
      
      //Test the multiply method
      Fraction multiplyThis = new Fraction(3, 2);
      answer = base.multiply(multiplyThis);
      System.out.println("(1 / 5) * (3 / 2) = ");
      System.out.println(answer.toString());
      
      //Test the divide method
      Fraction divideThis = new Fraction(5, 3);
      answer = base.divide(divideThis);
      System.out.println("(1 / 5) / (5 / 3) = ");
      System.out.println(answer.toString());
      
      //Test the reciprocal method
      Fraction flipThisOne = new Fraction(24, 17);
      System.out.println("The reciprocal of (24 / 17) is:");
      Fraction reciprocal = flipThisOne.reciprocal();
      System.out.println(reciprocal.toString());
      
      //Test greatestCommonDivisor
      System.out.println("\nThe greatest common divisor between 12 and 496 is: ");
      
      int aDivisor = Fraction.greatestCommonDivisor(12, 496);
      System.out.println(aDivisor);
      
      //Test accessor methods
      System.out.println("\nThe numerator of 1 / 5 is: ");
      System.out.println(base.getNumerator());
      
      System.out.println("\nThe denominator of 1 / 5 is: ");
      System.out.println(base.getDenominator()); 
      
   }//main
}//FractionDriver