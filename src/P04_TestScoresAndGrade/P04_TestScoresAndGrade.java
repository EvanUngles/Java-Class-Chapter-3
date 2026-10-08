package P04_TestScoresAndGrade;
/*
Project description:
Write a program that has variables to hold three test scores. The program should ask the
user to enter three test scores and then assign the values entered to the variables. The pro-
gram should display the average of the test scores and the letter grade that is assigned for
the test score average. Use the grading scheme in the following table:
Test Score Average | Letter Grade
90–100             | A
80–89              | B
70–79              | C
60–69              | D
Below 60           | F
*/

import java.util.Scanner;

public class P04_TestScoresAndGrade
{
    public static void main(String[] args)
    {
        //Asks for the test scores
        double[] earned = new double[3];
        double[] possible = new double[3];
        for (int idx = 0; idx < 3; idx++)
        {
            earned[idx] = askNum("Enter the number of points received for test #"+ (idx+1) +": ");
            possible[idx] = askNum("Enter the number of possible points for test #"+ (idx+1) +": ");
            System.out.println();
        }
        
        
        
        //Prints out the scores while adding to the running total of the scores
        double totalScore = 0;
        for (int idx = 0; idx < 3; idx++)
        {
            //Prints out the score for that test
            double percentEarned = 100.0 * earned[idx] / possible[idx];
            System.out.printf("Test #"+ (idx+1) +": %6.2f", percentEarned);
            System.out.println("% ("+ grade(percentEarned) +")");
            
            //Adds the values to the running total of the scores
            totalScore += percentEarned;
        }
        
        //Prints the average score with 2 decimal places and with the % alligned with the others
        double averageScore = totalScore / 3.0;
        System.out.printf("\nAverage: %6.2f", averageScore);
        System.out.println("% ("+ grade(averageScore) +")");
    }
    
    
    
    //Asks the given question until the input is a positive number
    public static double askNum(String question)
    {
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            try
            {
                System.out.print(question);
                double num = scanner.nextDouble();
                
                if (num > 0) { return num; }
                System.out.println("\nPlease enter a positive number");
            }
            catch (java.util.InputMismatchException ex)
            {
                System.out.println("\nPlease enter a number");
                scanner.nextLine();
            }
        }
    }
    
    
    
    //Returns the letter grade for the given score
    public static char grade(double percentEarned)
    {
        if (percentEarned >= 90)
        {
            return 'A';
        }
        else if (percentEarned >= 80)
        {
            return 'B';
        }
        else if (percentEarned >= 70)
        {
            return 'C';
        }
        else if (percentEarned >= 60)
        {
            return 'D';
        }
        else
        {
            return 'F';
        }
    }
}
