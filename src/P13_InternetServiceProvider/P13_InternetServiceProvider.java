package P13_InternetServiceProvider;
/*
Project description:
An Internet service provider has three different subscription packages for its customers:
    Package A: For $9.95 per month 10 hours of access are provided. Additional hours are $2.00 per hour.
    Package B: For $13.95 per month 20 hours of access are provided. Additional hours are $1.00 per hour.
    Package C: For $19.95 per month unlimited access is provided.
Write a program that calculates a customer’s monthly bill. It should ask the user to enter
the letter of the package the customer has purchased (A, B, or C) and the number of hours
that were used. It should then display the total charges.
*/

import java.util.Scanner;

public class P13_InternetServiceProvider
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
        
        
        
        //Calculates and prints the bill
        System.out.printf("Your package costs: $%,.2f\n", calcCost(pack, hours));
    }
    
    
    
    //Calculates the cost with the given package and hours
    public static double calcCost(char pack, double hours)
    {
        switch (pack)
        {
            case 'A','a': //$9.95 per month, 10 hours included, $2.00 per extra hour.
                return 9.95 + 2*Math.max(hours - 10, 0);
            case 'B','b': //$13.95 per month, 20 hours included, $1.00 per extra hour.
                return 13.95 + Math.max(hours - 20, 0);
            case 'C','c': //$19.95 per month, unlimited hours included.
                return 19.95;
            default: //If the given package doesn't exist
                System.out.println("Package "+pack+" doesn't exist");
                return 0.00;
        }
    }
}