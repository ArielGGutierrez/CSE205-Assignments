//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This class is an object representation of a university academic department.
//               This department has a name, university name, number of members and a faculty
//               member associated with it.

import java.io.*;

public class Department implements Serializable
{
	/* private instance variables */
	private String deptName, university; // Names of the department and university
	private int numOfMembers;            // Number of members in the department
	private Faculty currentFaculty;      // The faculty member assigned to the department

	/* constructor */
	/**
	 * Constructor that assigns all of the instance variables.
	 * @param deptName      Name of the department
	 * @param university    Name of the university
	 * @param numOfMembers  Number of members in the department
	 * @param firstName     First name of the faculty assigned to that department
	 * @param lastName      Last name of the faculty assigned to that department
	 * @param academicLevel Academic level of the faculty assigned to that department
	 */
	public Department(String deptName, String university, int numOfMembers,
					  String firstName, String lastName, String academicLevel)
	{
		/* Instantiate instance variables */
		this.deptName = deptName;
		this.university = university;
		this.numOfMembers = numOfMembers;
		currentFaculty = new Faculty(firstName, lastName, academicLevel);
	}
	
	/**
	 * Accessor method to get the name of the department
	 * @return String deptName: Name of the department
	 */
	public String getDeptName()
	{
		return deptName;
	}
	
	/**
	 * Accessor method to get the name of the university this department is in
	 * @return String university: Name of the university
	 */
	public String getUniversity()
	{
		return university;
	}
	
	/**
	 * Accessor method to get the number of members the department has.
	 * @return int numOfMembers: Number of members in the department
	 */
	public int getNumOfMembers()
	{
		return numOfMembers;
	}
	
	/**
	 * Accessor method to get the faculty member assigned to this department.
	 * @return Faculty currentFaculty: The faculty member assigned to the department
	 */
	public Faculty getFaculty()
	{
		return currentFaculty;
	}

	/**
	 * Mutator method to set the department name.
	 * @param a String name to set the depName to
	 */
	public void setDeptName(String a)
	{
		deptName = a;
	}
	
	/**
	 * Mutator method to set the number of members in the department.
	 * @param a Integer number of members
	 */
	public void setNumOfMembers(int a)
	{
		numOfMembers = a;
	}
	
	/**
	 * Mutator method to set the name of the university of the department.
	 * @param a String name of the university to set.
	 */
	public void setUniversity(String a)
	{
		university = a;
	}
	
	/**
	 * Mutator method to set the faculty member assigned to this department
	 * @param firstName     String first name of the faculty
	 * @param lastName      String last name of the faculty
	 * @param academicLevel String academic level of faculty
	 */
	public void setFaculty(String firstName, String lastName, String academicLevel)
	{
		currentFaculty.setFirstName(firstName);
		currentFaculty.setLastName(lastName);
		currentFaculty.setAcademicLevel(academicLevel);
	}

	/**
	 * Returns a string representation of the department.
	 */
	public String toString()
	{
		return "\nDept. Name:\t\t" + deptName + "\n"
				+ "University:\t\t" + university + "\n"
				+ "# of Members:\t" + numOfMembers + "\n"
				+ "Faculty:\t\t" + currentFaculty.toString() + "\n";
	}
}
