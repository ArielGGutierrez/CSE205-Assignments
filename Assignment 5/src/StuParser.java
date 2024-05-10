// Assignment #: 5
// Arizona State University - CSE205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The StuParser class takes a block of string delimited
//               by a "/" as input and returns a student object.

import java.util.ArrayList; // To use array lists
import java.util.Scanner;   // To use the java scanner

public class StuParser
{
	/**
	 * This method takes a string of information and turns it into a student object of type graduate or undergraduate
	 * @param lineToParse String Line of information to turn into a graduate or undergraduate student
	 * @return Graduate or UnderGrad object
	 */
	public static Student parseStringToStudent(String lineToParse)
	{
		ArrayList<String> information = new ArrayList<String>(); // Array List to hold information
		
		Scanner scan = new Scanner(lineToParse).useDelimiter("/"); // Scanner to delimit and obtain information
		
		/* Stores each phrase in the input in the information array list */
		while (scan.hasNext())
		{
			information.add(scan.next());
		}
		
		scan.close(); // Closes the scanner
		
		String fName = information.get(1);                     // Gets the first name from the information array list
		String lName = information.get(2);                     // Gets the last name from the information array list
		String id    = information.get(3);                     // Gets the id from the information array list
		int credits  = Integer.parseInt(information.get(4));   // Converts into an integer and gets the credit from the information array list
		double rate  = Double.parseDouble(information.get(5)); // Converts into a double and gets the tuition rate from the information array list
		
		/* If the student is a graduate student, then get the graduate fee and return a Graduate student object */
		if (information.get(0).toLowerCase().equals("graduate"))
		{
			double gradFee = Double.parseDouble(information.get(6)); // Converts into a double and gets the graduate fee from the information array list
			
			return new Graduate(fName, lName, id, credits, rate, gradFee); // returns a Graduate student object
		}
		
		/* Otherwise, determine if the undergraduate student is instate, get the program fee and return an UnderGrad object */
		else
		{
			boolean inState; // Turns the student in-state status into a boolean
			
			/* If the student is in-state, set it to true */
			if (information.get(6).toLowerCase().equals("instate"))
			{
				inState = true;
			}
			
			/* Otherwise it is false */
			else
			{
				inState = false;
			}
			
			double programFee = Double.parseDouble(information.get(7)); // Converts into a double and gets the program fee from the information array list
			
			return new UnderGrad(fName, lName, id, credits, rate, inState, programFee); // returns a UnderGrad student object
		}
	}
}
