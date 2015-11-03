//Purpose: to take an input amount for the bill and payment, and output the change in the smallest possible currency
//Caspian Peavyhouse
//CS101-02
//10/27/2014

import java.util.*;

public class MakeChange
{
/*
     Algorithm for main(args)
main(args)
  final int PENNIES_IN_QUARTER = 25
  final int PENNIES_IN_DIME = 10
  final int PENNIES_IN_NICKEL = 5
  final int CENTS_IN_DOLLAR = 100
  
  final int DOLLARS_IN_TWENTY = 20
  final int DOLLARS_IN_TEN = 10
  final int DOLLARS_IN_FIVE =5
  
  Scanner userInput = new Scanner(System.in)
  System.out.println("What is the purchase price?")
  String purchasePriceString = userInput.next()
  
  Scanner readFromPurchasePrice = new Scanner(purchasePriceString)
  readFromPurchasePrice.useDelimiter("\\.") 
  int purchasePriceDollars = readFromPurchasePrice.nextInt()
  int purchasePriceCents = readFromPurchasePrice.nextInt()
  
  if (purchasePriceCents >= 10)
        System.out.println("The purchase price is $" + purchasePriceDollars + "." + purchasePriceCents)
  else if (purchasePriceCents < 10)
        System.out.println("The purchase price is $" + purchasePriceDollars + ".0" + purchasePriceCents)
  
  System.out.println("How many twenties to pay?")
  int twentiesReceived = userInput.nextInt()
  
  System.out.println("How many tens to pay?")
  int tensReceived = userInput.nextInt()
  
  System.out.println("How many fives to pay?")
  int fivesReceived = userInput.nextInt()
  
  System.out.println("How many ones to pay?")
  int onesReceived = userInput.nextInt()
  
  System.out.println("How many quarters to pay?")
  int quartersReceived = userInput.nextInt()
  
  System.out.println("How many dimes to pay?")
  int dimesReceived = userInput.nextInt()
  
  System.out.println("How many nickels to pay?")
  int nickelsReceived = userInput.nextInt()
  
  System.out.println("How many pennies to pay?")
  int penniesReceived = userInput.nextInt()
  
  int dollarsReceived = 0
  int centsReceived = 0
  
  dollarsReceived += (twentiesReceived * DOLLARS_IN_TWENTY)
  dollarsReceived += (tensReceived * DOLLARS_IN_TEN)
  dollarsReceived += (fivesReceived * DOLLARS_IN_FIVE)
  dollarsReceived += onesReceived
  
  centsReceived += (quartersReceived * PENNIES_IN_QUARTER)
  centsReceived += (dimesReceived * PENNIES_IN_DIME)
  centsReceived += (nickelsReceived * PENNIES_IN_NICKEL)
  centsReceived += penniesReceived
  
  int dollarsInCents = (centsReceived / CENTS_IN_DOLLAR)
  int centsRemaining = (centsReceived % CENTS_IN_DOLLAR)
  
  dollarsReceived += dollarsInCents
  centsReceived = centsRemaining  
  
  
  if (purchasePriceCents >= 10)
        System.out.println("The purchase price is $" + purchasePriceDollars + "." + purchasePriceCents)
  else if (purchasePriceCents < 10)
        System.out.println("The purchase price is $" + purchasePriceDollars + ".0" + purchasePriceCents)
  
  if (centsReceived >= 10)
        System.out.println("The payment tendered is $" + dollarsReceived + "." + centsReceived)
  else if (centsReceived < 10)
        System.out.println("The payment tendered is $" + dollarsReceived + ".0" + centsReceived)
  
  
  boolean paymentGreaterThanCharge;
  if (dollarsReceived >= purchasePriceDollars && centsReceived >= purchasePriceCents)
     paymentGreaterThanCharge = true
  else if (dollarsReceived > purchasePriceDollars)
     paymentGreaterThanCharge = true
  else
     paymentGreaterThanCharge = false
     
  if (paymentGreaterThanCharge == false)
     int chargeDollarsRemaining = (purchasePriceDollars - dollarsReceived)
     if (purchasePriceCents < centsReceived)
        {
            chargeDollarsRemaining -= 1;
            purchasePriceCents += CENTS_IN_DOLLAR;
        }

     int chargeCentsRemaining = (purchasePriceCents - centsReceived)
     
     System.out.println("The amount tendered is not enough to cover the purchase price")
     
     if (chargeCentsRemaining >= 10)
        System.out.println("You still require $" + chargeDollarsRemaining + "." + chargeCentsRemaining)
     else if (chargeCentsRemaining < 10)
        System.out.println("You still require $" + chargeDollarsRemaining + ".0" + chargeCentsRemaining)   
    
     
  else if (paymentGreaterThanCharge == true)
     int changeDollarsRemaining = (dollarsReceived - purchasePriceDollars)
     if (changeCentsRemaining < purchasePriceCents)
        {
            changeDollarsRemaining -= 1;
            changeCentsRemaining += CENTS_IN_DOLLAR;
        }
     int changeCentsRemaining = (centsReceived - purchasePriceCents) 
     
     if (changeCentsRemaining >= 10)
        System.out.println("Your change is $" + changeDollarsRemaining + "." + changeCentsRemaining)
     else if (changeCentsRemaining < 10)
        System.out.println("Your change is $" + changeDollarsRemaining + ".0" + changeCentsRemaining)
     
     System.out.println("That is: ")
     
     
     if (changeDollarsRemaining == 0 && changeCentsRemaining == 0)
        System.out.println("There is no change to be returned")
     
     if (changeDollarsRemaining >= 20)
        int outputTwenties = (changeDollarsRemaining / DOLLARS_IN_TWENTY)
        changeDollarsRemaining = (changeDollarsRemaining % DOLLARS_IN_TWENTY)
        System.out.println(outputTwenties + " $20 bills")
     
     if (changeDollarsRemaining >= 10)   
        int outputTens = (changeDollarsRemaining / DOLLARS_IN_TEN)
        changeDollarsRemaining = (changeDollarsRemaining % DOLLARS_IN_TEN)
        System.out.println(outputTens + " $10 bills")
     
     if (changeDollarsRemaining >= 5)    
        int outputFives = (changeDollarsRemaining / DOLLARS_IN_FIVE)
        changeDollarsRemaining = (changeDollarsRemaining % DOLLARS_IN_FIVE)
        System.out.println(outputFives + " $5 bills")
         
     if (changeDollarsRemaining >= 1)
        int outputOnes = (changeDollarsRemaining)
        System.out.println(outputOnes + " $1 bills")
         
    
     if (changeCentsRemaining >= 25)   
        int outputQuarters = (changeCentsRemaining / PENNIES_IN_QUARTER)
        changeCentsRemaining = (changeCentsRemaining % PENNIES_IN_QUARTER)
        System.out.println(outputQuarters + " quarters")
         
     if (changeCentsRemaining >= 10)
        int outputDimes = (changeCentsRemaining / PENNIES_IN_DIME)
        changeCentsRemaining = (changeCentsRemaining % PENNIES_IN_DIME)
        System.out.println(outputDimes + " dimes")
     
     if (changeCentsRemaining >= 5)    
        int outputNickels = (changeCentsRemaining / PENNIES_IN_NICKEL)
        changeCentsRemaining = (changeCentsRemaining % PENNIES_IN_NICKEL)
        System.out.println(outputNickels + " nickels")
     
     if (changeCentsRemaining >= 1)
        int outputPennies = (changeCentsRemaining)
        System.out.println(outputPennies + " pennies") 
     
          
  
         
  
  
*/

/*
     Data Table for main
     
Variable or Constant         Purpose
_
___________________         __________________
args                         parameter for main 
PENNIES_IN_QUARTER         stores the value of the number of pennies in a quarter
PENNIES_IN_DIME            stores the value of the number of pennies in a dime
PENNIES_IN_NICKEL          stores the value of the number of pennies in a nickel
CENTS_IN_DOLLAR            stores the value of the number of pennies in a dollar
DOLLARS_IN_TWENTY          stores the value of the number of dollars in a twenty dollar bill
DOLLARS_IN_TEN             stores the value of the number of dollars in a ten dollar bill
DOLLARS_IN_FIVE            stores the value of the number of dollars in a five dollar bill

purchasePriceString        stores the string input of the purchase price from the user
purchasePriceDollars       stores the int value of dollars of the purchase
purchasePriceCents         stores the int value of the cents of the purchase

twentiesReceived           stores the number of twenty dollar bills received for payment
tensReceived               stores the number of ten dollar bills received for payment
fivesReceived              stores the number of five dollar bills received for payment
onesReceived               stores the number of one dollar bills received for payment
quartersReceived           stores the number of quarters received for payment
dimesReceived              stores the number of dimes received for payment
nickelsReceived            stores the number of nickels received for payment
penniesReceived            stores the number of pennies received for payment

dollarsReceived            stores the int value of the total dollars received for payment
centsReceived              stores the int value of the total cent value received for payment
dollarsInCents             stores the amount of dollars in change from centsReceived
centsRemaining             stores the amount of cents left after dollarsInCents is moved to dollarsReceived
paymentGreaterThanCharge   boolean, controls the flow of control for the end of the program

chargeDollarsRemaining     stores the amount of dollars that the purchase price is greater than the payment
chargeCentsRemaining       stores the decimal value of cents that the purchase price is greater than the payment

changeDollarsRemaining     stores the dollar value of the change to be returned
changeCentsRemaining       stores the cent value of the change to be returned

outputTwenties             stores the number of twenty dollar bills to be returned
outputTens                 stores the number of ten dollar bills to be returned
outputFives                stores the number of five dollar bills to be returned
outputOnes                 stores the number of one dollar bills to be returned
outputQuarters             stores the number of quarters to be returned
outputDimes                stores the number of dimes to be returned
outputNickels              stores the number of nickels to be returned
outputPennies              stores the number of pennies to be returned
 
*/

