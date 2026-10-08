package P16_BookClubPoints;
/*
Project description:
Serendipity Booksellers has a book club that awards points to its customers based on the
number of books purchased each month. The points are awarded as follows:
 • If a customer purchases 0 books, he or she earns 0 points.
 • If a customer purchases 1 book, he or she earns 5 points.
 • If a customer purchases 2 books, he or she earns 15 points.
 • If a customer purchases 3 books, he or she earns 30 points.
 • If a customer purchases 4 or more books, he or she earns 60 points.
Write a program that asks the user to enter the number of books that he or she has pur-
chased this month and then displays the number of points awarded.
*/

import java.util.Scanner;

public class P16_BookClubPoints
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        //Asks for the number of books purchased
        int numBooks;
        while (true)
        {
            try
            {
                System.out.print("Enter the number of books purchased this month: ");
                numBooks = scanner.nextInt();
                
                if (numBooks >= 0) { break; }
                System.out.println("\nPlease enter a positive number");
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("\nPlease enter a whole number");
                scanner.nextLine();
            }
        }
        
        
        
        //Prints the number of points earned
        if(numBooks < 0) { System.out.println("Something has gone wrong, please try again"); }
        else
        {
            switch (numBooks)
            {
                case 0 -> System.out.println("You have earned 0 points\n");
                case 1 -> System.out.println("You have earned 5 points\n");
                case 2 -> System.out.println("You have earned 15 points\n");
                case 3 -> System.out.println("You have earned 30 points\n");
                default -> System.out.println("You have earned 60 points\n");
            }
        }
    }
}
