//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This comparator compares 2 departments by the name of their department.
//               The department that goes first is the one whose name comes lexicographically
//               before the other.

import java.util.*;

public class DeptNameComparator implements Comparator<Department>
{
	/**
	 * Compares  two departments for order based on the alphabetical order of the department's name. Returns a
	 * negative integer, zero, or a positive integer as the first argument is less than, equalto, or greater than the second.
	 */
	public int compare(Department first, Department second)
	{
		/* Get the names of both departments */
		String  firstString =  first.getDeptName();
		String secondString = second.getDeptName();
		
		/* Return the comparison of the two names */
		return firstString.compareTo(secondString);
	}
}
