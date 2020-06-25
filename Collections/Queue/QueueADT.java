package Queue;

import util.EmptyCollectionException;

public interface QueueADT<T> {

	/**
	 * Adds one element to the rear of the queue
	 * @param element the element to be added to the rear of this queue
	 * @throws  
	 */
	public void enqueue(T element);
	
	/**
	 * Removes and returns the element at the front of this queue.
	 * @return the element at the front of this queue
	 * @throws EmptyCollectionException if you try to dequeue on empty stack
	 */
	public T dequeue() throws EmptyCollectionException;
	
	/**
	 * Returns without removing the element at the front of this queue
	 * @return the first element in this queue
	 * @throws EmptyCollectionException if try to see the first on empty stack
	 */
	public T first() throws EmptyCollectionException;
	
	/**
	 * Returns true if this queue contains no element
	 * @return true if this queue is empty
	 */
	
	public int indexOf(T element);
	
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this queue
	 * @return the integer representation of the size of this queue
	 */
	public int size();
	
	/**
	 * Returns a string representation of this queue
	 * @return the string representation of this queue
	 */
	public String toString();
}
