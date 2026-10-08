package P06_TimeCalculator;
/*
Project description:
Write a program that asks the user to enter a number of seconds.
 • There are 60 seconds in a minute. If the number of seconds entered by the user is
   greater than or equal to 60, the program should display the number of minutes in that
   many seconds.
 • There are 3,600 seconds in an hour. If the number of seconds entered by the user is
   greater than or equal to 3,600, the program should display the number of hours in
   that many seconds.
 • There are 86,400 seconds in a day. If the number of seconds entered by the user is
   greater than or equal to 86,400, the program should display the number of days in
   that many seconds.
*/

import java.util.Scanner;

public class P06_TimeCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        //Asks for the number of seconds
        int seconds;
        while (true)
        {
            try
            {
                System.out.print("Enter a number of seconds: ");
                seconds = scanner.nextInt();
                
                if (seconds > 0) { break; }
                System.out.println("\nPlease enter a positive number");
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("\nPlease enter a whole number");
                scanner.nextLine();
            }
        }
        
        
        
        //Prints out the number of minutes
        if (seconds >= 60)
        {
            System.out.println("There are "+ (seconds/60) +" minutes in "+ seconds +" seconds");
        }
        if (seconds >= 3600)
        {
            System.out.println("There are "+ (seconds/3600) +" hours in "+ seconds +" seconds");
        }
        if (seconds >= 86400)
        {
            System.out.println("There are "+ (seconds/86400) +" days in "+ seconds +" seconds");
        }
        
        
        
        //Prints the time in the combined units
        int days = seconds / 86400;
        int hours = (seconds % 86400) / 3600;
        int minutes = (seconds % 3600) / 60;
        int secondsRemaining = seconds % 60;
        System.out.println("In total, "+ seconds +" seconds is "+ days +"d "+ hours +"h "+ minutes +"m "+ secondsRemaining +"s");
    }
}
