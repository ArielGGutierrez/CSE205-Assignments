// Assignment #: 1
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//         Time: 30 minutes
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment1 {
	public static void main (String[] args) {
		
		int number;
		
		Scanner console = new Scanner(System.in);
		number = console.nextInt();     // read an integer entered by a user
		
		// display the number with other messages
		System.out.print("This program reads an integer from a keyboard,\n"
				+ "and prints it out on the display screen.\n"
				+ "The number is:" + number + "\n"
				+ "Make sure that you get the exact same output as the expected one!\n");
		
		console.close();
		}
}


