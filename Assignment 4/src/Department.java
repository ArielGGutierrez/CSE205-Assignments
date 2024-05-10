/* 
 * Assignment #: 4
 *         Name: Ariel Gael Gutierrez
 *    StudentID: 1218982505
 *      Lecture: TTH 1:30PM-2:45 PM
 *  Description: This class describes a department at a university.
 */

public class Department
{
	private String      departName; // Name of the university department
	private int    numberOfMembers; // Number of members in the department
	private String      University; // Name of the university
	private Faculty currentFaculty; // Current faculty member
	
	/**
	 * Default constructor that initializes the department name
	 * and university name to "?", number of members to 0 and
	 * the current faculty member to "?" characteristics.
	 */
	public Department()
	{
		departName      = "?";
		numberOfMembers = 0;
		University      = "?";
		currentFaculty  = new Faculty();
	}
	
	/**
	 * Gets the name of the department
	 * @return String departName
	 */
	public String getDeptName()
	{
		return departName;
	}
	
	/**
	 * Gets the number of members in the department
	 * @return int numberOfMembers
	 */
	public int getNumberOfMembers()
	{
		return numberOfMembers;
	}
	
	/**
	 * Gets the name of the university
	 * @return String University
	 */
	public String getUniversity()
	{
		return University;
	}
	
	/**
	 * sets the name of the department
	 */
	public void setDepartmentName(String departName)
	{
		this.departName = departName;
	}
	
	/**
	 * sets the number of members in the department
	 */
	public void setNumberOfMembers(int numberOfMembers)
	{
		this.numberOfMembers = numberOfMembers;
	}
	
	/**
	 * sets the name of the university
	 */
	public void setUniversity(String universityName)
	{
		this.University = universityName;
	}
	
	/**
	 * sets the current faculty member with a first name, last 
	 * name, and academic level
	 */
	public void setCurrentFaculty(String firstName, String lastName, String academicLevel)
	{
		currentFaculty.setFirstName(firstName);
		currentFaculty.setLastName(lastName);
		currentFaculty.setAcademicLevel(academicLevel);
	}
	
	/**
	 * Gets a string representation of this object in the format:
	 * "
	 * 
	 * Department Name: 		departName
	 * Number Of Members: 	numberOfMembers
	 * University:			University
	 * Faculty:				currentFaculty
	 * 
	 * "
	 */
	public String toString()
	{
		String convertedString = "\nDepartment Name:\t\t" + departName +
				                 "\nNumber Of Members:\t" + numberOfMembers + 
				                 "\nUniversity:\t\t" + University +
				                 "\nFaculty:\t\t" + currentFaculty.toString() + "\n\n";
		return convertedString;
	}
}
