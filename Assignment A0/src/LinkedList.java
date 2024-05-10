//   Assignment: ASU CSE205 Spring 2021 #9
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: The LinkedList defines a linked list using its node class
//               object and also defines a iterator class to traverse the linked list.


import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
	/**
	 * Constructs an empty linked list.
	 */
	public LinkedList()
	{
		first = null;
	}
	
	/**
	 * Returns the first element in the linked list.
	 * @return the first element in the linked list
	 */
	public Object getFirst()
	{
		if (first == null)
			throw new NoSuchElementException();
		
		return first.data;
	}
	
	/**
	 * Removes the first element in the linked list.
	 * @return the removed element
	 */
	public Object removeFirst()
	{
		if (first == null)
			throw new NoSuchElementException();
		
		Object element = first.data;
		first = first.next;
		return element;
	}
	
	/**
	 * Adds an element to the front of the linked list.
	 * @param element the element to add
	 * */
	public void addFirst(Object element)
	{
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;	
	}
	
	
	/*************** Added methods *******************************/
	
	/**
	 * The add method adds the parameter string into the 
	 * linked list based on its alphabetical position.
	 * @param element the element to add
	 */
	public void add (String element)
	{
		/* Need 2 iterators to scroll through the linked list */
		ListIterator iterator = listIterator();
		ListIterator iterator2 = listIterator();
		
		/* Index to describe the number of times the second iterator has to go through */
		int index = 0;
		
		/* If the user selected this method instead of add first, just use that one */
		if (!iterator.hasNext())
		{
			addFirst(element);
		}
		
		/* If not, continue with the method */
		else
		{
			/* This only runs until the iterator runs out of elements */
			while (iterator.hasNext())
			{
				/* If this is the index where the element needs to be, break out of the loop */
				if (element.compareTo(iterator.next().toString()) < 1)
				{
					break;
				}
				
				/* Otherwise, make the index bigger */
				index++;
			}
			
			/* Use this new index to scroll through the second iterator */
			for (int i = 0; i < index; i++)
			{
				iterator2.next();
			}
			
			/* Add the element where the second iterator left off */
			iterator2.add(element);
		}
	}
	
	/**
	 * Counts how many times the parameter object appears
	 * in the linked list and returns that number.  If the
	 * number doesn't appear, it returns 0.
	 * @param element element to find
	 * @return number of times element is in linked list
	 */
	public int count(String element)
	{
		int count = 0; // Number of elements that match with the selected element
		
		ListIterator iterator = listIterator(); // iterator to go through the linked list
		
		/* The iterator goes through the whole linked list */
		while (iterator.hasNext())
		{
			/* 
			   If the element specified is the same as the current one iterated, add to
			   the counter.
			*/
			if (element.equals(iterator.next().toString()))
			{
				count++;
			}
		}
		
		return count; // Return the count
	}
	
	/**
	 * Returns the index of the parameter object in the linked
	 * list if it exists.  It returns -1 if it does not exist.
	 * @param element element to find
	 * @return index of the element in the linked list
	 */
	public int search (String element)
	{
		int index = 0; // This represents the index of the element in question
		
		ListIterator iterator = listIterator(); // iterator to go through the linked list
		
		/* The iterator goes through the whole linked list */
		while (iterator.hasNext())
		{
			/* If we find a match, return the index where it was found */
			if (element.equals(iterator.next().toString()))
			{
				return index;
			}
			
			/* Otherwise increment the index */
			index++;
		}
		
		/*
		   If the method gets this far, that means that the element wasn't in the list.
		   In that case, return -1. 
		*/
		return -1;
	}
	
	/**
	 * Removes the element at the parameter index in the linked list.
	 * @param index of the element to remove
	 * @return the removed element
	 */
	public String remove (int index)
	{
		ListIterator iterator = listIterator(); // iterator to go through the linked list
		
		/*
		   String containing the element that was removed and also helps jump start
		   the iterating process.
		*/
		String removed = iterator.next().toString();
		
		/* iterate through the linked list index amount of times */
		for(int i = 0; i < index; i++)
		{
			/* Keep updating the removed string */
			if (iterator.hasNext())
			{
				removed = iterator.next().toString();
			}
			
			/* 
			   If this else is reached, then the index is bigger than the list, and 
			   thus there is no element there. 
			*/
			else
			{
				return null;
			}
		}
		
		/* If the loop exists successfully, removed the element at that place. */
		iterator.remove();
		
		return removed; // Return the string that was removed
	}
	
	/**
	 * Returns the size of the linked list
	 * @return size of the linked list
	 */
	public int size()
	{
		int count = 0; // Number counting the elements in the linked list
		
		ListIterator iterator = listIterator(); // iterator to go through the linked list
		
		/* Goes through the whole linked list and counts each element. */
		while (iterator.hasNext())
		{
			count++;
			iterator.next();
		}
		
		return count; // Return the number of elements in the array
	}
	
	/**
	 * Returns a string representation of the linked list.
	 */
	public String toString()
	{
		String returnString = "{ "; // String representation of the object
		
		ListIterator iterator = listIterator(); // iterator to go through the linked list
		
		/* Goes through the whole linked list, adding string representations of each element to the returnedString */
		while (iterator.hasNext())
		{
			returnString += iterator.next().toString() + " ";
		}
		
		/* Adds to the end of the string */
		returnString += "}\n";
		
		return returnString; // Returns the returnString
	}	
	
	/**
	 * Removed the parameter specified number of elements from the end of the linked list.
	 * @param howMany number of elements to remove
	 */
	public void removeLastFew(int howMany)
	{
		int size = size(); // Size of the linked list
		
		/* If the user types something that is less than 0, don't change anything */
		if(howMany <= 0)
		{
			return;
		}
		
		/* If the user is the size of the list or bigger, clear the list */
		else if (howMany >= size)
		{
			first = null;
			return;
		}
		
		int index = size - howMany; // Index from where to start removing stuff from
		
		/* Removes elements at the right index a specified amount of times */
		for (int i = 0; i < howMany; i++)
		{
			remove(index);
		}
	}
     

   /***************************************************************/

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   private Node first;

   private class Node
   {
      public Object data;
      public Node next;
   }

   private class LinkedListIterator implements ListIterator
   {
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

      private Node position;
      private Node previous;
   }
}