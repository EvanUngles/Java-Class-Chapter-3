package P02_MagicDates;

/*
Project description:
The date June 10, 1960, is special because when we write it in the following format, the
month times the day equals the year:
    6/10/60
Write a program that asks the user to enter a month (in numeric form), a day, and a two-
digit year. The program should then determine whether the month times the day is equal
to the year. If so, it should display a message saying the date is magic. Otherwise, it should
display a message saying the date is not magic.

AI usage: On a switch statement I included in the program, the IDE gave an automatic suggestion, which I accepted
Original: (my work)
    int daysInMonth;
    switch (month) {
        case 2:
            daysInMonth = 29;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            daysInMonth = 30;
            break;
        default:
            daysInMonth = 31;
            break;
    }

Suggestion from IDE autofill: (which I then modified)
    int daysInMonth;
    daysInMonth = switch (month) {
        case 2 -> 29;
        case 4, 6, 9, 11 -> 30;
        default -> 31;
    };
*/

import java.util.Scanner;

public class P02_MagicDates
{
    public static void main(String[] args)
    {
        //Asks for the month
        int month = askInt("Enter the month (as a number): ", 1,12);
        
        //Determines the number of days in the month
        int daysInMonth = switch (month) {
            case 2 -> 29;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
        
        //Asks for the month and year
        int day = askInt("Enter the day (as a number): ", 1,daysInMonth);
        int year = askInt("Enter the year (as 2 digits): ", 0,99);
        
        
        
        //Prints out the result
        String yearStr = year+"";
        if (year < 10) { yearStr = "0"+year; } //formats year to have a leading 0 if necessary
        if (month * day == year)
        {
            System.out.println(month+"/"+day+"/"+yearStr +" is a magic date!");
        }
        else
        {
            System.out.println(month+"/"+day+"/"+yearStr +" is not magic");
        }
    }
    
    
    
    //Asks the given question until the input is a number between min and max (inclusive)
    public static int askInt(String question, int min, int max)
    {
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            try
            {
                System.out.print(question);
                int num = scanner.nextInt();
                
                if (num >= min && num <= max) { return num; }
                System.out.println("\nPlease enter a number between "+ min +" and "+ max);
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("\nPlease enter a number");
                scanner.nextLine();
            }
        }
    }
}
