//   Assignment: ASU CSE205 Spring 2021 #11
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The pair class pairs a row number and a column number.

public class Pair
 {
  private int row;
  private int col;

  //Initializes the pair object using two parameters
  public Pair(int row, int col)
   {
     this.row = row;
     this.col = col;
   }

  //Accessor method for the row number
  public int getRow()
   {
     return row;
   }

  //Accessor method for the column number
  public int getColumn()
   {
     return col;
   }
 }