  public static void main(String [] args)
  {
  
     final int PENNIES_IN_QUARTER = 25;
     final int PENNIES_IN_DIME = 10;
     final int PENNIES_IN_NICKEL = 5;
     final int CENTS_IN_DOLLAR = 100;
     
     final int DOLLARS_IN_TWENTY = 20;
     final int DOLLARS_IN_TEN = 10;
     final int DOLLARS_IN_FIVE =5;
    
     System.out.println("What is the purchase price?"); 
     Scanner userInput = new Scanner(System.in);
     String purchasePriceString = userInput.next();
     
     Scanner readFromPurchasePrice = new Scanner(purchasePriceString);
     readFromPurchasePrice.useDelimiter("\\.");
     int purchasePriceDollars = readFromPurchasePrice.nextInt();
     int purchasePriceCents = readFromPurchasePrice.nextInt();
     //This is just for fun, but it corrects a 3 digit cent entry with rounding
     if (purchasePriceCents >= 100)
     {
        purchasePriceCents +=5;
        purchasePriceCents /= 10;
     }
     
     if (purchasePriceCents >= 10)
           System.out.println("The purchase price is $" + purchasePriceDollars + "." + purchasePriceCents);
     else if (purchasePriceCents < 10)
           System.out.println("The purchase price is $" + purchasePriceDollars + ".0" + purchasePriceCents);
     
     System.out.println("How many twenties to pay?");
     int twentiesReceived = userInput.nextInt();
     
     System.out.println("How many tens to pay?");
     int tensReceived = userInput.nextInt();
     
     System.out.println("How many fives to pay?");
     int fivesReceived = userInput.nextInt();
     
     System.out.println("How many ones to pay?");
     int onesReceived = userInput.nextInt();
     
     System.out.println("How many quarters to pay?");
     int quartersReceived = userInput.nextInt();
     
     System.out.println("How many dimes to pay?");
     int dimesReceived = userInput.nextInt();
     
     System.out.println("How many nickels to pay?");
     int nickelsReceived = userInput.nextInt();
     
     System.out.println("How many pennies to pay?");
     int penniesReceived = userInput.nextInt();
     
     int dollarsReceived = 0;
     int centsReceived = 0;
     
     dollarsReceived += (twentiesReceived * DOLLARS_IN_TWENTY);
     dollarsReceived += (tensReceived * DOLLARS_IN_TEN);
     dollarsReceived += (fivesReceived * DOLLARS_IN_FIVE);
     dollarsReceived += onesReceived;
     
     centsReceived += (quartersReceived * PENNIES_IN_QUARTER);
     centsReceived += (dimesReceived * PENNIES_IN_DIME);
     centsReceived += (nickelsReceived * PENNIES_IN_NICKEL);
     centsReceived += penniesReceived;
     
     int dollarsInCents = (centsReceived / CENTS_IN_DOLLAR);
     int centsRemaining = (centsReceived % CENTS_IN_DOLLAR);
     
     dollarsReceived += dollarsInCents;
     centsReceived = centsRemaining;
     
     
     if (purchasePriceCents >= 10)
           System.out.println("The purchase price is $" + purchasePriceDollars + "." + purchasePriceCents);
     else if (purchasePriceCents < 10)
           System.out.println("The purchase price is $" + purchasePriceDollars + ".0" + purchasePriceCents);
     
     if (centsReceived >= 10)
           System.out.println("The payment tendered is $" + dollarsReceived + "." + centsReceived);
     else if (centsReceived < 10)
           System.out.println("The payment tendered is $" + dollarsReceived + ".0" + centsReceived);
     
     
     boolean paymentGreaterThanCharge;
     if (dollarsReceived == purchasePriceDollars && centsReceived >= purchasePriceCents)
           paymentGreaterThanCharge = true;
     else if (dollarsReceived > purchasePriceDollars)
           paymentGreaterThanCharge = true;
     else
        paymentGreaterThanCharge = false;
     
     
     int chargeDollarsRemaining = 0;
     int chargeCentsRemaining = 0;
     //These are the opposite results of the if statement
     int changeDollarsRemaining =0;
     int changeCentsRemaining = 0;
     
     //declare these here because it is only used in an if statement
     int outputTwenties;
     int outputTens;
     int outputFives;
     int outputOnes;
     int outputQuarters;
     int outputDimes;
     int outputNickels;
     int outputPennies;
     
     
     
     
     if (paymentGreaterThanCharge == false)
     {
        chargeDollarsRemaining = (purchasePriceDollars - dollarsReceived);
        if (purchasePriceCents < centsReceived)
        {
            chargeDollarsRemaining -= 1;
            purchasePriceCents += CENTS_IN_DOLLAR;
        }
        
        chargeCentsRemaining = (purchasePriceCents - centsReceived);
        
        System.out.println("The amount tendered is not enough to cover the purchase price");
        
        if (chargeCentsRemaining >= 10)
           System.out.println("You still require $" + chargeDollarsRemaining + "." + chargeCentsRemaining);
        else if (chargeCentsRemaining < 10)
           System.out.println("You still require $" + chargeDollarsRemaining + ".0" + chargeCentsRemaining);   
     }  
        
     else if (paymentGreaterThanCharge == true)
     {
        changeDollarsRemaining = (dollarsReceived - purchasePriceDollars);
        if (centsReceived < purchasePriceCents)
        {
            changeDollarsRemaining -= 1;
            centsReceived += CENTS_IN_DOLLAR;
        }
        changeCentsRemaining = (centsReceived - purchasePriceCents);
        
        if (changeCentsRemaining >= 10)
           System.out.println("Your change is $" + changeDollarsRemaining + "." + changeCentsRemaining);
        else if (changeCentsRemaining < 10)
           System.out.println("Your change is $" + changeDollarsRemaining + ".0" + changeCentsRemaining);
        
        System.out.println("That is: ");
        
        
        if (changeDollarsRemaining == 0 && changeCentsRemaining == 0)
           System.out.println("There is no change to be returned");
        
        if (changeDollarsRemaining >= 20)
        {
           outputTwenties = (changeDollarsRemaining / DOLLARS_IN_TWENTY);
           changeDollarsRemaining = (changeDollarsRemaining % DOLLARS_IN_TWENTY);
           System.out.println(outputTwenties + " $20 bills");
        }
        
        if (changeDollarsRemaining >= 10)   
        {
           outputTens = (changeDollarsRemaining / DOLLARS_IN_TEN);
           changeDollarsRemaining = (changeDollarsRemaining % DOLLARS_IN_TEN);
           System.out.println(outputTens + " $10 bills");
        }
        
        if (changeDollarsRemaining >= 5)    
        {
           outputFives = (changeDollarsRemaining / DOLLARS_IN_FIVE);
           changeDollarsRemaining = (changeDollarsRemaining % DOLLARS_IN_FIVE);
           System.out.println(outputFives + " $5 bills");
        }
            
        if (changeDollarsRemaining >= 1)
        {
           outputOnes = (changeDollarsRemaining);
           System.out.println(outputOnes + " $1 bills");
        }    
       
        if (changeCentsRemaining >= 25)   
        {
           outputQuarters = (changeCentsRemaining / PENNIES_IN_QUARTER);
           changeCentsRemaining = (changeCentsRemaining % PENNIES_IN_QUARTER);
           System.out.println(outputQuarters + " quarters");
        }
            
        if (changeCentsRemaining >= 10)
        {
           outputDimes = (changeCentsRemaining / PENNIES_IN_DIME);
           changeCentsRemaining = (changeCentsRemaining % PENNIES_IN_DIME);
           System.out.println(outputDimes + " dimes");
        }
        
        if (changeCentsRemaining >= 5)    
        {
           outputNickels = (changeCentsRemaining / PENNIES_IN_NICKEL);
           changeCentsRemaining = (changeCentsRemaining % PENNIES_IN_NICKEL);
           System.out.println(outputNickels + " nickels");
        }
        
        if (changeCentsRemaining >= 1)
        {
           outputPennies = (changeCentsRemaining);
           System.out.println(outputPennies + " pennies");
        }
     }
  
  }//main(args)
}//class Template