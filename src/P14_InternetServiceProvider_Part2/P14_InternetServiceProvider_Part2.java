package P14_InternetServiceProvider_Part2;
/*
Project description:
Modify the program you wrote for Programming Challenge 13 so it also calculates and
displays the amount of money Package A customers would save if they purchased Package
B or C, and the amount of money Package B customers would save if they purchased Pack-
age C. If there would be no savings, no message should be printed.
*/

import java.util.Scanner;

public class P14_InternetServiceProvider_Part2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        //Asks for the package they purchased
        char pack;
        while (true)
        {
            System.out.print("Enter the letter of the package you purchased (A, B, or C): ");
            String response = scanner.nextLine().toUpperCase();
            
            if (response.startsWith("A") || response.startsWith("B") || response.startsWith("C"))
            {
                pack = response.charAt(0);
                break;
            }
            System.out.println("\nPlease enter either A, B, or C");
        }
        
        
        
        //Asks for the number of hours used
        double hours;
        while (true)
        {
            try
            {
                System.out.print("Enter the number of hours used: ");
                hours = scanner.nextDouble();
                
                if (hours > 0) { break; }
                System.out.println("\nPlease enter a positive number");
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("\nPlease enter a number");
                scanner.nextLine();
            }
        }
        
        
        
        //Calculates and prints the bill for the current package
        System.out.printf("Your package costs: $%,.2f\n", calcCost(pack, hours));
        
        
        
        //Calculates the potential savings of upgrading to package B from package A
        if (pack == 'A' && calcCost(pack, hours) > calcCost('B', hours))
        {
            System.out.printf("You would save $%,.2f if you upgrade to pack B\n", calcCost(pack, hours) - calcCost('B', hours));
        }
        
        //Calculates the potential savings of upgrading to package C ($19.95/mo) from the currnet package
        if ((pack == 'A' || pack == 'B') && calcCost(pack, hours) > 19.95)
        {
            System.out.printf("You would save $%,.2f if you upgrade to pack C\n", calcCost(pack, hours) - 19.95);
        }
    }
    
    
    
    //Calculates the cost with the given package and hours
    public static double calcCost(char pack, double hours)
    {
        switch (pack)
        {
            case 'A','a': //$9.95 per month, 10 hours included, $2.00 per extra hour.
                return 9.95 + 2*Math.max(hours - 10, 0.0);
            case 'B','b': //$13.95 per month, 20 hours included, $1.00 per extra hour.
                return 13.95 + Math.max(hours - 20, 0.0);
            case 'C','c': //$19.95 per month, unlimited hours included.
                return 19.95;
            default: //If the given package doesn't exist
                System.out.println("Package "+pack+" doesn't exist");
                return 0.00;
        }
    }
}
