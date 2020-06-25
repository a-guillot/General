package List;

import java.util.Iterator;

import util.ElementNotFoundException;

/**
 * ListADT defines the interface to a general list collection.
 * Specific types of lists will extend this interface to complete
 * the set of necessary operations.
 * @author Andréas
 *
 */
public interface ListADT<T> {

	/**
	 * Removes and returns the first element from this list
	 * @return the first element from this list
	 */
	public T removeFirst();
		
	/**
	 * Removes and returns the last element from this list
	 * @return the last element from this list
	 */
	public T removeLast();
	
	/**
	 * Removes and returns the specified element for this list
	 * @param element the element to be removed from the list
	 * @return element from the list
	 * @throws ElementNotFoundException 
	 */
	public T remove(T element) throws ElementNotFoundException;
	
	/**
	 * Returns a reference to the first element of this list
	 * @return the first element
	 */
	public T first();
	
	/**
	 * Returns a reference to the last element of the list
	 * @return the last element
	 */
	public T last();
	
	/**
	 * Returns true if this list contains the specified target element
	 * @param target the targer that is being sought
	 * @return true if it contains this element
	 */
	public boolean contains(T target);
	
	/**
	 * Returns true if the list is empty
	 * @return true if this list contains no element
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of element in this list
	 * @return the integer representation of the number of element
	 */
	public int size();
	
	/**
	 * Returns an iterator for the elements of this list
	 * @return an iterator
	 */
	public Iterator<T> iterator();
	
	/**
	 * String representation of the list
	 * @return String representation of the list
	 */
	public String toString();
}





