package Set;

import java.util.Iterator;

public interface SetADT<T> extends Iterable<T> {

	/**
	 * Adds one element to the set, ignoring duplicates
	 * @param element the element to be added to the set
	 */
	public void add(T element);
	
	/**
	 * Adds the content of the parameter to this set
	 * @param set the collection to be added to the set
	 */
	public void addAll(SetADT<T> set);
	
	/**
	 * Removes and returns the specified element of this set
	 * @param element the element to be removed from the set
	 * @return the element to be removed from the set
	 */
	public T remove(T element);
	
	/**
	 * Returns the union of this set and the parameter
	 * @param set the set to be unioned with this set
	 * @return a set that is the union of this set and the parameter
	 */
	public SetADT<T> union(SetADT<T> set);
	
	/**
	 * Returns true if this set contains the parameter
	 * @param element the element being sought in this set
	 * @return true if this set contains the parameter
	 */
	public boolean contains(T element);
	
	/**
	 * Returns true if this set and the parameter contain exactly
	 * the same elements
	 * @param set the set to be compared with this set
	 * @return true if this set and the parameter contain exactly
	 * the same elements
	 */
	public boolean equals(SetADT<T> set);
	
	/**
	 * Returns true if every element of this set is contained in the other
	 * @param set set to be compared
	 * @return true if every element of this set is contained in the other	
	 */
	public boolean isSubset(SetADT<T> set);
	
	/**
	 * Returns a set containing all the elements that are in common
	 * @param set set to be compared with the instance
	 * @return a set containing all the elements that are in common
	 */
	public SetADT<T> intersection(SetADT<T> set);
	
	/**
	 * Returns if this set contains no element
	 * @return true if no element
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this set
	 * @return an iterator for the elements in this set
	 */
	public int size();
	
	/**
	 * 	Returns an iterator for the elements of this set
	 * 
	 * @return an iterator
	 */
	public Iterator<T> iterator();
}
