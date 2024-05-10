// Assignment #: 5
// Arizona State University - CSE205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The Student abstract class represents a graduate student at a 
//               university.  It takes into account their first name, last name,
//               ID, number of credits and tuition rate.

import java.text.DecimalFormat; // Decimal formatting for money

public abstract class Student
{
	protected String firstName;		// First name of student
	protected String lastName;		// Last name of student
	protected String studentID;		// ID of student
	protected int    numCredit;		// Number of credits student is taken
	protected double rate;			// Tuition rate
	protected double tuition = 0.0; // Tuition student pays
	
	/**
	 * Constructor for the student class
	 * @param fName   String First name of student
	 * @param lName   String Last name of student
	 * @param id      String ID of student
	 * @param credits int Number of credits student is taken
	 * @param rate    double Tuition rate
	 */
	public Student(String fName, String lName, String id, int credits, double rate)
	{
		this.firstName = fName;   // Sets the student's first name
		this.lastName  = lName;   // Sets the student's last name
		this.studentID = id;      // Sets the student's id
		this.numCredit = credits; // Sets the number of credits the student is taking
		this.rate      = rate;    // Sets the tuition rate
	}
	
	/**
	 * Returns the number of credits a student is taking
	 * @return int number of credits
	 */
	public int getNumCredit()
	{
		return numCredit;
	}
	
	public abstract void computeTuition();
	
	/**
	 * Returns a string representation of the student.
	 */
	public String toString()
	{
		DecimalFormat money = new DecimalFormat("$##,##0.00"); // Decimal formatting for money
		
		String result = "\nFirst name:\t\t" + firstName +
						"\nLast name:\t\t" + lastName +
						"\nStudent ID:\t\t" + studentID +
						"\nCredits:\t\t" + numCredit +
						"\nRate:\t\t\t" + money.format(rate) +
						"\nTuition:\t\t" + money.format(tuition) + "\n";
		
		return result;
	}
}
