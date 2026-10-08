package P01_RomanNumerals;
/*
Project description:
Write a program that prompts the user to enter a number within the range of 1 through 10.
The program should display the Roman numeral version of that number. If the number is
outside the range of 1 through 10, the program should display an error message.
*/

import java.util.Scanner;

public class P01_RomanNumerals
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final char NUMERALS[] = {'I','V','X','L','C','D','M'};
        final int VALUES[] = {1,5,10,50,100,500,1000};
        
        
        
        //Asks for the number to convert
        int num;
        while (true)
        {
            try
            {
                System.out.print("Enter a number between 1 and 10: ");
                num = scanner.nextInt();
                
                if (num >= 1 && num <= 10) { break; }
                System.out.println("Please enter a number between 1 and 10");
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
        
        
        
        //Boring version that the assignment wants:
        /*
        switch (num)
        {
            case 10: System.out.println("X"); break;
            case 9: System.out.println("IX"); break;
            case 4: System.out.println("IV"); break;
            default:
                if (num >= 5)
                {
                    System.out.print("V");
                    num -= 5;
                }
                while (num > 0)
                {
                    System.out.println("I");
                    num--;
                }
        }
        */
        
        //Much cooler version that I want:
        //Converts to Roman Numerals and prints the result
        int remaining = num;
        for (int idx = 6; idx >= 0; idx--)
        {
            while (remaining >= VALUES[idx])
            {
                remaining -= VALUES[idx];
                System.out.print(NUMERALS[idx]);
            }
            
            //Checks if there is still more to be done
            if (remaining == 0) { break; }
            
            //Determines what the allowed numeral for subtraction would be
            int subtractor;
            if (idx <= 2)      { subtractor = 0; }
            else if (idx <= 4) { subtractor = 2; }
            else               { subtractor = 4; }
            
            //Checks if the numeral should be subtracted
            if (VALUES[idx] - VALUES[subtractor] <= remaining)
            {
                remaining -= (VALUES[idx] - VALUES[subtractor]);
                System.out.print(NUMERALS[subtractor] +""+ NUMERALS[idx]);
            }
        }
        
        System.out.println("\n");
    }
}
