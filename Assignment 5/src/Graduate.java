// Assignment #: 5
// Arizona State University - CSE205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The Graduate class represents a graduate student at a university.
//               It takes into account their first name, last name, ID, number of 
//               credits, tuition rate and graduate fee.

import java.text.DecimalFormat; // Decimal formatting for money

public class Graduate extends Student
{
	private double gradFee; // Graduate school fee
	
	/**
	 * Constructor for Graduate class
	 * @param fName   String First name of student
	 * @param lName   String Last name of student
	 * @param id      String ID of student
	 * @param credits int Number of credits student is taken
	 * @param rate    double Tuition rate
	 * @param gradFee double Graduate school fee
	 */
	public Graduate(String fName, String lName, String id, int credits, double rate, double gradFee)
	{
		super(fName, lName, id, credits, rate); // Uses parent constructor
		
		this.gradFee = gradFee;
	}
	
	/**
	 * Computes tuition for the graduate student
	 */
	public void computeTuition()
	{
		tuition = rate * numCredit + gradFee;
	}
	
	/**
	 * Returns a string representation of the graduate student.
	 */
	public String toString()
	{
		DecimalFormat money = new DecimalFormat("$##,##0.00"); // Decimal formatting for money
		
		String result = "\nGraduate Student:" + 
		                super.toString() + 
		                "Grad Fee:\t\t" + 
		                money.format(gradFee) + "\n";
		
		return result;
	}
}
