//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This comparator compares 2 departments by the number of faculty they contain.
//               Departments with lower faculty numbers are ordered first

import java.util.*;

public class FacultyNumberComparator implements Comparator<Department>
{
	/**
	 * Compares  two departments for order based on their number of faculty. Returns a negative integer, zero, or a 
	 * positive integer as the first argument is less than, equalto, or greater than the second.
	 */
	public int compare(Department first, Department second)
	{
		/* If the first department has less faculty, place it first */
		if(first.getNumOfMembers() < second.getNumOfMembers())
		{
			return -1;
		}
		
		/* If both departments have the same number of faculty, they're equal */
		else if (first.getNumOfMembers() == second.getNumOfMembers())
		{
			return 0;
		}
		
		/* If the second department has less faculty, place that one first */
		else
		{
			return 1;
		}
	}
}
