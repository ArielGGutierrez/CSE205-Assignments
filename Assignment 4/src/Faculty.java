/* 
 * Assignment #: 4
 *         Name: Ariel Gael Gutierrez
 *    StudentID: 1218982505
 *      Lecture: TTH 1:30PM-2:45 PM
 *  Description: This class represents information on a faculty 
 *  member that is in a department.
 */

public class Faculty
{
	private String     firstName; // First name of faculty member
	private String      lastName; // Last name of faculty member
	private String academicLevel; // Academic level of faculty member
	
	/**
	 * Default constructor that initializes the name and academic
	 * level of the faculty member to "?"
	 */
	public Faculty()
	{
		firstName     = "?";
		lastName      = "?";
		academicLevel = "?";
	}
	
	/**
	 * Gets the first name of the faculty member
	 * @return String firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Gets the last name of the faculty member
	 * @return String lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Gets the academic level of the faculty member
	 * @return String academicLevel
	 */
	public String getAcademicLevel()
	{
		return academicLevel;
	}
	
	/**
	 * sets the first name of the faculty member
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * sets the last name of the faculty member
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * sets the academic level of the faculty member
	 */
	public void setAcademicLevel(String academicLevel)
	{
		this.academicLevel = academicLevel;
	}
	
	/**
	 * Gets a string representation of this object in the format "lastName,firstName(academicLevel)"
	 */
	public String toString()
	{
		String convertedString = lastName + "," + firstName + "(" + academicLevel + ")";
		return convertedString;
	}
}
