//   Assignment: ASU CSE205 Spring 2021 #9
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The Assignment 9 class reads a sequence of integers from input,
//  and compute the maximum, counts numbers divisible by 3, sum of numbers larger than the last, and
//  compute the largest even integer in the sequence using recursion.

import java.io.*;

public class Assignment9
{
	public static void main(String[] args)
	{

		/* Declare integers and int array to store information */
		int num, even, max, count, sum, i = 0;
		int[] numbers = new int[100];

		/* Try-Catch block for input stream and buffered reader io exceptions */
		try
		{
			/* Create an input stream reader and buffered reader object */
			InputStreamReader inputReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputReader);
			
			String line = bufferedReader.readLine().trim(); // Variable to store user input
			
			/* While loop to store all integers in the array until the user types 0 */
			while (Integer.parseInt(line) != 0 && i < numbers.length)
			{
				numbers[i] = Integer.parseInt(line);
				i++;
				line = bufferedReader.readLine().trim();
			}
		}	//end of try block

		/* Catch an IO Exception and print out it occurred */
		catch(IOException ex)
		{
			System.out.println("IO Exception");
		}
         
		/* Call recursive functions to calculate min, countOdd, largeEven, and sum */
		max   = findMax(numbers, 0, i-1);
		even  = largestEven(numbers, 0, i-1);
		count = countDivisibleBy3(numbers, 0, i-1);
		num   = numbers[i-1];
		sum   = sumLargerThanLast(numbers, 0, i-1, num);

		/* Print out results in required format */
		System.out.println("The maximum number is " + max);
		System.out.println("The largest even integer in the sequence is " + even);
		System.out.println("The count of numbers divisible by 3 is " + count);
		System.out.println("The sum of numbers larger than the last is " + sum);
	}	// End main method

	/**
	 * Recursive static method to find the maximum array value.
	 * @param nums       int[] Array of integers
	 * @param startIndex int   Index to start looking
	 * @param endIndex   int   Index to stop looking
	 * @return int The maximum number in the array
	 */
	public static int findMax(int[] nums, int startIndex, int endIndex)
	{
		/* Once both indexes converge, return that number in the array */
		if (startIndex == endIndex)
		{
			return nums[endIndex];
		}
		
		/* If the number in the first index is bigger than the last index, move the last index down */
		if (nums[startIndex] >= nums[endIndex])
		{
			return findMax(nums, startIndex, endIndex - 1);
		}
		
		/* If the number in the last index is bigger than the first index, move the first index up */
		else
		{
			return findMax(nums, startIndex + 1, endIndex);
		}
	}	// End findMax method
	
	/**
	 * Recursive static method to find the largest even number in the array.
	 * @param nums       int[] Array of integers
	 * @param startIndex int   Index to start looking
	 * @param endIndex   int   Index to stop looking
	 * @return int The largest even number in the array.
	 */
	public static int largestEven(int[] nums, int startIndex, int endIndex)
	{
		/* Once both indexes converge, return that number in the array */
		if (startIndex == endIndex)
        {
			return nums[endIndex];
        }
        
		/* If the number at the endIndex isn't even, move the index down */
        if (nums[endIndex] % 2 != 0)
        {
        	return largestEven(nums, startIndex, endIndex - 1);
        }
        
        /* If the number at the startIndex isn't even, move the index up */
        else if (nums[startIndex] % 2 != 0)
        {
        	return largestEven(nums, startIndex + 1, endIndex);
        }
        
		/* If the number in the first index is bigger than the last index, move the last index down */
        else if(nums[startIndex] >= nums[endIndex])
        {
        	return largestEven(nums, startIndex, endIndex - 1);
        }
        
		/* If the number in the last index is bigger than the first index, move the first index up */
        else
        {
        	return largestEven(nums, startIndex + 1, endIndex);
        }
	}	// End computeLargestEven method
	
	/**
	 * Recursive static method to find the amount of numbers in the array divisible by 3.
	 * @param nums       int[] Array of integers
	 * @param startIndex int   Index to start looking
	 * @param endIndex   int   Index to stop looking
	 * @return int The amount of numbers divisible by 3
	 */
	public static int countDivisibleBy3(int[] nums, int startIndex, int endIndex)
	{
		/* Once both indexes converge, return either 1 or 0 */
		if (startIndex == endIndex)
        {
			/* If this number is divisible by 3, return 1 */
			if (nums[startIndex] % 3 == 0)
			{
				return 1;
			}
			
			/* If this number isn't divisible by 3, return 0 */
			else
			{
				return 0;
			}
        }	// end countDivisibleBy3 method
		
		/* If this number is divisible by 3, add 1 and move the startIndex up */
		else if (nums[startIndex] % 3 == 0)
		{
			return 1 + countDivisibleBy3(nums, startIndex + 1, endIndex);
		}
		
		/* If this number isn't divisible by 3, add 0 and move the startIndex up */
		else
		{
			return 0 + countDivisibleBy3(nums, startIndex + 1, endIndex);
		}
	}	//end countDivisibleBy3
	  
	/**
	 * Recursive static method to find the sum of all numbers larger than the last number in the array
	 * @param nums       int[] Array of integers
	 * @param startIndex int   Index to start looking
	 * @param endIndex   int   Index to stop looking
	 * @param lastNumber int   Last number in the array
	 * @return int The amount of numbers in the array that are bigger than its last value
	 */
	public static int sumLargerThanLast(int[] nums, int startIndex, int endIndex, int lastNumber)
	{
		/* Once both indexes converge, return either the number at that index or 0 */
		if (startIndex == endIndex)
        {
			/* If the number at this index is bigger than the last number, return it */
			if (nums[startIndex] > lastNumber)
			{
				return nums[startIndex];
			}
			
			/* If the number at this index isn't bigger than the last number, return 0 */
			else
			{
				return 0;
			}
        }
		
		/* If the number at this index is bigger than the last number, add it to the sum and move startIndex up */
		else if (nums[startIndex] > lastNumber)
		{
			return nums[startIndex] + sumLargerThanLast(nums, startIndex + 1, endIndex, lastNumber);
		}
		
		/* If the number at this index isn't bigger than the last number, add 0 to the sum and move startIndex up */
		else
		{
			return 0 + sumLargerThanLast(nums, startIndex + 1, endIndex, lastNumber);
		}
	}	// End sumOfNumbersLargerThanFirst method
}//end Assignment9 class