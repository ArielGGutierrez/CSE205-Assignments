//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This comparator compares 2 departments by the names of their faculty.
//				 The department that goes first is the one with the faculty whose name
//				 comes lexicographically before the other.

import java.util.Comparator;

public class DeptFacultyComparator implements Comparator<Department>
{
	/**
	 * Compares  two departments for order based on the alphabetical order of the faculty's last name and first name.
	 * Returns a negative integer,zero, or a positive integer as the first argument is less than, equalto, or greater than
	 * the second.
	 */
	public int compare(Department first, Department second)
	{
		/* Get the current faculty for the first and second department */
		Faculty firstFaculty  =  first.getFaculty();
		Faculty secondFaculty = second.getFaculty();
		
		/* IF their last names aren't the same, compare them alphabetically */
		if(firstFaculty.getLastName().compareTo(secondFaculty.getLastName()) != 0)
		{
			return firstFaculty.getLastName().compareTo(secondFaculty.getLastName());
		}
		
		/* If their last names are the same, compare their first names alphabetically. */
		else
		{
			return firstFaculty.getFirstName().compareTo(secondFaculty.getFirstName());
		}

	}
}
