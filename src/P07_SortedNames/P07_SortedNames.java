package P07_SortedNames;
/*
Project description:
Write a program that asks the user to enter three names, and then displays the names sorted
in ascending order. For example, if the user entered “Charlie”, “Leslie”, and “Andy”, the
program would display:
    Andy
    Charlie
    Leslie
*/

import java.util.Scanner;

public class P07_SortedNames
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        //Asks for the names
        String names[] = new String[3];
        for (int i = 0; i < names.length; i++)
        {
            while (true)
            {
                System.out.print("Enter name #"+ (i+1) +": ");
                names[i] = scanner.nextLine();
                
                if(names[i].isBlank())
                {
                    System.out.println("Please enter something");
                }
                else
                {
                    //Checks if the response has any numbers, special characters, punctuation, etc.
                    boolean isValid = true;
                    for (char ch : names[i].toCharArray())
                    {
                        if (!Character.isAlphabetic(ch) && ch != ' ' && ch != '.') { isValid = false; }
                    }
                    
                    if (isValid) { break; }
                    System.out.println("Please enter a name");
                }
            }
        }
        
        
        
        //Sorts the names in alphabetical order (using a selection sort)
        for (int i = 0; i < names.length-1; i++)
        {
            //Finds the (alphabetically) first string in the rest of the list (or the current value)
            String min = names[i];
            int minIdx = i;
            for (int j = i+1; j < names.length; j++)
            {
                if (min.compareTo(names[j]) > 0)
                {
                    min = names[j];
                    minIdx = j;
                }
            }
            
            //Swaps the lowest unsorted value remaining in the list and the value at the current idx
            names[minIdx] = names[i];
            names[i] = min;
        }
        
        
        
        //Prints out the sorted list
        for (String name : names)
        {
            System.out.println(name);
        }
        System.out.println();
    }
}
