// Assignment #: 2
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//         Time: 30 minutes
//  Description: This class reads an unspecified number of integers
//               and performs some calculations with them.

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment2 {
	public static void main (String[] args) {
		
		/* Scanner class */
		Scanner scan = new Scanner(System.in);
		
		int input = 0;          // Default user input
		
		int maxInt = 0;         // Maximum integer of number sequence
		int evenCount = 0;      // Number of even integers in the sequence
		int minOdd = 0;         // Minimum odd integer in the sequence
		int negativeSum = 0;    // Sum of all the negative integers in the sequence
		final int SENTINEL = 0; // 0 acts as the sentinel to the following loop
		
		do
		{
			input = scan.nextInt(); // Sets user input to scanned number
			
			/* Finds the max integer of all the numbers inputed */
			if (input > maxInt)
			{
				maxInt = input;
			}
			
			/* Counts number of even inputs */
			if (input % 2 == 0)
			{
				evenCount++;
			}
			
			/* Input is odd and finds if it is the minimum odd integer of all the integers inputed */
			else if(input < minOdd)
			{
				minOdd = input;
			}
			
			/* If input is negative, add it to the sum of all the negative integers inputed */
			if (input < 0)
			{
				negativeSum += input;
			}
			
		} while(input != SENTINEL);
		
		/* Prints results */
		System.out.println("The maximum integer is " + maxInt);
		System.out.println("The count of even integers in the sequence is " + evenCount);
		System.out.println("The smallest odd integer in the sequence is " + minOdd);
		System.out.println("The sum of negative integers is " + negativeSum);
		
		scan.close(); // Closes scanner
	}
}
