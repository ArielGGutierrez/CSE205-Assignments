//   Assignment: ASU CSE205 Spring 2021 #9
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The ListIterator interface allows access of a position in a linked list.
//               This interface contains a subset of the methods of the standard
//               java.util.ListIterator interface. The methods for backward traversal are not included.

public interface ListIterator
{
   //Move Moves the iterator past the next element.
   Object next();

   // Tests if there is an element after the iterator position.
   boolean hasNext();

   // Adds an element before the iterator position
   // and moves the iterator past the inserted element.
   void add(Object element);


   // Removes the last traversed element. This method may
   // only be called after a call to the next() method.
   void remove();

   // Sets the last traversed element to a different value.
   void set(Object element);
}
