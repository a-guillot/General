package Iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import util.LinearNode;

public class LinkedIterator<T> implements Iterator<T> {

	private int count;
	private LinearNode<T> current;
	
	/**
	 * Sets up the iterator using the specified items
	 * @param collection the collection the iterator will move over
	 * @param size the integer size of the collection
	 */
	public LinkedIterator(LinearNode<T> collection, int size) {
		count = size;
		current = collection;
	}
	
	@Override
	/**
	 * Returns true if this iteration has at least one more element
	 */
	public boolean hasNext() {
		return (current != null);
	}

	/**
	 * Returns the next element in this iteration. If there are no
	 * more elements, throw a NoSuchElementException
	 */
	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		
		T result = current.getElement();
		current = current.getNext();
		
		return result;
	}

}
