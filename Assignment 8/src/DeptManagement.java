//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This class is responsible for managing a group of departments.

import java.util.ArrayList;
//import all other necessary classes.
import java.io.*;

public class DeptManagement implements Serializable
{
	/* Instance variables */
	ArrayList<Department> deptList; // ArrayList of departments
	
	/**
	 * Default constructor of this class that sets the ArrayList of departments to an empty list.
	 */
	public DeptManagement()
	{
		deptList = new ArrayList<Department>();
	}
	
	/**
	 * This method checks if a specific department exists in the deptList.  If it does, it returns the index of that
	 * department and returns -1 otherwise.
	 * @param deptName       String name of the department
	 * @param universityName String name of the university
	 * @return Integer index where this department is in (-1 if it doesn't exist)
	 */
	public int deptExists(String deptName, String universityName)
	{
		/* Check all of the elements in the ArrayList */
		for (int index = 0; index < deptList.size(); index++)
		{
			/* If a department matches the specified name and university name, return the index */
			if (deptList.get(index).getDeptName().equals(deptName) &&
				deptList.get(index).getUniversity().equals(universityName))
			{
				return index;
			}
		}
		
		/* If the department doesn't exist, return -1 */
		return -1;
	}
	
	/**
	 * This method checks if a specific faculty member exists in deptList.  If it does, it returns the index of that
	 * department and returns -1 otherwise.
	 * @param firstName     String first name of the faculty member
	 * @param lastName      String last name of the faculty member
	 * @param academicLevel String academic level of the faculty member
	 * @return Integer index where this faculty member is in (-1 if it doesn't exist)
	 */
	public int facultyExists(String firstName, String lastName, String academicLevel)
	{
		/* Check all of the elements in the ArrayList */
		for (int index = 0; index < deptList.size(); index++)
		{
			/* If a faculty member in a department matches the specified first name, last name, and academic level, return the index */
			if (deptList.get(index).getFaculty().getFirstName().equals(firstName) &&
				deptList.get(index).getFaculty().getLastName().equals(lastName) &&
				deptList.get(index).getFaculty().getAcademicLevel().equals(academicLevel))
			{
				return index;
			}
		}
		
		/* If the faculty doesn't exist, return -1 */
		return -1;
	}
	
	/**
	 * This method adds a new department to the ArrayList if the department doesn't yet exist.
	 * @param deptName      String name of the department
	 * @param university    String name of the university
	 * @param numOfMembers  int number of members in the department
	 * @param firstName     String first name of the faculty member
	 * @param lastName      String last name of the faculty member
	 * @param academicLevel String academic level of the faculty member
	 * @return boolean Whether or not the department was added
	 */
	public boolean addDepartment(String deptName, String university, int numOfMembers, String firstName, String lastName, String academicLevel)
	{
		if(deptExists(deptName, university) != -1)
		{
			return false;
		}
		
		else
		{
			Department newDep = new Department(deptName, university, numOfMembers, firstName, lastName, academicLevel);
			deptList.add(newDep);
			return true;
		}
	}

	//***will remove all departments with the same name and university
	/**
	 * This method checks if the requested department exists and removes it.
	 * @param deptName       String name of the department
	 * @param universityName String name of the university
	 * @return boolean Whether or not the department was removed
	 */
	public boolean removeDepartment(String deptName, String universityName)
	{
		/* Check if the department requested is in the array list */
		int removeIndex = deptExists(deptName, universityName); // Index of the requested department in the array list
		
		/* If the department exists, remove it and return true */
		if(removeIndex != -1)
		{
			deptList.remove(removeIndex);
			return true;
		}
		
		/* If the department doesn't exist, return false */
		else
		{
			return false;
		}
	}

	/**
	 * Sorts the array list of departments by the department names
	 */
	public void sortByDepartmentName()
	{
		/* Establishes a comparator */
		DeptNameComparator nameComparison = new DeptNameComparator();
		
		/* Uses the sorts class to sort the array list */
		Sorts.sort(deptList, nameComparison);
	}
	
	/**
	 * Sorts the array list of departments by the number of faculty members each department has.
	 */
	public void sortByFacultyNumbers()
	{
		FacultyNumberComparator facultyNumComparison = new FacultyNumberComparator();
		
		Sorts.sort(deptList, facultyNumComparison);
	}
	
	/**
	 * Sorts the array list of departments by the names of the assigned faculty.
	 */
	public void sortByDeptFaculty()
	{
		DeptFacultyComparator facultyNameComparison = new DeptFacultyComparator();
		
		Sorts.sort(deptList, facultyNameComparison);
	}
	
	/**
	 * This method creates a string representation of the array list of departments.
	 * @return String representation of the departments.
	 */
	public String listDepartments()
	{
		/* If there are no departments, let the user know */
		if (deptList.isEmpty())
		{
			return "\\nNo Department\\n\\n";
		}
		
		/* Otherwise, return a string representation of all the departments */
		else
		{
			String returnString = "\n"; // String to return to the user
			
			/* Go through all of the members in the array list and add their string representations
			 * to the return string */
			for (int index = 0; index < deptList.size(); index++)
			{
				returnString = returnString + deptList.get(index).toString();
			}
			
			return returnString + "\n"; // Add a final space to the return string
		}
	}
	
	/**
	 * This method erases all of the departments in the department array list
	 */
	public void closeDeptManagement()
	{
		/* Do this for all the elements in the department array list */
		for (int index = 0; index < deptList.size(); index++)
		{
			deptList.remove(0); // Remove the current element
		}
	}
}