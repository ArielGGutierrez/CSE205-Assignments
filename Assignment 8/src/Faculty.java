//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This class is an object representation of a faculty member in a
//               department.  It contains the first name, last name, and academic
//               level of the faculty member.

import java.io.*;

public class Faculty implements Serializable
{
	/* private instance variables */
	private String firstName, lastName, academicLevel; // First name, last name and academic level of the faculty member

	/* constructor */
	/**
	 * Constructor that assigns all of the instance variables.
	 * @param firstName     String first name of the faculty member
	 * @param lastName      String last name of the faculty member
	 * @param academicLevel String academic level of the faculty member
	 */
	public Faculty(String firstName, String lastName, String academicLevel)
	{
		/* Instantiate instance variables */
		this.firstName = firstName;
		this.lastName = lastName;
		this.academicLevel = academicLevel;
	}
	
	/**
	 * Accessor method to get the first name of the faculty member.
	 * @return String firstName: The first name of the faculty member
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Accessor method to get the last name of the faculty member.
	 * @return String lastName: The last name of the faculty member
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Accessor method to get the academic level of the faculty member.
	 * @return String academicLevel: The academic level of the faculty member
	 */
	public String getAcademicLevel()
	{
		return academicLevel;
	}

	/**
	 * Mutator method that sets the first name of the faculty member.
	 * @param firstName String first name of the faculty member
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Mutator method that sets the last name of the faculty member.
	 * @param lastName String last name of the faculty member
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	//sets academicLevel to the specified string
	/**
	 * Mutator method that sets the academic level of the faculty member.
	 * @param level String academic level of the faculty member
	 */
	public void setAcademicLevel(String level)
	{
		academicLevel = level;
	}
	
	/**
	 * Returns a string representation of the faculty.
	 */
	public String toString()
	{
		return firstName + " " + lastName + ", " + academicLevel;
	}
}
