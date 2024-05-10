//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;
import java.util.Scanner;

public class Assignment8
{
	public static void main(String[] args)
	{
		char input1;
		String deptName, numOfFacultyStr, nameOfUniversity;
		String firstName, lastName, academicLevel;
		String university;
		int numOfFaculty;

		boolean operation = false;
		int operation2 = 0;
		String line;
		String filename;

		// create a DeptManagement object. This is used throughout this class.
		DeptManagement deptManage1 = new DeptManagement();

		File file;

		try {
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System.in );
			BufferedReader stdin = new BufferedReader(isr);

			do{
				System.out.print("\nWhat action would you like to perform?\n");
				line = stdin.readLine().trim(); //read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) //check if a user entered only one character
				{
					switch (input1)
					{
					case 'A':
						//Add Department
						System.out.print("Please enter the department information:\n");
						System.out.print("Enter department name:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Enter number of faculty:\n");
						numOfFacultyStr = stdin.readLine().trim();
						numOfFaculty = Integer.parseInt(numOfFacultyStr);
						System.out.print("Enter university name:\n");
						nameOfUniversity = stdin.readLine().trim();
						System.out.print("Enter faculty first name:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Enter faculty last name:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Enter faculty academic level:\n");
						academicLevel = stdin.readLine().trim();
						
						/* Determine if the adding process is successful */
						boolean success = deptManage1.addDepartment(deptName, nameOfUniversity, numOfFaculty, firstName, lastName, academicLevel);
						
						/* If it succeeds, let the user know */
						if(success)
						{
							System.out.print("Department added\n");
						}
						
						/* If it fails, let the user know */
						else
						{
							System.out.print("Department NOT added\n");
						}
						break;
						
					case 'C':
						//Create a new department management
						deptManage1 = new DeptManagement();
						break;
						
					case 'D':
						//Search by department's name and the university
						System.out.print("Please enter the department name to search:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Please enter the university name to search:\n");
						university = stdin.readLine().trim();
						
						/* Determine if the department exists */
						int deptIndex = deptManage1.deptExists(deptName, university);
						
						/* If it exists, let the user know */
						if (deptIndex != -1)
						{
							System.out.print(deptName + " at " + university + " is found\n");
						}
						
						/* If it doesn't exist, let the user know */
						else
						{
							System.out.print(deptName + " at " + university + " is NOT found\n");
						}
						break;
						
					case 'E':
						//Search faculty
						System.out.print("Please enter the faculty first name to search:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Please enter the faculty last name to search:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Please enter the faculty academic level to search:\n");
						academicLevel = stdin.readLine().trim();
						
						/* Determine if a faculty member exists */
						int facultyIndex = deptManage1.facultyExists(firstName, lastName, academicLevel);
						
						/* If it exists, let the user know */
						if (facultyIndex != -1)
						{
							System.out.print("Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is found\n");
						}
						
						/* If it doesn't exist, let the user know */
						else
						{
							System.out.print("Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is NOT found\n");
						}
						break;
						
					case 'L':
						//List departments
						System.out.print(deptManage1.listDepartments());
						break;

					case 'N':
						/* Sort the departments in alphabetical order and let the user know it was successful */
						deptManage1.sortByDepartmentName();
						System.out.print("sorted by department names\n");
						break;

					case 'O':
						/* Sort the departments by the number of faculty members and let the user know it was successful */
						deptManage1.sortByFacultyNumbers();;
						System.out.print("sorted by faculty numbers\n");
						break;
						
					case 'P':
						/* Sort the departments in alphabetical order of faculty member and let the user know it was successful */
						deptManage1.sortByDeptFaculty();
						System.out.print("sorted by current faculty name\n");
						break;
						
					case 'Q':
						//Quit
						break;
						
					case 'R':
						//Remove a department
						System.out.print("Please enter the department name to remove:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Please enter the university name to remove:\n");
						university = stdin.readLine().trim();
						
						/* Try to remove the department and check if it was successful */
						operation = deptManage1.removeDepartment(deptName, university);
						
						/* Report to the user if the process was successful */
						if (operation == true)
							System.out.print(deptName + " at " + university + " is removed\n");
						else
							System.out.print(deptName + " at " + university + " is NOT removed\n");
						break;
						
					case 'T':
						//Close DeptManagement
						deptManage1.closeDeptManagement();
						System.out.print("Department management system closed\n");
						break;
						
					case 'U':
						//Write Text to a File
						System.out.print("Please enter a file name that we will write to:\n");
						filename = stdin.readLine().trim();
						
						try
						{
							/************************************************************************************
							 ***  Complete the following statement, write above string inside the relevant file
							 ***********************************************************************************/
							/* Create objects necessary to write to a file */
							FileWriter fileWriter = new FileWriter(filename);
							BufferedWriter bufferedWriter = new BufferedWriter (fileWriter);
							PrintWriter outFile = new PrintWriter (bufferedWriter);
							
							/* Ask the user to provide a string to write */
							System.out.print("Please enter a string to write inside the file:\n");
							
							/* Trim the string the user inputed */
							line = stdin.readLine().trim();
							
							/* Write this string to the file and add a space to the end */
							outFile.println(line + "\n");
							
							/* Close the file */
							outFile.close();
							
							/* Let the user know that the process was successful */
							System.out.print(filename + " is written\n");
						}
						
						/* Catch any exception in the process and let the user know that there was an error */
						catch(Exception e)
						{
							System.out.print("Write string inside the file error\n");
						}
						break;
						
					case 'V':
						//Read Text from a File
						System.out.print("Please enter a file name which we will read from:\n");
						filename = stdin.readLine().trim();
						try
						{
							/* Create objects needed to read a file */
							FileReader fr = new FileReader(filename);
							Scanner in = new Scanner(fr);
							
							/* Read the first line */
							line = in.nextLine();
							
							/* Close the file */
							in.close();
							
							/* Let the user know what was read */
							System.out.print(filename + " was read\n");
							System.out.print("The first line of the file is:\n");
							System.out.print(line + "\n");
						}
						
						/* Let the user know that the file doesn't exist */
						catch(FileNotFoundException e)
						{
							System.out.print(filename + " not found error\n");
						}
						
						/* Let the user know that there was another error */
						catch(IOException e)
						{
							System.out.print("Read string from the file error\n");
						}
						break;
						
					case 'W':
						//Serialize DeptManagement to a File
						System.out.print("Please enter a file name which we will write to:\n");
						filename = stdin.readLine().trim();
						try
						{
							/* Build the stream that can write objects (not text) to a disk */
							FileOutputStream bytesToDisk = new FileOutputStream(filename);
							ObjectOutputStream objectToBytes = new ObjectOutputStream(bytesToDisk);
							
							/* Write the object */
							objectToBytes.writeObject(deptManage1);
							
							/* Close the output stream */
							objectToBytes.close();
						}
						
						/* Let the user know that the object isn't serializable */
						catch(NotSerializableException e)
						{
							System.out.print("Not serializable exception\n");
						}
						
						/* Let the user know that there was another error */
						catch(IOException e)
						{
							System.out.print("Data file written exception\n");
						}
						break;
						
					case 'X':
						//Deserialize DeptManagement from a File
						System.out.print("Please enter a file name which we will read from:\n");
						filename = stdin.readLine().trim();
						try 
						{
							/* Create objects to read the file as bytes of information */
							FileInputStream diskToStreamOfBytes = new FileInputStream(filename);
							ObjectInputStream objectToBytes = new ObjectInputStream(diskToStreamOfBytes);
							
							/* Read the object */
							Object anyObject = objectToBytes.readObject();
							
							/* Cast from Object to the class that it is known to be */
							deptManage1 = (DeptManagement) anyObject;
							
							/* Close the input file */
							objectToBytes.close();
							
							/* Let the user know that the object was read */
							System.out.print(filename + " was read\n");
						}
						
						/* Let the user know that the object is of an unknow class */
						catch(ClassNotFoundException e)
						{
							System.out.print("Class not found exception\n");
						}
						
						/* Let the user know that the object is unserializable */
						catch(NotSerializableException e)
						{
							System.out.print("Not serializable exception\n");
						}
						
						/* Let the user know that there was another error in the reading process */
						catch(IOException e)
						{
							System.out.print("Data file read exception\n");
						}
						break;
						
					case '?':
						//Display Menu
						printMenu();
						break;
						
					default:
						System.out.print("Unknown action\n");
						break;
					}
				}
				else
				{
					System.out.print("Unknown action\n");
				}
				
			} while ( input1 != 'Q' || line . length () != 1);
		}
		catch(IOException exception)
		{
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" +
						 "------\t\t------\n" +
						 "A\t\tAdd a department\n" +
						 "C\t\tCreate a DeptManagement\n" +
						 "D\t\tSearch a department\n" +
						 "E\t\tSearch a faculty\n" +
						 "L\t\tList departments\n" +
						 "N\t\tSort by department names\n" +
						 "O\t\tSort by department faculty numbers\n" +
						 "P\t\tSort by current faculty name\n" +
						 "Q\t\tQuit\n" +
						 "R\t\tRemove a department\n" +
						 "T\t\tClose DeptManagement\n" +
						 "U\t\tWrite strings to a text file\n" +
						 "V\t\tRead strings from a text file\n" +
						 "W\t\tSerialize DeptManagement to a data file\n" +
						 "X\t\tDeserialize DeptManagement from a data file\n" +
						 "?\t\tDisplay Help\n");
	}
}