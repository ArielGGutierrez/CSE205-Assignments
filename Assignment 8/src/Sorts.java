//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: This class uses an insertion sort to sort an ArrayList of Departments.

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts
{
	/**
	 * This class sorts an ArrayList of departments using insertion sort and a specified comparison method.
	 * @param deptList ArrayList to sort
	 * @param xComparator Method of comparing the objects
	 */
	public static void sort(ArrayList<Department> deptList, Comparator<Department> xComparator)
	{
		/* Insertion Sort */
		for (int index = 1; index < deptList.size(); index++)
		{
			/* Current Department and position selected */
			Department key = deptList.get(index);
			int position = index;
			
			/* Move "bigger" elements than the current position to the right */
			while(position > 0 && xComparator.compare(deptList.get(position-1), key) > 0)
			{
				deptList.set(position, deptList.get(position-1));
				position--;
			}
			
			/* Set the key element in the right position */
			deptList.set(position, key);
		}

	} //end sort
} //end class Sorts
