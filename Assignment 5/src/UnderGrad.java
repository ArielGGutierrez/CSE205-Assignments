// Assignment #: 5
// Arizona State University - CSE205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The UnderGrad class represents an undergraduate student at a 
//               university.  It takes into account their first name, last name,
//               ID, number of credits, tuition rate, in state status and program
//               fee.

import java.text.DecimalFormat; // Decimal formatting for money

public class UnderGrad extends Student
{
	private boolean inState;      // In-State status of the student
	private int creditUpperbound; // Upper bound of credits
	private double programFee;    // Fee for the program
	
	/**
	 * 
	 * Constructor for the UnderGrad class
	 * @param fName      String First name of student
	 * @param lName      String Last name of student
	 * @param id         String ID of student
	 * @param credits    int Number of credits student is taken
	 * @param rate       double Tuition rate
	 * @param inState    boolean In-state status of the student
	 * @param programFee double Fee for the program
	 */
	public UnderGrad(String fName, String lName, String id, int credits, double rate, boolean inState, double programFee)
	{
		super(fName, lName, id, credits, rate); // Uses parent constructor
		
		this.inState    = inState;    // Sets the in-state status of the student
		this.programFee = programFee; // Sets the program fee of the student
		
		/* Sets the credit upper bound of the student.  If they're in-state, set it to 7, otherwise set it to 12 */
		if (this.inState)
		{
			this.creditUpperbound = 7;
		}
		
		else
		{
			this.creditUpperbound = 12;
		}
	}
	
	/**
	 * Computes tuition for the undergraduate student
	 */
	public void computeTuition()
	{
		/* If the number of credits exceeds the upper bound, only charge up to that bound */
		if (numCredit >= creditUpperbound)
		{
			tuition = rate * creditUpperbound + programFee;
		}
		
		/* Otherwise use the actual credits */
		else
		{
			tuition = rate * numCredit + programFee;
		}
	}
	
	/**
	 * Returns a string representation of the undergraduate student.
	 */
	public String toString()
	{
		String stateStatus; // Converts the inState boolean into a string to print out
		
		/* If the inState boolean is true, the student is In-State */
		if(inState)
		{
			stateStatus = "In-State";
		}
		
		/* Otherwise, they're Out-Of-State */
		else
		{
			stateStatus = "Out-Of-State";
		}
		
		DecimalFormat money = new DecimalFormat("$##,##0.00"); // Decimal formatting for money
		
		String result = "\nUnderGrad:\n" + 
						stateStatus + 
						super.toString() + 
						"Student Program Fee:\t" + money.format(programFee) + "\n";
		
		return result;
	}
	
}
